package JavaPgms2;

import java.util.Scanner;
public class CapitalizeString{
	public static String capitalize(String s){
		boolean isFirstLetter = false;
		char c;
		String result="";
		for (int i=0;i<s.length();i++){
			c = s.charAt(i);
			if (Character.isLetter(c)) {
				if (isFirstLetter) {
					result+=Character.toUpperCase(c);
					isFirstLetter = false;
				}
				else result+=c;
			}
			else {
				result+=c;
				isFirstLetter=true;
			}
			
		}
		return result;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please type in a line: ");
		System.out.println(capitalize(sc.nextLine()));
	}
}