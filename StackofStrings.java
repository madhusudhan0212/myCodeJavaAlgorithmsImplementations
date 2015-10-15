package temp;

public class StackofStrings {
	private Node first = null;
	
	 private class Node {
		String item;
		Node next;
	}
	
	public void push(String key)
	{
		Node oldFirst = first;
		first = new Node();
		first.item=key;
		first.next = oldFirst;
	}
	
	public String pop()
	{
		if (first==null){ return "Empty Stack";}
		String val = first.item;
		first = first.next;
		return val;
	}
	
	public boolean isEmpty()
	{
		return first==null;
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		StackofStrings stack = new StackofStrings();
		System.out.println(stack.isEmpty());
		stack.push("Madhu");
		stack.push("Sudhan");
		stack.push("Goud");
		System.out.println(stack.pop());
		stack.push("Paruchuri");
		stack.push("Madhu");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}
}
