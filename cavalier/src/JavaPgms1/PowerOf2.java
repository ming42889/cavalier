package JavaPgms1;

public class PowerOf2{
	public static boolean isPowerOf2(int i){
		if (i<1) return false;
		if (i==1) return true;
		while(i>1){
			if(i%2!=0) return false;
			i = i/2;
		}
		return true;
	}

	public static void main(String[] args){
		if (isPowerOf2(Integer.parseInt(args[0]))){
			System.out.println(args[0]+" is power of 2");
		} else {
			System.out.println(args[0]+" isn't power of 2");
		}
	}
}