package JavaPgms1;

public class Factorial{
	public static int factRec(int n){
		if (n<0) {
			System.out.println("invalid input for factRec");
			return -1;
		}
		if (n<=1) return 1;
		return n*factRec(n-1);
	}
	
	public static int factItr(int n){
		int result=1;
		for (int i=n;i>0;i++){
			result*=i;
		}
		return result;
	}

	public static void main(String[] args){
		System.out.println(args[0]+"! = ");
		int n = Integer.parseInt(args[0]);
		System.out.println("By factRec: "+factRec(n));
		System.out.println("By factItr: "+factItr(n));
	}
	
}