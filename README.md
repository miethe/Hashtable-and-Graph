# Hashtable-and-Graph
###Created by Nick Miethe

Everything except for MyHashTable, MyGraph, LinkedListNode and GraphLinkedList are factories, abstract classes, or interfaces that should not be directly used.

GraphLinkedList and LinkedListNode are custom implementations of LinkedList and Node classes specific to the requirements of the Graph and Hash Table.

To implement the graph, you first must use graph = GraphFactory.create(size) and then NodeFactory.create(nodes). Add the nodes to the graph with graph.addNodes(node,node,...). You can then add edges between each of these nodes with graph.addEdge(node, node). You can call boolean isAcyclic() on the graph at any point to test with
