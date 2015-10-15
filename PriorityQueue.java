package temp;



public class PriorityQueue {

	public class Node {
	
		int data;
		Node next;
		
		Node(int a){
			data = a;
		}
		
		void display(){
			System.out.print(data + " ");
		}
	}
	
	public class LinkedList{
		private Node first;
		
		LinkedList(){
			first = null;
		}
		
		
		public void insert(int a){
			Node previous=null;
			Node current = first;
			Node newNode = new Node(a);
			
			while(current != null &&  a < current.data ){
				previous = current;
				current = current.next;
			}
			
			if (previous==null){
				previous=current;
				first = newNode;
				first.next = previous;
			}
			else {
				previous.next=newNode;
				newNode.next =current;
			}
		}
		
		public int remove(){
			Node del = first;
			first = first.next;
			del.next=null;
			return del.data;
		}
		
		public void display(){
			Node current = first;
			while ( current != null){
				current.display();
				current = current.next;
			}
		}
	}
	
	
	private LinkedList ll;
	PriorityQueue(){
		ll = new LinkedList();
	}
	
	public void insert(int a){
		ll.insert(a);
	}
	
	public int remove(){
		return ll.remove();
	}
	
	public void display(){
		System.out.println("Display Priority Queue:");
		ll.display();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriorityQueue pq = new PriorityQueue();
		pq.insert(20);
		pq.insert(10);
		pq.insert(15);
		pq.insert(40);
		System.out.println(pq.remove());
		pq.insert(5);
		pq.insert(60);
		pq.insert(50);
		System.out.println(pq.remove());
		pq.insert(20);
		pq.display();
				
	
	}	
	
}



