
package temp;

public class Insertion {
	
	public static void sort(int a[]){
		for (int i=0;i<a.length;i++){
			for(int j=i;j>0;j--){
				if (a[j] < a[j-1]){
					int swap = a[j];
					a[j]=a[j-1];
					a[j-1]=swap;
				}
				else {break;}
				
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {5,4,6,3,7,8,2,10,1,0,20,40,15,2,3};
		Insertion.sort(a);
		
		for ( int i=0; i< a.length;i++){ System.out.println(a[i]);
		}
	}

}
