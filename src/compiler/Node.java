package compiler;

import java.io.Serial;
import java.io.Serializable;

public class Node implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	private final String id;
	private final String type;

	public Node(String id, String type) {
		this.id = id;
		this.type = type;
	}

	public String getId() {
		return this.id;
	}

	public String getType() {
		return this.type;
	}
}
