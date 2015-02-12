
public class GraphNode implements Node {
	String key;
	int value;
	GraphNode next=null;
	
	public GraphNode(String key, int index){
		this.key=key;
		this.value=index;
	}

	@Override
	public String getName() {
		return key;
	}

	@Override
	public int getId() {
		return value;
	}

}
