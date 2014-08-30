package JavaPgms1;

public class PowerOf2{
	public static boolean isPowerOf2(int i){
		return ((i != 0) && ((i & (~i + 1)) == i));
	}

	public static void main(String[] args){
		if (isPowerOf2(Integer.parseInt(args[0]))){
			System.out.println(args[0]+" is power of 2");
		} else {
			System.out.println(args[0]+" isn't power of 2");
		}
	}
}