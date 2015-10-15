package temp;

public class BinaryHeap<Item extends Comparable<Item>>  {
private Item[]  harr;
private int N;

   @SuppressWarnings("unchecked")
    BinaryHeap(int n){
    	harr = (Item[]) new Comparable[n];
    }
    
    public void insert(Item a){
    	if ( N == harr.length-1){ System.out.println("Array Full. Cannot insert Item "+ a );
    	}
    	else {
    	harr[++N] = a;
    	swim(harr, N);
    	}
    }

	private void swim(Item[] arr,int n) {
		int k=n;
		while (k/2 > 0){
			if((arr[k/2]).compareTo(arr[k]) >= 0 ){return;}
			exch(arr,k/2,k);
			k = k/2;
		}
	}
	
	public void delete(){
		if ( N == 0){ System.out.println("Empty Array");}
		else{
			exch(harr,1,N);
			harr[N--] = null;
			sink(harr,N);
		}
	}
	

	private void sink(Item[] harr2, int n2) {
		int k=1;
	while (2*k <= n2){	
		int j=2*k;
		if ( j < n2 && harr2[j].compareTo(harr2[j+1]) < 0) { j++;}
		if (harr2[k].compareTo(harr2[j]) >= 0 ){ return;}
		else {
			exch(harr2,k,j);
	}
		k = j;
	}
	}
	

	private void exch(Item[] arr, int i, int k) {
		    Item swap = arr[i];
		    arr[i] = arr[k];
		    arr[k] = swap;
	}
	
	public void display(){
		for (int i=1; i<= N ; i++){
			System.out.println(harr[i]);
		}
	}
	
	public static void main(String[] args) {
		
		BinaryHeap<String> bh = new BinaryHeap<String>(10);
		bh.insert("madhu");
		bh.insert("sudhan");
		bh.insert("goud");
		bh.insert("paruchuri");
		bh.insert("annapurna");
		bh.insert("narsimha rao");
		bh.insert("mahesh");
		System.out.println("Displaying Heap");
		bh.display();
		System.out.println("Deleting Items in Heap");
		bh.delete();
		bh.delete();
		bh.delete();
		System.out.println("Deleted 3 items");
		System.out.println("Displaying Heap");
		bh.display();
		System.out.println();
		BinaryHeap<Integer> bh1 = new BinaryHeap<Integer>(10);
		bh1.insert(3);
		bh1.insert(10);
		bh1.insert(5);
		bh1.insert(4);
		bh1.insert(8);
		bh1.insert(2);
		bh1.insert(11);
		bh1.insert(40);
		bh1.insert(80);
		bh1.insert(20);
		bh1.insert(110);
		System.out.println("Displaying Binary Heap");
		bh1.display();
		System.out.println("Deleting Items in Heap");
		bh1.delete();
		bh1.delete();
		bh1.delete();
		System.out.println("Deleted 3 items");
		System.out.println("Displaying Heap");
		bh1.display();
	}
}
