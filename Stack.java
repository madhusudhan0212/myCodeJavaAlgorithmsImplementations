package temp;

public class Stack<Item> {
	private Node first = null;
	
	 private class Node {
		Item item;
		Node next;
	}
	
	public void push(Item key)
	{
		Node oldFirst = first;
		first = new Node();
		first.item=key;
		first.next = oldFirst;
	}
	
	public Item pop()
	{
		if (first==null){ return null;}
		Item val = first.item;
		first = first.next;
		return val;
	}
	
	public boolean isEmpty()
	{
		return first==null;
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<String>();
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
		
		Stack<Integer> stack1 = new Stack<Integer>();
		System.out.println(stack1.isEmpty());
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		System.out.println(stack1.pop());
		stack1.push(4);
		stack1.push(5);
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		
	}
}
