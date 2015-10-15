package temp;

public class MergesortComparable <T extends Comparable<T>> {
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void sort(T[] a){
		T[] aux = (T[]) new Comparable[a.length];
		sort(a,aux,0,a.length-1);
	}
	
	private static <T extends Comparable<T>> void sort(T[] a, T[] aux , int low , int high){
		if ( low >= high){return;}
		int mid = low + (high - low)/2 ;
		sort(a,aux,low,mid);
		sort(a,aux,mid+1,high);
		merge(a,aux,low,mid,high);
		
	}
	
	private static <T extends Comparable<T>> void merge(T[] a,T[] aux,int low,int mid,int high){
		for ( int i=low;i <= high ; i++){
			aux[i]=a[i];
		}
		
		int N=low;
		int i=low;
		int j=mid+1;
		
		while ( N <= high){
			if (i > mid) { a[N++]=aux[j++];}
			else if (j > high){a[N++] = aux[i++];}
			else if(aux[j].compareTo(aux[i])<0){ a[N++] = aux[j++];}
			else { a[N++] = aux[i++]; } 
			}
		}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] y = {5,4,6,3,7,8,2,10,1,0,20,40,15,2,3};
		MergesortComparable.sort(y);
		for ( int i=0; i< y.length;i++){ System.out.println(y[i]);
	}

		String[] b = {"Madhusudhan","Mahesh","Annapurna"};
	   MergesortComparable.sort(b);
		for ( int i=0; i< b.length;i++){ System.out.println(b[i]);
		}
	   
	}

}
