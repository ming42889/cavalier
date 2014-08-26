package JavaPgms2;

import java.util.Scanner;
public class HexDecimal{
	public static int hexValue(char c){
		if (Character.isDigit(c)) return Character.getNumericValue(c);
		switch(Character.toUpperCase(c)) {
			case 'A': return 10;
			case 'B': return 11;
			case 'C': return 12;
			case 'D': return 13;
			case 'E': return 14;
			case 'F': return 15;	
		}
		return -1;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Please type in a hexdecimal: ");
		String s = sc.nextLine();
		int value = 0;
		int hexVal;
		int i;
		for (i=0;i<s.length();i++){
			hexVal = hexValue(s.charAt(i));
			if (hexVal==-1) {
				System.out.println("invalid input");
				break;
			}
			value=value*16+hexVal;
		}
		if (i == s.length()) System.out.println(value);
	}
}