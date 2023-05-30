package compiler;

import compiler.generating.Calculating;

public class Interpreter {

	public static void main(String[] args) throws Exception {
		Calculating calculating = new Calculating("files/FactorialFibonacci.micode");
		calculating.executable();
	}

}
