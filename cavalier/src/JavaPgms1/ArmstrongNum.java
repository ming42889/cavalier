package JavaPgms1;

public class ArmstrongNum{
	public static boolean isArmstrong(String s){
		int sum = 0;
		int d;
		for (int i=0;i<s.length();i++){
			d = s.charAt(i)-48;
			sum += d*d*d;
		}
		if (sum==Integer.parseInt(s)) return true;
		else return false;

	}

	public static void main(String[] args){
		if (isArmstrong(args[0])){
			System.out.println(args[0]+" is an Armstrong Number");
		} else {
			System.out.println(args[0]+" isn't an Armstrong Number");
		}
	}
}