package temp;

public class Selection {
	
	public static void sort(int a[]){
		for (int i=0;i<a.length;i++){
			int min=i;
			for(int j=i+1;j<a.length;j++){
				if (a[j] < a[min]){
					min=j;
				}
				
			}
			int swap = a[i];
			a[i]=a[min];
			a[min]=swap;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {5,4,6,3,7,8,2,10,1};
		Selection.sort(a);
		
		for ( int i=0; i< a.length;i++){ System.out.println(a[i]);
		}
	}

}
