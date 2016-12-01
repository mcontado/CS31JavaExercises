package mystacks;

public class Stack {
	
	private Node first; // top of stack

	// linked list node helper data type
	private class Node {
		private Object item;
		private Node next;
	}

	// create an empty stack
	public Stack() {
		first = null;
	}

	// is the stack empty?
	public boolean isEmpty() {
		return first == null;
	}

	// add an element to the stack
	public void push(Object item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	// delete and return the most recently added element
	public Object pop() {
		if (isEmpty())
			throw new RuntimeException("Stack underflow");
		Object item = first.item; // save item to return
		first = first.next; // delete first node
		return item; // return the saved item
	}
	
	public Object peek() {
		if (isEmpty())
			throw new RuntimeException("Stack underflow");
		
		return first.item; // return the item on top;
	}

	
}
