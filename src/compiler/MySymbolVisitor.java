package compiler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import grammar.MochalovBaseVisitor;
import grammar.MochalovParser.*;

@SuppressWarnings("rawtypes")
public class MySymbolVisitor extends MochalovBaseVisitor {
	Symbol symbol;
	CustomClass currentClass;
	Function currentMethod;
	boolean errorFlag;

	public MySymbolVisitor() {
		super();
		this.symbol = new Symbol();
		this.currentClass = null;
		this.currentMethod = null;
		this.errorFlag = false;
	}

	public boolean getErrorFlag() {
		return this.errorFlag;
	}

	@Override
	public Object visitProgram(ProgramContext ctx) {
		int i = 0;
		int n = ctx.getChildCount();
		visitMainClass((MainClassContext) ctx.getChild(i++));
		for (; i < n; i++)
			visitClassDeclaration((ClassDeclarationContext) ctx.getChild(i));
		return symbol;
	}

	@Override
	public Object visitMainClass(MainClassContext ctx) {
		int i = 0;
		i++;
		String cName = ctx.getChild(i++).getText(); // CLASS NAME

		currentClass = new CustomClass(cName, cName);
		symbol.put(cName, currentClass);
		symbol.enterScope();
		symbol.setCurrentClass(currentClass);
		i++;
		visitMainMethod((MainMethodContext) ctx.getChild(i++));
		i++;
		symbol.exitScope();
		return null;
	}

	@Override
	public Object visitClassDeclaration(ClassDeclarationContext ctx) {
		int i = 0;
		int n = ctx.getChildCount();

		i++;
		String cName = ctx.getChild(i++).getText();
		currentClass = new CustomClass(cName, cName);
		if (symbol.lookup(cName) != null) {
			errorFlag = true;
			System.err.println("[Duplicated]: Class name \"" + cName + "\" already defined");
		} else {
			symbol.put(cName, currentClass);
			symbol.enterScope();
			symbol.setCurrentClass(currentClass);
		}
		i++;
		for (; i < n - 1; i++) {
			ParseTree child = ctx.getChild(i);
			if (child instanceof FieldDeclarationContext)
				visitFieldDeclaration((FieldDeclarationContext) child);
			else
				visitMethodDeclaration((MethodDeclarationContext) child);
		}
		i++;
		symbol.exitScope();
		return null;
	}

	@Override
	public Object visitMainMethod(MainMethodContext ctx) {
		int i = 0;
		currentMethod = new Function("main", null);
		if (symbol.lookup(currentClass.getId() + ".main") != null) {
			errorFlag = true;
			System.err.println("main method already defined!");
		} else {
			symbol.put(currentClass.getId() + ".main", currentMethod);
			currentClass.putOnMethod("main", currentMethod);
			i += 11;

			symbol.enterScope();
			while (ctx.getChild(i) instanceof StatementContext) visitStatement((StatementContext) ctx.getChild(i++));

			i++;
			symbol.exitScope();
		}
		return null;
	}

	@Override
	public Object visitStatement(StatementContext ctx) {
		ParseTree child = ctx.getChild(0);
		visit(child);
		return null;
	}

	@Override
	public Object visitFieldDeclaration(FieldDeclarationContext ctx) {
		int i = 0;
		String type = (String) visitType((TypeContext) ctx.getChild(i++));
		String name = ctx.getChild(i++).getText();
		i++;
		VariableDeclaration var = new VariableDeclaration(name, type);
		if (symbol.lookup(name) != null)
		{
			errorFlag = true;
			System.err.println("[Duplicated] Field Variable \"" + name + "\" already defined");
		} else
		{
			symbol.put(name, var);
			currentClass.putOnField(name, var);
		}
		return null;
	}

	@Override
	public Object visitLocalDeclaration(LocalDeclarationContext ctx) {
		int i = 0;
		String type = (String) visitType((TypeContext) ctx.getChild(i++));
		String name = ctx.getChild(i++).getText();
		i++;
		VariableDeclaration var = new VariableDeclaration(name, type);
		if (symbol.lookup(name) != null) {
			errorFlag = true;
			System.err.println("[Duplicated] Field Variable \"" + name + "\" already defined");
		} else {
			symbol.put(name, var);
			currentMethod.putVar(var);
		}
		return null;
	}

	@Override
	public Object visitMethodDeclaration(MethodDeclarationContext ctx) {
		int i = 0;
		if (ctx.getChild(0) instanceof TerminalNodeImpl && ctx.getChild(0).getText().equals("public")) i++;
		ParseTree methodReturnType = ctx.getChild(i++);
		String returnType;
		if (methodReturnType instanceof TerminalNodeImpl) returnType = null;
		else returnType = (String) visitType((TypeContext) methodReturnType);
		String mName = ctx.getChild(i++).getText();
		if (currentClass.getId().equals(mName)) {
			errorFlag = true;
			System.err.println("The method name is the same as class name! we do not have construcotrs in Mochalov Language");
		}
		i++;
		currentMethod = new Function(mName, returnType);
		if (symbol.lookup(currentClass.getId() + "." + mName) != null) {
			errorFlag = true;
			System.err.println("[Duplicated] Method name \"" + mName
					+ "\" already defined");
		} else {
			symbol.put(currentClass.getId() + "." + mName, currentMethod);
			currentClass.putOnMethod(mName, currentMethod);
			symbol.enterScope();
			symbol.setCurrentClass(currentClass);
			if (ctx.getChild(i) instanceof ParameterListContext) {
				visitParameterList((ParameterListContext) ctx.getChild(i++));
			}
			i += 2;
			visitMethodBody((MethodBodyContext) ctx.getChild(i++));
			i++;
			symbol.exitScope();
		}
		return null;
	}

	@Override
	public Object visitType(TypeContext ctx) {
		return ctx.getText();
	}

	@Override
	public Object visitParameterList(ParameterListContext ctx) {
		int n = ctx.getChildCount();
		for (int i = 0; i < n; i += 2) visitParameter((ParameterContext) ctx.getChild(i));
		return null;
	}

	@Override
	public Object visitParameter(ParameterContext ctx) {
		int i = 0;
		String type = (String) visitType((TypeContext) ctx.getChild(i++));
		String name = ctx.getChild(i++).getText();
		VariableDeclaration var = new VariableDeclaration(name, type);
		if (symbol.lookup(name) != null) {
			errorFlag = true;
			System.err.println("[Duplicated] parameter name \"" + name + "'\" already defined");
		} else {
			symbol.put(name, var);
			currentMethod.putParam(var);
		}
		return null;
	}

	@Override
	public Object visitMethodBody(MethodBodyContext ctx) {
		int i = 0;
		int n = ctx.getChildCount();
		for (; i < n; i++) {
			ParseTree child = ctx.getChild(i);
			visit(child);
		}
		return null;
	}

	@Override
	public Object visitNestedStatement(NestedStatementContext ctx) {
		int i = 0;
		int n = ctx.getChildCount();
		i++;
		for (; i < n - 1; i++)
			if (ctx.getChild(i) instanceof StatementContext) visitStatement((StatementContext) ctx.getChild(i));

		return null;
	}

	@Override
	public Object visitIdentifier(IdentifierContext ctx) {
		return ctx.getText();
	}

	@Override
	public Object visitIdentifierExpression(IdentifierExpressionContext ctx) {
		if (ctx.getChildCount() > 1)
			return ctx.getChild(1).getText();
		return ctx.getChild(0).getText();
	}

}
