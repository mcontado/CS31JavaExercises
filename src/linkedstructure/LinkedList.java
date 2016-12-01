package linkedstructure;

/** 
The LinkedList1 class implements a Linked list.
 */

class LinkedList
{
	/**
    The Node class stores a list element
    and a reference to the next node.
	 */

	private class Node
	{
		String value;   
		Node next;  
		
		// added for lab
		int IDNumber;
		char letterGrade;

		/**
        Constructor.            
        @param val The element to store in the node.
        @param n The reference to the successor node.
		 */

		Node(String val, Node n)
		{
			value = val;
			next = n;
		} 
		
		//added 10/26
		Node(String val, Node n, int id, char grade)
		{
			value = val;
			next = n;
			IDNumber = id;
			letterGrade = grade;
		} 

		/**
        Constructor. 
        @param val The element to store in the node.
		 */

		Node(String val)
		{
			// Call the other (sister) constructor.
			this(val, null); 			
		}
		
		//added 10/26
		Node(String val, int id, char grade) 
		{
			this(val, null, id, grade);
			
		}


		
		
	}	

	private Node first;  // list head
	private Node last;   // last element in list

	/**
    Constructor.
	 */

	public LinkedList()
	{
		first = null;
		last = null;        
	}

	/**
    The isEmpty method checks to see 
		 if the list is empty.
		 @return true if list is empty, 
		 false otherwise.
	 */

	public boolean isEmpty()
	{        
		return first == null;       
	}

	/**
    The size method returns the length of the list.
    @return The number of elements in the list.
	 */

	public int size()
	{
		int count = 0;
		Node p = first;     
		while (p != null)
		{
			// There is an element at p
			count ++;
			p = p.next;
		}
		return count;
	}

	/**
    The add method adds an element to
		 the end of the list.
    @param e The value to add to the
		 end of the list.       
	 */

	public void add(String e)
	{
		if (isEmpty()) 
		{
			first = new Node(e);
			last = first;
		}
		else
		{
			// Add to end of existing list
			last.next = new Node(e);
			last = last.next;
		}      
	}
	
	public void insertAlphabetical(String e)
	{
		//create a new node, set the node.val = e, set the next to null
		Node newNode = new Node(e, null);
		
		// checks first if the list is not empty
		if (!isEmpty()) {
			//Node nodePtr = first;
			Node current = first;
			Node previous = null;
			
			//traverse through the linked list, while the current is not reaching the end AND
			// if current.val compareTo newNode.val, if 0, they are equal, if less than 0, meaning newNode value goes first
			while (current != null && current.value.compareTo(newNode.value) <= 0) {
				previous = current;
				current = current.next;
			}
			
			// if the previous is null, means that the name to be inserted should be in the first list
			// it did not proceed with the while loop above
			if (previous == null) {
				//newNode.next = first;
				//first = newNode;
				addToBeginning(e);
			} else {
				// otherwise, set the previous.next to newNode
				previous.next = newNode;
				
				if (current == null)
					last = previous.next;
			}
			
			//set the next of the newNode to the current
			newNode.next = current;
			

		} else {
			// the list is empty, so set the item to be the first one on the list
			first = newNode;
			last = newNode;
		}
		
						 
	}

	public void addToBeginning(String e) {
		if (isEmpty()) {
			first = new Node(e);
			last = first;
		} else {
			Node newNode = new Node(e, first);
			first = newNode;
		}
		
	}
	
	/**
    The add method adds an element at a position.
    @param e The element to add to the list.
    @param index The position at which to add 
		 the element.
    @exception IndexOutOfBoundsException When 
		 index is out of bounds.  
	 */

	public void add(int index, String e)
	{
		if (index < 0  || index > size()) 
		{
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}

		// Index is at least 0
		if (index == 0)
		{
			// New element goes at beginning
			first = new Node(e, first);
			if (last == null)
				last = first;
			return;
		}

		// Set a reference pred to point to the node that
		// will be the predecessor of the new node
		Node pred = first;        
		for (int k = 1; k <= index - 1; k++)        
		{
			pred = pred.next;           
		}

		// Splice in a node containing the new element
		pred.next = new Node(e, pred.next);  

		// Is there a new last element ?
		if (pred.next.next == null)
			last = pred.next;         
	}

	/**
    The toString method computes the string
    representation of the list.
    @return The string form of the list.
	 */

	public String toString()
	{
		StringBuilder strBuilder = new StringBuilder();

		// Use p to walk down the linked list
		Node p = first;
		while (p != null)
		{
			strBuilder.append(p.value + "\n"); 
			p = p.next;
		}      
		return strBuilder.toString(); 
	}

	/**
    The remove method removes the element at an index.
    @param index The index of the element to remove. 
    @return The element removed.  
    @exception IndexOutOfBoundsException When index is 
               out of bounds.     
	 */

	public String remove(int index)
	{
		if (index < 0 || index >= size())
		{  
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}

		String element;  // The element to return     
		if (index == 0)
		{
			// Removal of first item in the list
			element = first.value;    
			first = first.next;
			if (first == null)
				last = null;             
		}
		else
		{
			// To remove an element other than the first,
			// find the predecessor of the element to
			// be removed.
			Node pred = first;

			// Move pred forward index - 1 times
			for (int k = 1; k <= index -1; k++)
				pred = pred.next;

			// Store the value to return
			element = pred.next.value;

			// Route link around the node to be removed
			pred.next = pred.next.next;  

			// Check if pred is now last
			if (pred.next == null)
				last = pred;              
		}
		return element;        
	}  

	/**
    The remove method removes an element.
    @param element The element to remove.
    @return true if the remove succeeded, 
		 false otherwise.
	 */

	public boolean remove(String element)
	{
		if (isEmpty()) 
			return false;      

		if (element.equals(first.value))
		{
			// Removal of first item in the list
			first = first.next;
			if (first == null)
				last = null;       
			return true;
		}

		// Find the predecessor of the element to remove
		Node pred = first;
		while (pred.next != null && 
				!pred.next.value.equals(element))
		{
			pred = pred.next;
		}

		// pred.next == null OR pred.next.value is element
		if (pred.next == null)
			return false;

		// pred.next.value  is element
		pred.next = pred.next.next;    

		// Check if pred is now last
		if (pred.next == null)
			last = pred;

		return true;       
	}

	public static void main(String [] args)
	{
		LinkedList ll = new LinkedList();
//		ll.add("Amy");
//		ll.add("Bob");
//		ll.add(0, "Al");
//		ll.add(2, "Beth");
//		ll.add(4, "Carol");
		ll.insertAlphabetical("Amy");
		ll.insertAlphabetical("Carol");
		ll.insertAlphabetical("Bob");
		ll.insertAlphabetical("Al");
		ll.insertAlphabetical("Beth");
		System.out.println("The members of the list are:");
		System.out.print(ll);
		System.out.println("Last value: " + ll.last.value);
	}
}