package JavaPgms1;

public class StringCount{
	public static int countNWSChar(String s){
		int count = 0;
		for (int i=0;i<s.length();i++){
			if(!Character.isWhitespace(s.charAt(i))) count++;
		}
		return count;
	}

	public static void main(String[] args){
		System.out.println(countNWSChar(args[0]));
	}

	
}