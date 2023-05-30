package grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MochalovParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MochalovVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MochalovParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MochalovParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#mainClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainClass(MochalovParser.MainClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#mainMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainMethod(MochalovParser.MainMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(MochalovParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MochalovParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(MochalovParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#localDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDeclaration(MochalovParser.LocalDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(MochalovParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(MochalovParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(MochalovParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MochalovParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MochalovParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MochalovParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(MochalovParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(MochalovParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#arrayAssignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignmentStatement(MochalovParser.ArrayAssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#variableAssignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssignmentStatement(MochalovParser.VariableAssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(MochalovParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MochalovParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#ifElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStatement(MochalovParser.IfElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#nestedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedStatement(MochalovParser.NestedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MochalovParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#methodCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallStatement(MochalovParser.MethodCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objectInstantiationExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectInstantiationExpression(MochalovParser.ObjectInstantiationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greaterthanExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterthanExpression(MochalovParser.GreaterthanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayInstantiationExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInstantiationExpression(MochalovParser.ArrayInstantiationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(MochalovParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodCallExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallExpression(MochalovParser.MethodCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(MochalovParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivExpression(MochalovParser.DivExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolLitExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLitExpression(MochalovParser.BoolLitExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesesExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesesExpression(MochalovParser.ParenthesesExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(MochalovParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(MochalovParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAccessExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccessExpression(MochalovParser.ArrayAccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(MochalovParser.StringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpression(MochalovParser.AddExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldAccessExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccessExpression(MochalovParser.FieldAccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code thisExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExpression(MochalovParser.ThisExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessThanExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThanExpression(MochalovParser.LessThanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(MochalovParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code characterExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterExpression(MochalovParser.CharacterExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerLitExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLitExpression(MochalovParser.IntegerLitExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpression(MochalovParser.SubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulExpression}
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpression(MochalovParser.MulExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MochalovParser#methodCallParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallParams(MochalovParser.MethodCallParamsContext ctx);
}