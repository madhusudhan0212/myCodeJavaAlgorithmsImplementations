package temp;

public class MyQuickSort<T extends Comparable<T>> {

	public static<T extends Comparable<T>> void sort(T[] a) {
		sort(a,0,a.length - 1);
	}
	
	private static<T extends Comparable<T>> void sort(T[] a, int i, int j) {
		if (i >= j) return;
		int mid = partition(a,i,j);
		sort(a,i,mid-1);
		sort(a,mid+1,j);
	}
	
	public static<T extends Comparable<T>> void swap (T[] a, int i, int j) {
	  T temp = a[i];
	  a[i] = a[j];
	  a[j] = temp;
	}
	private static<T extends Comparable<T>> int partition (T[] a, int l0, int hi){
		int k = l0;
		int i = l0;
		int j = hi + 1 ;
		
		while(true) {
			while(a[++i].compareTo(a[k]) < 0){
				if ( i == hi ) break;	
			}
			while(a[--j].compareTo(a[k]) > 0){}
			if (i >= j) break;
			swap (a,i,j);
		}
		swap(a,l0,j);
	    return j;
	}
	
	public static void main(String[] args) {
		Integer[] a = {1,4,3,7,4,8,2};
		String[] b = {"mad","arj","pav","chan","pav"};
		for (int i=0;i < a.length;i++) System.out.print(a[i]);
		MyQuickSort.sort(a);
		System.out.println();
		for (int i=0;i < a.length;i++) System.out.print(a[i]);
		System.out.println();

		for (int i=0;i < b.length;i++) System.out.println(b[i]);
		MyQuickSort.sort(b);
		System.out.println();
		for (int i=0;i < b.length;i++) System.out.println(b[i]);

	}
}
