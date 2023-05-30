package compiler;

public class Symbol {

	private final Scoping root;
	private Scoping current;
	
	public Symbol() {
		root = new Scoping(null);
		current = root;
	}

	public void enterScope() {
		current = current.nextChild();
	}

	public void exitScope() {
		current = current.getParent();
	}

	public void put(String key, Node item) {
		current.put(key, item);
	}

	public Node lookup(String key) {
		return current.watch_up(key);
	}

	public void printTable() {
		System.out.format("| NAME                        | TYPE                | SCOPE                      |%n");
		root.print();
	}

	public void resetTable() {
		current = root; root.reset();
	}

	public void setCurrentClass(Node cRec)
	{
		current.setContainingClass(cRec);
	}

	public Node getCurrentClass()
	{
		return current.getContainingClass();
	}
}
