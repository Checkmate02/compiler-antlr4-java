package compiler;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class Function extends Node {

	@Serial
	private static final long serialVersionUID = 1L;
	private final List<VariableDeclaration> paramList;
	private final List<VariableDeclaration> varList;
	private final List<VariableDeclaration> list;

	public Function(String id, String type) {
		super(id, type);
		paramList = new ArrayList<>();
		varList = new ArrayList<>();
		list = new ArrayList<>();
	}
	
	public void putParam(VariableDeclaration param){
		paramList.add(param);
	}
	
	public void putVar(VariableDeclaration var){
		varList.add(var);
	}

	public List<VariableDeclaration> getParamList() {
		return paramList;
	}

	public List<VariableDeclaration> getVarList() {
		return varList;
	}

	public List<VariableDeclaration> getList() {
		return list;
	}

	public void setList(List<VariableDeclaration> list) {
		this.list.addAll(list);
	}

}
