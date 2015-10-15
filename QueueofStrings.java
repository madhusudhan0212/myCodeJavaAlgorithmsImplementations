package temp;

public class QueueofStrings {
	private Node first = null;
	private Node last = null;
	
	 private class Node {
		String item;
		Node next;
	}
	
	public void enqueue(String key)
	{
		Node oldlast = last;
		last = new Node();
		last.item=key;
		last.next = null;
		if ( first == null){first=last;}
		else { oldlast.next = last; }
	}
	
	public String dequeue()
	{
		if (first==null){ return "Empty Queue";}
		String val = first.item;
		first = first.next;
		if (first==null){last=null;}
		return val;
	}
	
	public boolean isEmpty()
	{
		return first==null;
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		QueueofStrings queue = new QueueofStrings();
		System.out.println(queue.isEmpty());
		queue.enqueue("Madhu");
		queue.enqueue("Sudhan");
		queue.enqueue("Goud");
		System.out.println(queue.dequeue());
		queue.enqueue("Paruchuri");
		queue.enqueue("Madhu");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
	}
}