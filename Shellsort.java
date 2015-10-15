package temp;

public class Shellsort {
	
	public static void sort(int a[]){
		
		int N = a.length;
		int h=0;
		while ( h < N/3 ){
			h = 3*h + 1 ;
		}
		
		
		
		while (h>=1){
		for (int i=h;i<a.length;i++){
			
			for(int j=i;j>=h;j -= h){
				if (a[j] < a[j-h]){
					int swap = a[j];
					a[j]=a[j-h];
					a[j-h]=swap;
				}
				else {break;}
				
			}
			
		}
		h=h/3;
	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {5,4,6,3,7,8,2,10,1,0,20,40,15,2,3,80,100,60,500,300,200};
		Shellsort.sort(a);
		for ( int i=0; i< a.length;i++){ System.out.println(a[i]);
		}
	}

}
