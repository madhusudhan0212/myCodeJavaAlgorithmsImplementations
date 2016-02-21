package temp;

public class BinarySearchTree<Key extends Comparable<Key>,Value> {
	 class Node {
		  Key key;
		  Value value;
		  int level;
		  Node left;
		  Node right;
		  
		  Node(Key k , Value v, int lev){
			  key= k;
			  value = v;
			  level = lev;
		  }
	 }
	 
	 private Node root;
	 BinarySearchTree(){
		 root = null;
	 }

	 public void put(Key k,Value v){
		 root = put(root,k,v,0); 
	 }
	 
	 private Node put(Node x,Key key,Value value, int level){
		 if (x == null){return new Node(key,value,level);}
		 int cmp = key.compareTo(x.key);
		 if (cmp < 0){ x.left = put (x.left,key,value,level+1); }
		 else if (cmp > 0) { x.right = put (x.right,key,value,level+1);}
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
	 
	 public void inorder(){
		 Node x = root;
		 inorder(x); 
	 }
	 
	 public void postorder(){
		 Node x = root;
		 postorder(x);
	 }
	 
	 public void preorder(){
		 Node x = root;
		 preorder(x);
	 }
	 
	 private void inorder(Node x){
		 if (x==null) { return;}
		 inorder(x.left);
		// System.out.println(x.key + "  "+ x.value+ " "+x.level);
		 System.out.print(x.key + "  ");
		 inorder(x.right);
		 
	 }
	 
	 private void preorder(Node x){
		 if (x==null) { return;}
		 System.out.print(x.key + "  ");
		 preorder(x.left);
		 preorder(x.right);
		 
	 }
	 
	 private void postorder(Node x){
		 if (x==null) { return;}
		 postorder(x.left);
		 postorder(x.right);
		 System.out.print(x.key + "  ");	 
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
	 
	 public void serialize(){
		 serialize(root);
	 }
	 
	 private void serialize(Node x){
		 
		 if ( x == null) { System.out.print("# ");}
		 else {
			 System.out.print(x.key +" ");
			 serialize(x.left);
			 serialize(x.right);
		 }
		 
	 }
	 
	 public Key leastAncestor(Key k1,Key k2){
		 Node x = root;
		 while(true) {
			 int cmp1 = k1.compareTo(x.key);
			 int cmp2 = k2.compareTo(x.key);
			 
			 if (cmp1 < 0 & cmp2 < 0 ) { if(x.left == null) {return x.key;} x = x.left; }
			 else if (cmp1 > 0 & cmp2 > 0 ) { if(x.right == null) {return x.key;} x = x.right; }
			 else { return x.key; }
		 }
		 
	 }
	 
	 private int diff(Key k1, Key k2){
		 return Math.abs((Integer)k1 - (Integer)k2);
	 }
	 
	 public Key closestKey(Key k1){
		 Node x = root;
		 Key closestKey = root.key;
		 int mindiff = diff(k1,closestKey);
		 
		 while (x != null){
			 int currdiff = diff(k1,x.key);
			 if ( mindiff > currdiff) { mindiff = currdiff; closestKey = x.key;}
			 int cmp = k1.compareTo(x.key);
			 if (cmp < 0){x = x.left;}
			 else if (cmp > 0){x = x.right;}
			 else {
				 return x.key;
			 } 
		 }
		 return closestKey;
		 		 
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
			bst.put(8,"annapurna");
			bst.put(8,"narsimha rao");
			bst.put(15,"mahesh");
			System.out.println("Serialized tree");
			bst.serialize();
			System.out.println("\n Displaying Binary Search Tree in InOrder");
			bst.inorder();
			System.out.println("\n Displaying Binary Search Tree in PreOrder");
			bst.preorder();
			System.out.println("\n Displaying Binary Search Tree in PostOrder");
			bst.postorder();
			System.out.println("\n CLosest Key to key 7");
			System.out.println(bst.closestKey(7));
		   // System.out.println("\n Displaying least ancestor");
		   //	System.out.println(bst.leastAncestor(5,10));
		   //	System.out.println("Deleting key 2");
		   // 	bst.delete(2);
			// System.out.println("Deleted key 2");
			// System.out.println("Displaying Binary Search Tree in Ascending Order");
			// bst.ascDisplay();
			// System.out.println(bst.get(3));
			// System.out.println(bst.min());
			
			// System.out.println(bst.leastAncestor(8,15));
			
			
	 
}
}
