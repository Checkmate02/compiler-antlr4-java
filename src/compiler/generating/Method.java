package compiler.generating;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import compiler.VariableDeclaration;

public class Method implements Serializable, MochalovICode {

	@Serial
	private static final long serialVersionUID = 1L;
	private final List<VariableDeclaration> catalog;
	private final List<Regulations> instList;
	private final List<Integer> varList;
	private int PC = 0;

	public Method() {
		catalog = new ArrayList<>();
		instList = new ArrayList<>();
		varList = new ArrayList<>();
	}

	public int getPC()
	{
		return PC;
	}

	public void setPC(int pc)
	{
		PC = pc;
	}

	public List<Regulations> getInstList()
	{
		return instList;
	}

	public void setInstList(Regulations inst)
	{
		instList.add(inst);
	}

	public List<VariableDeclaration> getCatalog()
	{
		return catalog;
	}

	public void setCatalog(List<VariableDeclaration> catalog)
	{
		this.catalog.addAll(catalog);
	}

	public List<Integer> getVarList()
	{
		return varList;
	}

	public Regulations getInstruction(int n)
	{
		return instList.get(n);
	}

}
