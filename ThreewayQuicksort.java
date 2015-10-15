
package temp;

public class ThreewayQuicksort {
	
	public static void sort(int a[]){
		sort(a,0,a.length-1);
	}
	
	private static void sort(int a[], int low , int high){
		if ( low >= high){return;}
	
		 int lt = low;
		 int i = low;
		 int gt = high;
		 int N = a[low];
		 
		 while ( i <= gt){
			 if(a[i] < N){
				 int swap = a[i];
					a[i]=a[lt];
					a[lt]=swap;
					lt++;
					i++;
			 }
			 else if(a[i] > N){
				 int swap = a[i];
					a[i]=a[gt];
					a[gt]=swap;
					gt--;
			 }
			 else{
				 i++;
			 }
			 
		 }
		 
		 sort(a,low,lt-1);
		 sort(a,gt+1,high);
		 
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {5,4,6,3,7,8,2,10,7,1,7,2,8,3,4,6,4,0,20,40,15,2,3};
		ThreewayQuicksort.sort(a);
		
		for ( int i=0; i< a.length;i++){ System.out.println(a[i]);
		}
	}

}

