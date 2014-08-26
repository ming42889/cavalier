package JavaPgms1;

public class Fib{
	/**
	*  Prints the series of fibonacci upto an integer i recusively
	*  the code is implemented into two seperated method fibRec deals
	*  with base cases and do intialization fibRec2 is the actual 
	*  recursive steps
	*/
	public static void fibRec(int i) {
		if (i <= 0) {
			if (i<0) System.out.println("invalid input");
			else System.out.println(0);
		} else {
			if (i == 1) System.out.println(0+" "+1);
			else {
				int[] a = new int[i+1];
				a[0] = 0; a[1] = 1;
				System.out.print(a[0]+" "+a[1]+" ");
				fibRec2(a, i);
			}
		}
	}

	public static int fibRec2(int[] a, int i) {
		if (i == 0) return 0;
		if (a[i]!=0){
			return a[i];
		} else {
			a[i] = fibRec2(a,i-2)+fibRec2(a,i-1);
			System.out.print(a[i]+" ");
			return a[i];
		}
		
	}

	/**
	*  Prints the series of fibonacci upto an integer i iteratively
	*/
	public static void fibItr(int i) {
		if (i <= 0) {
			if (i<0) System.out.println("invalid input");
			else System.out.println(0);
		} else {
			if (i == 1) System.out.println(0+" "+1);
			else {
				int fn_1 = 1, fn_2 = 0;
				int fn;
				System.out.print(0+" "+1+" ");
				for (int n = 2;n<=i;n++){
					fn = fn_1+fn_2;
					System.out.print(fn+" ");
					fn_2 = fn_1; fn_1 = fn;
				}
			}
		}
	}
	
	public static void main(String[] args){
		System.out.println("Printing out Fib("+args[0]+") by recusive method:");
		fibRec(Integer.parseInt(args[0]));
		System.out.println();
		System.out.println("Printing out Fib("+args[0]+") by iterative method:");
		fibItr(Integer.parseInt(args[0]));
	}
}