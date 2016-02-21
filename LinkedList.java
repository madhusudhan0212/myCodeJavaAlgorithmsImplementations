package temp;

import java.util.HashSet;


public class LinkedList {
	Node head;
	LinkedList(){
		head = null;
	}
	private class Node{
		int item;
		Node next;
		Node(int item){
			this.item = item;
		}
	}
	
	public void add(int item){
		
	if (head == null) {head = new Node(item); return;}
	Node oldHead = head;
	head = new Node(item); 
	head.next = oldHead;
}
	
	public int remove(int item){
		
	if (head == null) {return -1;}
	Node oldHead = head;
	head = head.next; 
	oldHead.next = null;
	return oldHead.item;
	}

public void removeDuplicates(){
	HashSet<Integer> set = new HashSet<Integer>();
	Node current = head;
	Node previous = null;
	
	while (current!=null){
		if (!set.contains(current.item)) {
		set.add(current.item);
		previous = current;
		current = current.next;
		}
		else{
			previous.next = current.next;
			current = current.next;
		}
		
	}
	
}

public void printlastKelement(int k){
	int index = printlastKelement(head, k);
}

private int printlastKelement(Node x, int k){
	if ( x == null ){ return 0;}
	int index = printlastKelement(x.next, k) + 1;
	if (index == k){ System.out.print(x.item); }
	return index;
}

public void display(){
	Node x = head;
	while (x !=null){
		System.out.print(x.item + " ");
		x = x.next;
	}
}

public static void main(String[] args){
	LinkedList ll = new LinkedList();
	ll.add(10);
	ll.add(20);
	ll.add(30);
	ll.add(10);
	ll.add(50);
	ll.display();
	System.out.println("\n Print 3rd from last element");
	ll.printlastKelement(3);
	System.out.println("\n after removing duplicates");
	ll.removeDuplicates();
	ll.display();
}
}
