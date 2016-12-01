package assignment8;

import java.util.Scanner;

public class LinkedList {
	
	private Node first;  // list head
	private Node last;   // last element in list
	
	class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	/**
    Constructor.
	 */
	LinkedList() {
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
	
	public void add(int value) {
		//create a new node
		Node newNode = new Node(value);
		
		//check if the list is not empty
		if (!isEmpty()) {
			Node current = first;
			Node prev = null;
			
			while (current != null && current.data < value) {
				prev = current;
				current = current.next;
				
			} // end-while
			
			
			// if the previous is null, means that the value to be inserted should be in the first list
			// it did not proceed with the while loop above
			if (prev == null) {
				if (current.data == value) {
					System.out.println("*** Duplicate number, not added to the list *** ==> " + current.data);
					return;
					
				}
				newNode.next = first;
				first = newNode;
			} else {
				// checks if the current is not null and the current data should not be a duplicate
				if (current != null && current.data == value) {
					System.out.println("*** Duplicate number, not added to the list *** ==> " + current.data);
					return;
					
				}
				// otherwise, set the previous.next to newNode
				newNode.next = prev.next;
				prev.next = newNode;
				
				if (current == null) {
					last = prev.next;
				} 
				
			}
			
		} else {
			// the list is empty, so set the item to be the first one on the list
			first = newNode;
			last = newNode;
			
		}
	}
	
	/*
	 * For removing a number from the list, the user will choose the "delete" option 
	 * and supply the number to be removed. If the number is in the list, 
	 * it will be eliminated from the linked list. Otherwise, a message will be displayed: 
	 * "Number is not in the list".
	 * */
	public void remove(int value) {
		//checks first if the list is not empty 
		if (isEmpty()) {
			System.out.println("*** The list is empty, nothing to delete ***");
			return;
		} else {
			Node current = first;
			Node prev = null;
			while (current != null && current.data != value) {
				prev = current;
				current = current.next;
			}
			//item to remove is at the beginning of the list
			if (prev == null) {
				System.out.println("Deleted item: " + first.data);
				first = first.next;
			} else {
				if (current != null && current.data == value) {
					System.out.println("Deleted item: " + current.data);
					prev.next = current.next;
					
					if (prev.next == null) {
						last = prev;
					}
				} else {
					System.out.println("*** Number to delete is not on the list. ***");
					return;
				}
			}
			
			
			
		}
	}
	
	/*
	 * If the number is in the list, the program will display: 
	 * 		"the number is in the list". 
	 * Otherwise, it will display: “the number is not in the list". 
	 * */
	public void search(int value) {
		//checks first if the list is not empty 
		if (isEmpty()) {
			System.out.println("*** The list is empty, nothing to search ***");
			return;
		} else {
			Node current = first;
			
			while (current != null && current.data != value) {
				current = current.next;
			}
			
			if (current == null) {
				System.out.println("The number is not in the list");
				return;
			} else {
				System.out.println("Number " + current.data + " is in the list");
				return;
			}
			
		}
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
			strBuilder.append(p.data + "\n"); 
			p = p.next;
		}      
		return strBuilder.toString(); 
	}
	
	public void printData()
	{
		StringBuilder strBuilder = new StringBuilder();
		if (isEmpty()) {
			System.out.println("*** List is empty. *** ");
			return;
		}
		// Use p to walk down the linked list
		Node p = first;
		while (p != null)
		{
			strBuilder.append(p.data + "\n"); 
			p = p.next;
		}    
		System.out.println("\nThe following are the items on the list: ");
		System.out.println(strBuilder.toString());
	}
	
	
	public void displayMenuOptions() {
		System.out.println("Please choose one of the following options:");
		System.out.println("1) Add a number");
		System.out.println("2) Delete a number");
		System.out.println("3) Search for a number");
		System.out.println("4) Display the whole list of numbers");
		System.out.println("5) Exit");
	}

	public static void main(String [] args)
	{
		System.out.println(" === Welcome to Linked List Manipulations === ");
	
		LinkedList ll = new LinkedList();
		int input;
		Scanner in = new Scanner(System.in);
		
		do {
			ll.displayMenuOptions();
			System.out.println("Enter your choice: ");
			input = in.nextInt();
			
			switch(input) {
				case 1: 
					System.out.println("Please enter the number you want to add:");
					int valueToAdd = in.nextInt();
					ll.add(valueToAdd);
					break;
				case 2:
					System.out.println("Please enter the number you want to delete:");
					int valueToDelete = in.nextInt();
					ll.remove(valueToDelete);
					break;
				case 3:
					System.out.println("Please enter the number you want to search:");
					int valueToSearch = in.nextInt();
					ll.search(valueToSearch);
					break;
				case 4: ll.printData();
					break;
				default: break;
			}
			
		} while (input != 5);
		


	}
}
