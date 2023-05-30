package compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scoping {

	private int next = 0;
	private Scoping parent;
	private final List<Scoping> children;
	private final Map<String, Node> records;

	private Node containingClass;

	public Scoping(Object object) {
		children = new ArrayList<>();
		records = new HashMap<>();
		if (object != null)
			parent = (Scoping) object;
	}

	public Scoping nextChild() {
		Scoping nextC;
		if (next >= children.size())
		{
			nextC = new Scoping(this);
			children.add(nextC);
		} else nextC = children.get(next);
		next++;
		return nextC;
	}

	public Scoping getParent()
	{
		return parent;
	}

	public void put(String key, Node item)
	{
		records.put(key, item);
	}

	public Node watch_up(String key) {
		if (records.containsKey(key)) return records.get(key);
		else
		{
			if (parent == null) return null;
			else return parent.watch_up(key);
		}
	}

	public void print() {
		for (Map.Entry<String, Node> entry : records.entrySet())
		{
			String leftAlignFormat = "| %-27s | %-19s | %-27s|%n";
			String key = entry.getKey();
			Node value = entry.getValue();
			String recordClasses = value.getClass().getSimpleName();
			System.out.format(leftAlignFormat, key, value.getType(), recordClasses);
		}
		for (Scoping scoping : children) scoping.print();
	}

	public void reset() {
		next = 0;
		for (Scoping child : children) child.reset();
	}

	public void setContainingClass(Node node)
	{
		containingClass = node;
	}

	public Node getContainingClass()
	{
		return containingClass;
	}

}
