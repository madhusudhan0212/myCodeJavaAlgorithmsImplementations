package temp;

public class MyBalancedST<Key extends Comparable<Key>,Value> {
	
	private Node root;
	private static final boolean BLACK = false;
	private static final boolean RED = true;
	MyBalancedST(){
		root = null;
	}
	private class Node {
		Key key;
		Value value;
		boolean color;
		Node left;
		Node right;
		Node(Key key, Value value,boolean color){
			this.key = key;
			this.value = value;
			this.color = color;
		}
	}
	
	public void put(Key key, Value value){
		root = put(root,key,value);
	}
	
	private boolean isRed(Node x){
		if (x == null) { return false;}
		return x.color == RED;
	}
	
	private Node put(Node x,Key key,Value value){
		if(x == null){ return new Node(key,value,BLACK); };
		int cmp = key.compareTo(x.key);
		if (cmp < 0) { x.left = put(x.left, key, value);}
		else if (cmp > 0) { x.right = put (x.right,key,value); }
		else { x.value = value;}
		
		if(isRed(x.right) && !isRed(x.left)) { x = rotateLeft(x);}
		if(isRed(x.left) && isRed(x.left.left)) { x = rotateRight(x);}
		if(isRed(x.right) && isRed(x.left)) { flipColors(x);}
		return x;
	}
	
	public Value get(Key key){
		Node x = root;
		while ( x != null){
			int cmp = key.compareTo(x.key);
			if (cmp < 0) { x = x.left;}
			else if (cmp > 0) { x = x.right;}
			else { return x.value; }
		}
		return null;
	}
		
	public void Display(){
		Node x = root;
		inorder(x);
	}
	
	private void inorder(Node x) {
		if ( x == null){return;}
		inorder(x.left);
		System.out.println(x.key + " "+x.value);
		inorder(x.right);
	}
	
	private Node rotateLeft(Node h){
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}
	
	private Node rotateRight(Node h){
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}
	
	private void flipColors(Node h){
		h.left.color = BLACK;
		h.right.color = BLACK;
		h.color = RED;
	}
	
	public Key rootValue(){
		return root.key;
	}
	
	public static void main(String[] args) {
		
		MyBalancedST<Integer,String> bst = new MyBalancedST<Integer,String>();
		bst.put(5,"madhu");
		bst.put(3,"sudhan");
		bst.put(6,"goud");
		bst.put(2,"paruchuri");
		bst.put(1,"annapurna");
		bst.put(0,"narsimha rao");
		bst.put(4,"mahesh");
		bst.put(8,"annapurna");
		bst.put(8,"narsimha rao");
		bst.put(15,"mahesh");
		System.out.println("Displaying Binary Search Tree in Ascending Order");
		bst.Display();
		System.out.println("Fetch value for key:8");
		System.out.println(bst.get(8));
		System.out.println("Root node");
		System.out.println(bst.rootValue());
		

	}
}


