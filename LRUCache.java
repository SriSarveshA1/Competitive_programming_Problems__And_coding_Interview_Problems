import java.util.HashMap;
import java.util.Map;

class LRUCache {
	private Map<Integer, Node> map;
	private Node head; // dummy "fence" head
	private Node tail; // dummy "fence" tail
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, Node>();
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		head.next = tail; 
		tail.prev = head; 
	}
	
	public int get(int key) {
		if( !map.containsKey(key)) 
        {
			return -1;
		}
		Node n = map.get(key);
		put_to_last(n);
		return n.val;
	}
	
	public void put(int key, int value) {
		Node n;
		// update existing Node; does not alter cache size
		if( map.containsKey(key) ) {
			n = map.get(key);
			n.val = value;   // map.get(n.key) will now return node with new val
			put_to_last(n);	
			return;
		}
		if( map.size() == capacity )
        {
			Node first = head.next;
			map.remove(first.key);
			remove(first);
		}
		n = new Node(key, value);
		addLast(n);
		map.put(key, n);
	}

	
	private void put_to_last(Node n) {//we are putting the recently accesed Node to the last of the  linkedList
		if( tail != n ) {
			remove(n);
			addLast(n);
		}
	}

	/**
	 * Remove given Node from queue.
	 */
	private void remove(Node n) {
		n.prev.next = n.next;
		n.next.prev = n.prev;
	}

	/**
	 * Insert given Node to head of queue.
	 */
	private void addLast(Node n) {
		
		Node p1=tail.prev;
        p1.next=n;
        n.prev=p1;
        n.next=tail;
        tail.prev=n;
	}
	
	
	public class Node {
    	int key;
    	int val;
    	Node prev;
    	Node next;
    		
    	public Node(int key, int val) {
    		this.key = key;
    		this.val = val;
    	}
    }
}