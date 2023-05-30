package compiler;

import java.io.Serial;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomClass extends Node {
	@Serial
	private static final long serialVersionUID = 1L;
	private final Map<String, Function> methodList;
	private final Map<String, VariableDeclaration> fieldList;

	public CustomClass(String name, String type) {
		super(name, type);
		methodList = new LinkedHashMap<>();
		fieldList = new LinkedHashMap<>();
	}

	public void putOnField(String fName, VariableDeclaration field) {
		fieldList.put(fName, field);
	}

	public void putOnMethod(String mName, Function currentMethod) {
		methodList.put(mName, currentMethod);
	}

	public Map<String, Function> getMethodList() {
		return methodList;
	}
}
