package temp;

public class BinarySearchTree<Key extends Comparable<Key>,Value> {
	 class Node {
		  Key key;
		  Value value;
		  Node left;
		  Node right;
		  
		  Node(Key k , Value v){
			  key= k;
			  value = v;
		  }
	 }
	 
	 private Node root;
	 BinarySearchTree(){
		 root = null;
	 }

	 public void put(Key k,Value v){
		 root = put(root,k,v); 
	 }
	 
	 private Node put(Node x,Key key,Value value){
		 if (x == null){return new Node(key,value);}
		 int cmp = key.compareTo(x.key);
		 if (cmp < 0){ x.left = put (x.left,key,value); }
		 else if (cmp > 0) { x.right = put (x.right,key,value);}
		 else { x.value = value;}
		 return x;
	 }
	 
	 public Value get(Key key){
		 Node x = root;
		 while(x != null){
			 int cmp = key.compareTo(x.key);
			 if (cmp < 0) { x=x.left;}
			 else if (cmp > 0) { x=x.right;}
			 else { return x.value; }
		 }
		 return null;
	 }
	 
	 public void ascDisplay(){
		 Node x = root;
		 inorder(x);
		 
	 }
	 
	 private void inorder(Node x){
		 if (x==null) { return;}
		 inorder(x.left);
		 System.out.println(x.key + "  "+ x.value);
		 inorder(x.right);
		 
	 }
	 
	 public Key min(){
		 Node x = min(root);
		 return x.key;
	 }
	 
	 private Node min(Node root){
		 Node x=root;
		 if ( x==null){ return null;}
		 while(x.left != null){
			 x = x.left;
		 }
		 return x;
	 }
	 
	 private Node deleteMin(Node x){
		 if(x.left == null ){ return x.right;}
		 x.left = deleteMin(x.left);
		 return x;
	 }
	 
	 public void delete(Key k){
		  root = delete (root,k);
	 }
	 
	 private Node delete ( Node x , Key key){
		 if (x == null){ return null;}
		 int cmp = key.compareTo(x.key);
		 if (cmp < 0) { x.left = delete(x.left,key);}
		 else if (cmp > 0) { x.right = delete(x.right,key);}
		 else {
			 if (x.left == null){ return x.right;}
			 else if (x.right == null) { return x.left;}
			 else {
				 Node t = min(x.right);
				 t.right = deleteMin(x.right);
				 t.left = x.left;
				 return t;
			 }
		 }
		 
		return x; 
	 }
	 
	 public static void main(String[] args) {
			
			BinarySearchTree<Integer,String> bst = new BinarySearchTree<Integer,String>();
			bst.put(5,"madhu");
			bst.put(3,"sudhan");
			bst.put(6,"goud");
			bst.put(2,"paruchuri");
			bst.put(1,"annapurna");
			bst.put(0,"narsimha rao");
			bst.put(4,"mahesh");
			System.out.println("Displaying Binary Search Tree in Ascending Order");
			bst.ascDisplay();
			System.out.println("Deleting key 2");
			bst.delete(2);
			System.out.println("Deleted key 2");
			System.out.println("Displaying Binary Search Tree in Ascending Order");
			bst.ascDisplay();
			System.out.println(bst.get(3));
			System.out.println(bst.min());
			
	 
}
}
