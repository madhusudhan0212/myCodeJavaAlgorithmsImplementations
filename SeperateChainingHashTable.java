package temp;

public class SeperateChainingHashTable<Key,Value> {
	private int m=4;
	private Node[] st =  new Node[m];
	
	private static class Node{
		private Object key;
		private Object value;
		private Node next;
		
		Node(Object k,Object v,Node n){
			key=k;
			value=v;
			next=n;
		}
	}
	
	
	
	private int hash(Key k){
		return (Math.abs((int) k) % m);
	}
	
	public void put(Key k,Value v){
		int i = hash(k);
		for(Node x = st[i];x != null;x=x.next){
			if(k.equals(x.key)){ x.value = v; return;}		
		}
		st[i]=new Node(k,v,st[i]);
	}
	
	@SuppressWarnings("unchecked")
	public Value get(Key k){
		int i = hash(k);
		for (Node x =st[i];x != null;x=x.next){
			if ( k.equals(x.key)){ return (Value) x.value; }
		}
		return null;
	}
	
	public void display(){
		for (int i=0;i< m ;i++){
			for (Node x =st[i];x != null;x=x.next){
				System.out.print(x.key+"---"+x.value+"      ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		SeperateChainingHashTable<Integer,String> sch = new SeperateChainingHashTable<Integer,String>();
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
