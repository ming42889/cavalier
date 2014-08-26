package JavaPgms2;

import java.util.Scanner;
public class ExprEval{
	public static double eval(double n1, char op, double n2){
		switch (op){
			case '+': return n1+n2;
			case '-': return n1-n2;
			case '*': return n1*n2;
			case '/': return n1/n2;
			default: System.out.println("invalid operator");
				 return 0;
		}
	}
	
	public static void eval(String s){
		double d1, d2;
		char op= ' ';
		int i;
		for (i=0;i<s.length();i++){
			
			if (s.charAt(i)=='+'){ op='+'; break; }
			if (s.charAt(i)=='-'){ op='-'; break; }
			if (s.charAt(i)=='*'){ op='*'; break; }
			if (s.charAt(i)=='/'){ op='/'; break; }
		}
		d1 = Double.parseDouble(s.substring(0,i));
		d2 = Double.parseDouble(s.substring(i+1));
		System.out.println(eval(d1,op,d2));
	}
	
	public static void main(String[] args){
		//String expr = "\\s*"+regexDouble+"\\s*"+regexOp+"\\s*"+regexDouble+"\\s*";
		String regexDecimal = "\\d*\\.\\d+";
		String regexInteger = "\\d+";
		String regexDouble = "(("+regexDecimal+")|("+regexInteger+"))";
		String regexOp = "[+|\\-|*|/]";
		String expr = "\\s*"+regexDouble+"\\s*"+regexOp+"\\s*"+regexDouble+"\\s*";
		String input;
		Scanner sc = new Scanner(System.in);
		System.out.print("Type a simple expression: ");
		input = sc.nextLine();
		if (input.matches(expr)) eval(input);
		else System.out.println("invalid input");
		
	}
}