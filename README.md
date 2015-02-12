# Hashtable-and-Graph
###Created by Nick Miethe

Everything except for MyHashTable, MyGraph, LinkedListNode and GraphLinkedList are factories, abstract classes, or interfaces that should not be directly used.

GraphLinkedList and LinkedListNode are custom implementations of LinkedList and Node classes specific to the requirements of the Graph and Hash Table.

To implement the graph, you first must use `graph = GraphFactory.create(size)` and then `NodeFactory.create(nodes)`. Add the nodes to the graph with `graph.addNodes(node,node,...)`. This adds the nodes to a HashTable. You can then add edges between each of these nodes with `graph.addEdge(node, node)`. You can call `boolean isAcyclic()` on the graph at any point to test if a cycle exists. A few other public methods are:
*boolean hasEdge(node,node)
* Node lookupNode(id) //O(1) time
* Node lookupNode(name) //worst case time O(n)
* int[] sort()

The HashTable is implemented similarly with `table = HashTableFactory.create()`. To place objects in the table, `table.put(key, value)`. The key variable will be hashed and and key, value combination will be store at the hashkey. You can call `table.get(key)` to return the value. Both key and value are generics. A few other public methods:
* getNode(key) // worst case time O(n)
* Value remove(key) // returns value if key is in list, else null
