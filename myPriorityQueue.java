package temp;

public class myPriorityQueue<T extends Comparable <T>> {
	private Node first = null;
	private class Node{
		T item;
		Node next;
		Node(T item){
			this.item = item;
		}
	}
	
	public void insert(T item){
		first = insert(first,item);
	}
	private Node insert(Node x, T item){
		if (x == null) return new Node(item);
		int cmp = item.compareTo(x.item);
		if (cmp < 0 ) { x.next = insert(x.next,item); }
		else {
			Node a = x;
			x = new Node(item);
			x.next = a;
		}
		return x;
		}

  public T remove() {
	  if (first == null) { return null; }
	  T item =  first.item;
	  first = first.next;
	  return item;
  }
  
  public void display(){
	  Node x = first;
	  System.out.println("Display of priority queue");
	  while (x != null){
		  System.out.println(x.item);
		  x = x.next;
	  }
  }
  
  public static void main(String[] args){
	  myPriorityQueue<Integer> pq = new myPriorityQueue<Integer>();
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