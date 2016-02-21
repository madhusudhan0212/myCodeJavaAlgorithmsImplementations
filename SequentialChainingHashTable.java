package temp;

public class SequentialChainingHashTable<Key,Value> {

	private int m =7;
	private Node[] sc = new Node[m];
	
	private static class Node{
	Object key;
	Object value;
	Node next;
	Node(Object key,Object value,Node x){
	this.key = key;
	this.value = value;
	next = x;
	}
	}

	private int hash(Key key){
	 return (Math.abs((int) key) % m );
	}


	public void put(Key key, Value value ) {
	int i = hash(key);
	for(Node x= sc[i] ; x != null ; x=x.next ) {
	if ( key.equals(x.key)) { x.value = value; return;}
	}
	sc[i] = new Node(key,value,sc[i]);
	}

	public Object get(Key key) {
	int i = hash(key);
	for(Node x= sc[i] ; x != null ; x=x.next ) {
	if ( key.equals(x.key)) {return x.value;}
	}
	return null;
	}
	
	public void display(){
		for (int i = 0; i < m; i++){
			for(Node x = sc[i]; x != null;x=x.next){
			System.out.print(x.key+"----"+x.value+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		SequentialChainingHashTable<Integer,String> sch = new SequentialChainingHashTable<Integer,String>();
		sch.put(50,"madhu");
		sch.put(30,"sudhan");
		sch.put(60,"goud");
		sch.put(20,"paruchuri");
		sch.put(10,"annapurna");
		sch.put(20,"narsimha rao");
		sch.put(40,"mahesh");
		sch.put(11,"Pavi");
		sch.put(12,"Chandu");
		sch.put(13,"Pooja");
		System.out.println("Displaying Hash Table");
		sch.display();
}
	}
