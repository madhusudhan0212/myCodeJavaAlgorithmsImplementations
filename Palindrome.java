package temp;

public class Palindrome {

	public boolean palincheck(char[] a){
		boolean palin = true;
		for (int i=0,j=a.length-1;i<j;i++,j--){
			if(a[i] != a[j]){ palin = false; break;}
	    }
		return palin;
    }
	
	public static void main(String[] args){
		Palindrome pd = new Palindrome();
		int a = 123454321;
		String wort = Integer.toString(a);
		String wort1 = "reliefpcbpfeiler";
	    char[] warray = wort.toCharArray(); 
		System.out.println(pd.palincheck(warray));
	}
}
