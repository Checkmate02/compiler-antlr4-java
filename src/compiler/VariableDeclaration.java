package compiler;

import java.io.Serial;

public class VariableDeclaration extends Node {
	@Serial
	private static final long serialVersionUID = 1L;

	public VariableDeclaration(String name, String type) {
		super(name, type);
	}

}
