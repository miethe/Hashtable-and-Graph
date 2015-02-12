
public class GraphLinkedList<K,V> {
	private LinkedListNode<K, V> firstNode;
	private int listCount;
	private LinkedListNode<K, V> lastNode;
	
	public GraphLinkedList(){
		firstNode = new LinkedListNode<K,V>(null, null);
		lastNode=firstNode;
		listCount=0;
	}

	public boolean isEmpty(){
		return (listCount==0);
	}
	public void add(K key, V value){
		LinkedListNode<K,V> temp = new LinkedListNode<K,V>(key,value);
		
		if (firstNode.getKey()==null){
			firstNode=temp;
		}
		else{
			lastNode.setNext(temp);
		}
		lastNode=temp;
		lastNode.setNext(null);
		listCount++;
	}
	
	public LinkedListNode<K,V> remove() {	//remove first Node (bottom of list)
		
		LinkedListNode<K,V> presentNode = firstNode;

		firstNode=firstNode.getNext();
		listCount--;
		return presentNode;
	}
	
	public K getKey(int index){
		if (index <= 0) return null;	//ensure index is within list
		 LinkedListNode<K,V> presentNode = firstNode;
			 for (int i = 1; i<index; i++){	//iterate through to Node before Node to be returned.		
			 if (presentNode.getNext() == null) return null;
			 presentNode = presentNode.getNext();
		 }
		 return presentNode.getKey();
	}
	public LinkedListNode<K, V> getNode(int index){		//worst case O(n), average O(1)
		if (index <= 0) return null;	//ensure index is within list
		 LinkedListNode<K,V> presentNode = firstNode;
		 for (int i = 1; i<index; i++){	//iterate through to Node before Node to be returned.	
			 if (presentNode.getNext() == null) return presentNode;
			 presentNode = presentNode.getNext();
		 }
		 return presentNode;
	}
	public V getValue(int index){
		if (index <= 0) return null;	//ensure index is within list
		 LinkedListNode<K,V> presentNode = firstNode;
		 for (int i = 1; i<index; i++){	//iterate through to Node before Node to be returned.
			 if (presentNode.getNext() == null) return presentNode.getValue(); 
			 presentNode = presentNode.getNext();
		 }
		 return presentNode.getValue();
	}
	
	public int currentSize(){
		return listCount;
	}
}
