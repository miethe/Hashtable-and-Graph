/**
 * Factory used for creating nodes
 */
public final class NodeFactory {
	private static int nodeCounter;

    public static Node create(String name) {
    	nodeCounter++;
    	return new GraphNode(name, nodeCounter);

        // TODO: Create a node with the given name based on your implementation and return it
        // e.g. return new MyNode(name);
    }

}
