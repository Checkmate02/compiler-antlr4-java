package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MochalovParser}.
 */
public interface MochalovListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MochalovParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MochalovParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MochalovParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(MochalovParser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(MochalovParser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#mainMethod}.
	 * @param ctx the parse tree
	 */
	void enterMainMethod(MochalovParser.MainMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#mainMethod}.
	 * @param ctx the parse tree
	 */
	void exitMainMethod(MochalovParser.MainMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(MochalovParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(MochalovParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MochalovParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MochalovParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(MochalovParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(MochalovParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#localDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalDeclaration(MochalovParser.LocalDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#localDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalDeclaration(MochalovParser.LocalDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(MochalovParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(MochalovParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MochalovParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MochalovParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(MochalovParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(MochalovParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MochalovParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MochalovParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(MochalovParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(MochalovParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MochalovParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MochalovParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(MochalovParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(MochalovParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(MochalovParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(MochalovParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#arrayAssignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignmentStatement(MochalovParser.ArrayAssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#arrayAssignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignmentStatement(MochalovParser.ArrayAssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#variableAssignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssignmentStatement(MochalovParser.VariableAssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#variableAssignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssignmentStatement(MochalovParser.VariableAssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(MochalovParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(MochalovParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MochalovParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MochalovParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStatement(MochalovParser.IfElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStatement(MochalovParser.IfElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#nestedStatement}.
	 * @param ctx the parse tree
	 */
	void enterNestedStatement(MochalovParser.NestedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#nestedStatement}.
	 * @param ctx the parse tree
	 */
	void exitNestedStatement(MochalovParser.NestedStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MochalovParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MochalovParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#methodCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallStatement(MochalovParser.MethodCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#methodCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallStatement(MochalovParser.MethodCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objectInstantiationExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterObjectInstantiationExpression(MochalovParser.ObjectInstantiationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objectInstantiationExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitObjectInstantiationExpression(MochalovParser.ObjectInstantiationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterthanExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterthanExpression(MochalovParser.GreaterthanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterthanExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterthanExpression(MochalovParser.GreaterthanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayInstantiationExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayInstantiationExpression(MochalovParser.ArrayInstantiationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayInstantiationExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayInstantiationExpression(MochalovParser.ArrayInstantiationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(MochalovParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(MochalovParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodCallExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallExpression(MochalovParser.MethodCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodCallExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallExpression(MochalovParser.MethodCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(MochalovParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(MochalovParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivExpression(MochalovParser.DivExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivExpression(MochalovParser.DivExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolLitExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolLitExpression(MochalovParser.BoolLitExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolLitExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolLitExpression(MochalovParser.BoolLitExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesesExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesesExpression(MochalovParser.ParenthesesExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesesExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesesExpression(MochalovParser.ParenthesesExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(MochalovParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(MochalovParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(MochalovParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(MochalovParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAccessExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessExpression(MochalovParser.ArrayAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAccessExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessExpression(MochalovParser.ArrayAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(MochalovParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(MochalovParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(MochalovParser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(MochalovParser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fieldAccessExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccessExpression(MochalovParser.FieldAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fieldAccessExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccessExpression(MochalovParser.FieldAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpression(MochalovParser.ThisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpression(MochalovParser.ThisExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessThanExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLessThanExpression(MochalovParser.LessThanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessThanExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLessThanExpression(MochalovParser.LessThanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(MochalovParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(MochalovParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code characterExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCharacterExpression(MochalovParser.CharacterExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code characterExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCharacterExpression(MochalovParser.CharacterExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerLitExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLitExpression(MochalovParser.IntegerLitExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerLitExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLitExpression(MochalovParser.IntegerLitExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubExpression(MochalovParser.SubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubExpression(MochalovParser.SubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulExpression(MochalovParser.MulExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulExpression}
	 * labeled alternative in {@link MochalovParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulExpression(MochalovParser.MulExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MochalovParser#methodCallParams}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallParams(MochalovParser.MethodCallParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MochalovParser#methodCallParams}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallParams(MochalovParser.MethodCallParamsContext ctx);
}