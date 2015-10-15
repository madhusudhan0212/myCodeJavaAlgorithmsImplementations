
package temp;

public class Mergesort {
	
	public static void sort(int a[]){
		int[] aux = new int[a.length];
		sort(a,aux,0,a.length-1);
	}
	
	private static void sort(int a[], int aux[] , int low , int high){
		if ( low >= high){return;}
		int mid = low + (high - low)/2 ;
		sort(a,aux,low,mid);
		sort(a,aux,mid+1,high);
		merge(a,aux,low,mid,high);
		
	}
	
	private static void merge(int a[],int aux[],int low,int mid,int high){
		for ( int i=low;i <= high ; i++){
			aux[i]=a[i];
		}
		
		int N=low;
		int i=low;
		int j=mid+1;
		
		while ( N <= high){
			if (i > mid) { a[N++]=aux[j++];}
			else if (j > high){a[N++] = aux[i++];}
			else if(aux[j] < aux[i]){ a[N++] = aux[j++];}
			else { a[N++] = aux[i++]; } 
			}
		}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {5,4,6,3,7,8,2,10,1,0,20,40,15,2,3};
		Mergesort.sort(a);
		
		for ( int i=0; i< a.length;i++){ System.out.println(a[i]);
		}
	}

}
