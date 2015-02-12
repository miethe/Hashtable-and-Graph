
public class LinkedListNode<K,V> implements Node{
	K key;
	V value;
	LinkedListNode<K, V> next=null;
	
	public LinkedListNode(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public V getValue(){
		return value;
	}

	public K getKey(){
		return key;
	}
	
	public LinkedListNode<K,V> getNext(){
		return next;
	}
	public void setNext(LinkedListNode<K,V> node){
		this.next = node;
	}

	@Override
	public String getName(){
		if(key==null) return null;
		return key.toString();
	}

	@Override
	public int getId() {
		return (Integer) value;
	}
}
