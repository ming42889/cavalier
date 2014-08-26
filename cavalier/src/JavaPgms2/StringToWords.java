package JavaPgms2;

import java.util.Scanner;
public class StringToWords{
	public static void toWords(String s){
		boolean nextWord = false;
		for (int i=0;i<s.length();i++){
			if (Character.isLetter(s.charAt(i))) {
				if (nextWord){
					System.out.println();
					nextWord = false;
				}
				System.out.print(s.charAt(i));
			}
			else nextWord=true;
			
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please type in a line: ");
		toWords(sc.nextLine());
	}
}