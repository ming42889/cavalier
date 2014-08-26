package JavaPgms1;

public class Palindrome{
	public static boolean isPalindrome(String s){
		int i1 = s.length()/2-1;
		
		for (int i=0;i<=i1;i++){
			if (s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		if (isPalindrome(args[0])) System.out.println(args[0]+" is a palindrome");
		else System.out.println(args[0]+" isn't a palindrome");
		
	}

}