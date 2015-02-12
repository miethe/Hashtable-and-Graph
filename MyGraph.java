
public class MyGraph extends Graph {
	
	private Node[] vertices;
	@SuppressWarnings("rawtypes")
	private GraphLinkedList[] edges;	//Adjacency list
	private MyHashTable<String, Integer> hashNames;
	private int edgesCount=0;
	private int nodeCount;
	
	public MyGraph(int nodeCount){
		this.nodeCount=nodeCount;
		vertices = new Node[nodeCount+1];
		edges = new GraphLinkedList[nodeCount+1];
		for(int i=0;i<nodeCount+1;i++){
			edges[i]=new GraphLinkedList<String, Integer>();
		}
		hashNames = new MyHashTable<String, Integer>();
		
	}

	@Override
	public void addNode(Node node) {
		vertices[node.getId()]=node;
		hashNames.put(node.getName(), node.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addEdge(Node node1, Node node2) {
		int node1ID = node1.getId();
		edges[node1ID].add(node2.getName(), node2.getId());
		edgesCount++;
	}
	
	public boolean hasEdge(Node node1, Node node2){
		int node1ID = node1.getId();
		for (int i=1;i<edgesCount;i++){
			if(edges[node1ID].getNode(i).key==null) return false;
			if(edges[node1ID].getNode(i).getName()==node2.getName()) return true;
		}
		return false;
	}

	@Override
	public Node lookupNode(int id) {	//worst case O(1)
		return vertices[id];
	}

	@Override
	public Node lookupNode(String name) {	//worst case O(n), average O(1)
		return hashNames.getNode(name);
	}
	
	private boolean isCyclic(Node node, int index, String name, String prevNode){	//returns true if a cycle is detected in graph
		boolean cyclic = false;
		String nextName = null;
		if (name==null || node==null || node.getName()==null) return false;
		int idx = node.getId();
			for (int j=1; j<nodeCount;j++){
				if(edges[idx].getNode(j).getKey()==null) break;
				nextName = edges[idx].getNode(j).getName();		//name of next node connected to current
				if(nextName==prevNode) return true;
				if (nextName==name) return true;
			}
			if(edges[idx].getNode(1).getName()==null) return false;
			if (edges[idx].getNode(1).getKey()!=null) {
				cyclic = isCyclic(edges[idx].getNode(1), idx, name, node.getName());		//recursive, check path of edges for a cycle
				if(cyclic==true) return cyclic;
			}
		
		return false;
	}

	@Override
	public boolean isAcyclic() {
		boolean cyclic = false;
		if(vertices==null) return true;		//if no nodes
		//if no leaves, return false
		
		for(int i=1;i<nodeCount;i++){
			for(int j=1;j<nodeCount;j++){		//iterate through array indexes
				if (edges[i].getNode(j)!=null){	//iterate through nodes in list at index
					cyclic = isCyclic(edges[i].getNode(j), i, lookupNode(i).getName(), lookupNode(i).getName());	//recursively search for cycle
					if(cyclic==true) return false;
				}
			}
		}
		return true;
	}

	@Override
	public int[] sort() {
		Node firstNode, secondNode;
		int[] indegree = new int[nodeCount+1];	//worst case size of nodeCount
		int[] sorted = new int[nodeCount];
		boolean[] finished = new boolean[nodeCount+1];
		int arrayIdx =0;
		
		for(int i=1; i<nodeCount+1;i++){	//iterate over vertex array
			for(int j=1;j<nodeCount+1;j++){	//iterate through nodes at each array index
				firstNode = vertices[i];
				secondNode = vertices[j];
				if(hasEdge(firstNode,secondNode)) indegree[j]+=1;	//if edge from i to j, up j indegree
			}
		}
		for(int i=1;i<nodeCount+1;i++){
			if(indegree[i]==0){
				sorted[arrayIdx++]=i;
				finished[i]=true;
			}
			
			for(int j=1;j<nodeCount+1;j++){		//worst case nodeCount edges
				firstNode = vertices[i];
				secondNode = vertices[j];
				if(hasEdge(firstNode,secondNode)) indegree[j] -=1;
			}
		}
		for(int i=1;i<nodeCount+1;i++){		//ensures all node have been added to sort array.
			if (!finished[i]) sorted[arrayIdx++]=i;
		}
		
		return sorted;
	}

}
