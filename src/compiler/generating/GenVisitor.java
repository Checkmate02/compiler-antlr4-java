package compiler.generating;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import compiler.*;
import grammar.MochalovBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import grammar.MochalovParser.*;

@SuppressWarnings("rawtypes")
public class GenVisitor extends MochalovBaseVisitor implements MochalovICode {

	private Symbol tab;
	private Function currMethod;
	private String currClass;
	private File classFile;
	private int nexty;

	private final String truex = "true";
	private final String falsex = "false";

	public GenVisitor(Symbol visitedST) {
		this.setTab(visitedST);
		this.setClassfile(new File());
		setIC(0);
	}

	@Override
	public Object visitMethodDeclaration(MethodDeclarationContext ctx) {
		int i = 0;
		if (ctx.getChild(0) instanceof TerminalNodeImpl && ctx.getChild(0).getText().equals("public")) i++;
		i++;
		String mName = ctx.getChild(i++).getText();
		setCurrMethod((Function) tab.lookup(currClass + "."
				+ mName));
		currMethod.setList(currMethod.getParamList());
		currMethod.setList(currMethod.getVarList());
		compiler.generating.Method method = new compiler.generating.Method();
		method.setCatalog(currMethod.getList());
		for (int k = 0; k < method.getCatalog().size(); k++) method.getVarList().add(k, 0);
		classFile.addMethod(currClass + "." + currMethod.getId(), method);

		nexty = 0;
		for (int j = currMethod.getParamList().size() - 1; j >= 0; j--)
		{
			addInstruction(STORE, j);
			nexty++;
		}
		tab.enterScope();
		while (!(ctx.getChild(i) instanceof MethodBodyContext)) i++;
		visitMethodBody((MethodBodyContext) ctx.getChild(i));
		tab.exitScope();
		return null;
	}

	@Override
	public Object visitMethodCallExpression(MethodCallExpressionContext ctx) {
		int i = 0;
		String className = (String) visit(ctx.getChild(i++));
		CustomClass customClassRec = (CustomClass) tab.lookup(className);
		Function mRec;
		int n = ctx.getChildCount();
		i = i + 1;
		for (; i < n; i++) {
			String mName = ctx.getChild(i).getText();
			mRec = customClassRec.getMethodList().get(mName);
			i += 1;
			visitMethodCallParams((MethodCallParamsContext) ctx.getChild(i));
			addInstruction(INVOKE, className + "." + mName);
			nexty++;
			className = mRec.getType();
		}
		return null;
	}

	@Override
	public Object visitVariableAssignmentStatement(VariableAssignmentStatementContext ctx) {
		String LHS = ctx.getChild(0).getChild(0).getText();
		VariableDeclaration lookup = (VariableDeclaration) tab.lookup(LHS);
		visit(ctx.getChild(2));
		addInstruction(STORE, currMethod.getList().indexOf(lookup));
		nexty++;
		return null;
	}

	@Override
	public Object visitIdentifier(IdentifierContext ctx) {
		String varName = ctx.getText();
		Node varRec = tab.lookup(varName);
		return null;
	}
	
	@Override
	public Object visitThisExpression(ThisExpressionContext ctx) {
		return tab.getCurrentClass().getId();
	}

	@Override
	public Object visitIdentifierExpression(IdentifierExpressionContext ctx) {
		String varName = ctx.getText();
		Node varRec = tab.lookup(varName);
		if (varRec == null) return null;
		addInstruction(LOAD, currMethod.getList().indexOf(varRec));
		nexty++;
		return null;
	}

	@Override
	public Object visitIntegerLitExpression(IntegerLitExpressionContext ctx) {
		int value = Integer.parseInt(ctx.getText());
		addInstruction(CONST, value);
		nexty++;
		return null;
	}

	@Override
	public Object visitBoolLitExpression(BoolLitExpressionContext ctx) {
		String value = ctx.getText();
		if (value.equals(truex)) addInstruction(CONST, 1);
		if (value.equals(falsex)) addInstruction(CONST, 0);

		nexty++;
		return null;
	}

	@Override
	public Object visitReturnStatement(ReturnStatementContext ctx) {
		visit(ctx.getChild(1));
		addInstruction(RETURN, null);
		nexty++;
		return null;
	}

	@Override
	public Object visitWhileStatement(WhileStatementContext ctx) {
		int go_to = nexty;
		visit(ctx.getChild(2));
		int ifFail = nexty;
		addInstruction(IF_FALSE, null); nexty++;
		visit(ctx.getChild(4)); addInstruction(GOTO, go_to); nexty++;
		compiler.generating.Method method = classFile.getMethods().get(currClass + "." + currMethod.getId());
		method.getInstList().get(ifFail).setArgument(nexty);
		return null;
	}

	@Override
	public Object visitPrintStatement(PrintStatementContext ctx) {
		visit(ctx.getChild(2));
		addInstruction(PRINT, null); nexty++;
		return null;
	}

