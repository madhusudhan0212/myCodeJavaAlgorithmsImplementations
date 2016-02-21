package temp;

public class BubbleSort {

	public static void sort(int[] a){
		while(true)
		{
			boolean swapped = false;
			for(int i =0;i<a.length-1;i++){
				if(a[i] > a[i+1]){
				  int tmp = a[i];
				  a[i] = a[i+1];
				  a[i+1] = tmp;
				  swapped = true;
				}
			}
			if(!swapped){break;}
		}
	}
		
	public static void main(String[] args){
		int[] arr = {5,3,7,4,21,9,11,10};
		for (int i =0;i< arr.length;i++){
			System.out.println(arr[i]);
		}
		BubbleSort.sort(arr);
		System.out.println();
		for (int i =0;i< arr.length;i++){
			System.out.println(arr[i]);
		}
	}
				
}

