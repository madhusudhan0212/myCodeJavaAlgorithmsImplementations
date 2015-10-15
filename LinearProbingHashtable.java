package temp;

public class LinearProbingHashtable<Key,Value> {
	Key[] ka;
	Value[] va;

	private int m=20;
	@SuppressWarnings("unchecked")
	LinearProbingHashtable(){
		ka = (Key[]) new Object[m];
		va = (Value[]) new Object[m];
	}
	
	private int hash(Key key){
		return (key.hashCode() & 0x7FFFFFFF) % m;
	}
	
	public void put(Key key,Value val){
		int i;
		
		for(i = hash(key);ka[i] != null;i = (i +1)% m){	
			if(ka[i].equals(key)){va[i] = val; return;}
		}
		ka[i]=key;
		va[i]=val;
	}
	
	public Value get(Key key){
		int i = hash(key);
		for(i = hash(key);ka[i] != null;i = (i +1)% m){
			if(ka[i].equals(key)){ return (Value) va[i];}		
		}
		return null;
	}
	
	public void display(){
		for (int i=0;i<m;i++){
			System.out.println(ka[i]+"--"+va[i]);
		}
	}
	
public static void main(String[] args) {
		
		LinearProbingHashtable<Integer,String> lph = new LinearProbingHashtable<Integer,String>();
		lph.put(50,"madhu");
		lph.put(30,"sudhan");
		lph.put(60,"goud");
		lph.put(20,"paruchuri");
		lph.put(10,"annapurna");
		lph.put(20,"narsimha rao");
		lph.put(40,"mahesh");
		lph.put(11,"Pavi");
		lph.put(12,"Chandu");
		lph.put(13,"Pooja");
		System.out.println("Displaying Hash Table");
		lph.display();
		System.out.println();
		System.out.println(lph.get(12));
}
	
	
}