	@Override
	public Object visitIfElseStatement(IfElseStatementContext ctx) {
		visit(ctx.getChild(2));
		int ifLabel = nexty;
		addInstruction(IF_FALSE, null); nexty++;
		visit(ctx.getChild(4)); int gotoLabel = nexty;
		addInstruction(GOTO, null); nexty++;
		compiler.generating.Method method = classFile.getMethods().get(currClass + "." + currMethod.getId());
		method.getInstList().get(ifLabel).setArgument(nexty);
		if (ctx.getChildCount() > 4) {
			visit(ctx.getChild(6));
			method.getInstList().get(gotoLabel).setArgument(nexty);
		}
		return null;
	}

	@Override
	public Object visitLessThanExpression(LessThanExpressionContext ctx) {
		int n = ctx.getChildCount();
		visit(ctx.getChild(0));
		if (n > 3) visit(ctx.getChild(3));
		else visit(ctx.getChild(2));
		addInstruction(ILT, null);
		nexty++;
		return null;
	}

	@Override
	public Object visitMulExpression(MulExpressionContext ctx) {
		visit(ctx.getChild(0));
		visit(ctx.getChild(2));
		addInstruction(MULTI, null);
		nexty++;
		return null;
	}

	@Override
	public Object visitAddExpression(AddExpressionContext ctx) {
		visit(ctx.getChild(0));
		visit(ctx.getChild(2));
		addInstruction(ADD, null);
		nexty++;
		return null;
	}

	@Override
	public Object visitDivExpression(DivExpressionContext ctx) {
		visit(ctx.getChild(0));
		visit(ctx.getChild(2));
		addInstruction(DIV, null);
		nexty++;
		return null;
	}

	@Override
	public Object visitSubExpression(SubExpressionContext ctx) {
		visit(ctx.getChild(0));
		visit(ctx.getChild(2));
		addInstruction(SUB, null);
		nexty++;
		return null;
	}

	@Override
	public Object visitNotExpression(NotExpressionContext ctx) {
		visit(ctx.getChild(1));
		addInstruction(NO, null);
		nexty++;
		return null;
	}

	@Override
	public Object visitMainClass(MainClassContext ctx) {
		setCurrClass(ctx.getChild(1).getText());
		tab.enterScope();
		visitMainMethod((MainMethodContext) ctx.getChild(3));
		tab.exitScope();
		addInstruction(STOP, null);
		nexty++;
		return null;
	}

	@Override
	public Object visitMainMethod(MainMethodContext ctx) {
		setCurrMethod((Function) tab.lookup(currClass + ".main"));
		compiler.generating.Method method = new compiler.generating.Method();
		classFile.addMethod(currClass + "." + currMethod.getId(), method);
		classFile.setMainMethod(method);
		tab.enterScope();
		for (int i = 0; i < ctx.getChildCount(); i++) {
			if (ctx.getChild(i) instanceof StatementContext) {
				visitStatement((StatementContext) ctx.getChild(i));
			}
		}
		tab.exitScope();
		return null;
	}

	@Override
	public Object visitClassDeclaration(ClassDeclarationContext ctx) {
		int i = 1;
		int n = ctx.getChildCount();
		currClass = ctx.getChild(i++).getText();
		i++;
		tab.enterScope();
		for (; i < n - 1; i++) {
			ParseTree child = ctx.getChild(i);
			if (child instanceof FieldDeclarationContext) System.err.println(errorMessage(child) +
					"We should not have Field-Declaration");
			else visitMethodDeclaration((MethodDeclarationContext) child);
		}
		tab.exitScope();
		return null;
	}

	@Override
	public Object visitObjectInstantiationExpression(ObjectInstantiationExpressionContext ctx) {
		return ctx.getChild(1).getText();
	}

	private String errorMessage(ParseTree ctx) {
		return "err - " + ((ParserRuleContext) ctx).getStart().getLine()
				+ " : " + ((ParserRuleContext) ctx).getStop().getCharPositionInLine();
	}

	private void addInstruction(int code, Object arg) {
		Regulations inst = new Regulations(code, arg);
		compiler.generating.Method method = classFile.getMethods().get(
				currClass + "." + currMethod.getId());
		method.setInstList(inst);
	}

	public void writeFile(String fileName) {
		FileOutputStream fileToGo;
		ObjectOutputStream objectOut;
		try {
			java.io.File file = new java.io.File(fileName + ".micode");
			file.getParentFile().mkdirs();
			fileToGo = new FileOutputStream(file,false);
			objectOut = new ObjectOutputStream(fileToGo); objectOut.writeObject(classFile); objectOut.close();
		} catch (Exception e) {
			System.err.println("Ошибка в создании '" + fileName + ".micode' ");
			e.printStackTrace();
		}
	}

	public void setClassfile(File classfile)
	{
		this.classFile = classfile;
	}

	public void setCurrClass(String currClass) {
		this.currClass = currClass;
	}

	public void setCurrMethod(Function currFunction) {
		this.currMethod = currFunction;
	}

	public void setTab(Symbol tab) {
		this.tab = tab;
	}

	public void setIC(int iC) {
		nexty = iC;
	}
}
