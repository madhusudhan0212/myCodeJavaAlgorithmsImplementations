package temp;

public class QuicksortComparable<T extends Comparable<T>> {
	
	public static <T extends Comparable<T>> void sort(T[] a){
		sort(a,0,a.length-1);
	}
	
	private static <T extends Comparable<T>> void sort(T[] a, int low , int high){
		if ( low >= high){return;}
		int j = partition(a,low,high) ;
		sort(a,low,j-1);
		sort(a,j+1,high);
	}
	
	private static <T extends Comparable<T>> int partition(T[] a,int low,int high){
		
		int N=low;
		int i=low;
		int j=high+1;
		
	while (true){
		
		
		while (a[N].compareTo(a[++i]) > 0 ) { 
			if ( i == high ) { break;}
			}
		while (a[N].compareTo(a[--j]) < 0){			
		}
		
		if ( i >= j) { break;}
		
		T swap = a[j];
		a[j]=a[i];
		a[i]=swap;
		
	}
	
	T swap = a[j];
	a[j]=a[N];
	a[N]=swap;
	
	return j;
	
	}		
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] a = {5,4,6,3,7,8,2,10,1,0,20,40,15,2,3};
		QuicksortComparable.sort(a);
		
		for ( int i=0; i< a.length;i++){ System.out.println(a[i]);
		}
	}

}

