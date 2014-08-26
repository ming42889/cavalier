package lectureEx;

public class ReverseString {
	public static void main(String[] args){
		System.out.println(reverse(args[0]));
	}
	
	public static String reverse(String s) {
		String out = "";
		for (int i = s.length()-1;i>=0;i--){
			out+=s.charAt(i);
		}
		
		return out;
	}
}
