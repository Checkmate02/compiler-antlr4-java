package compiler;

import java.io.IOException;

import compiler.generating.GenVisitor;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;

import grammar.MochalovLexer;
import grammar.MochalovParser;

public class Generation {

	public static void main(String[] args) {

		CharStream input;
		String fileName;

		try {
			String file = "files/FactorialFibonacci.mochalov";
			input = CharStreams.fromFileName(file);
			fileName = file.substring(0, file.lastIndexOf('.'));
		} catch (IOException e) {
			System.out.println("Непредвиденная ошибка! Проверьте путь к файлу!");
			return;
		}

		// Лексер
		MochalovLexer lexer = new MochalovLexer(input);
		// Лексер в парсер
		MochalovParser parser = new MochalovParser(new BufferedTokenStream(lexer));
		// Составляем дерево из парсера
		ParseTree tr = parser.program();
		Trees.inspect(tr, parser);

		MySymbolVisitor mySymbolVisitor = new MySymbolVisitor();
		Symbol visitedST = (Symbol) mySymbolVisitor.visit(tr);

		if (mySymbolVisitor.getErrorFlag()) System.err.println("Присутствуют ошибки!");
		else {
			visitedST.printTable();
			visitedST.resetTable();
			GenVisitor cgv = new GenVisitor(visitedST);
			cgv.visit(tr);
			cgv.writeFile(fileName);
		}
	}
}
