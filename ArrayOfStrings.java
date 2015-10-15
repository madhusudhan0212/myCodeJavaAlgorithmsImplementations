package temp;


public class ArrayOfStrings {
	String[] arr = new String[1];
	int N=0;
	
	public void push(String key)
	{
		arr[N++] = key;
		if (N == arr.length) { resize(2*arr.length); }
		
	}
	
	public String pop()
	{
		if(N==0){return "No element to Pop";}
		String val = arr[--N];
		arr[N]=null;
		if ( N>0 && N==arr.length/4 ) { resize(arr.length/2); }
		return val;
	}
	
	public boolean isEmpty()
	{
		return N==0;
	}
	
	public void resize(int size){
		String[] copy = new String[size];
		for (int i=0; i < N ; i++){
			copy[i] = arr[i];
		}
		arr = copy;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayOfStrings stack = new ArrayOfStrings();
		System.out.println(stack.isEmpty());
		stack.push("Madhu");
		stack.push("Sudhan");
		stack.push("Goud");
		System.out.println(stack.pop());
		stack.push("Paruchuri");
		stack.push("Madhu");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
