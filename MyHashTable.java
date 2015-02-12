
public class MyHashTable<K, V> implements HashTable<K, V> {
	private final int tableSize = 1009; //smallest prime over 1000
	private GraphLinkedList<K,V>[] pairs;
	
	@SuppressWarnings("unchecked")
	public MyHashTable(){
		pairs = new GraphLinkedList[tableSize];
		for(int i=0;i<tableSize;i++){
			pairs[i]=new GraphLinkedList<K,V>();
		}
	}
	
	private int hash(K key){
		return (Math.abs(key.hashCode())) % tableSize;
	}

	@Override
	public void put(K key, V value) {
		int hashKey = hash(key);
		pairs[hashKey].add(key, value);
	}

	@Override
	public V get(K key) {
		int hashKey=hash(key);
		GraphLinkedList<K,V> temp = pairs[hashKey];
		if(temp==null) return null;
		else{
			int size = temp.currentSize();
			for(int i=1;i<=size;i++){
				if (temp.getKey(i)==key) return temp.getValue(i);	//if key is in list
			}
		}
		return null;
	}
	
	public Node getNode(K key){		//worst case O(n), average O(1)
		int hashKey=hash(key);
		GraphLinkedList<K,V> temp = pairs[hashKey];
		return temp.getNode(hashKey);
	}

	@Override
	public V remove(K key) {
		int hashKey=hash(key);
		LinkedListNode<K,V> removedNode;
		GraphLinkedList<K,V> temp = pairs[hashKey];
		if(temp==null) return null;
		else{
			int size = temp.currentSize();
			for(int i=1;i<=size;i++){
				if (temp.getKey(i)==key){	//if key is in list
					removedNode=temp.remove();
					return removedNode.getValue();
				}
			}
		}
		return null;
	}
}
