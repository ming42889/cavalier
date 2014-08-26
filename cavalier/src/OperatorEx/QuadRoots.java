package OperatorEx;

import java.util.Scanner;
public class QuadRoots{
	public static boolean verifyInput(String input){
		String regexDecimal = "\\d*\\.\\d+";
		String regexInteger = "\\d+";
		String regexDouble = "(("+regexDecimal+")|("+regexInteger+"))";
		String expr = "\\s*"+"-?"+regexDouble+"x2"+"\\s*"+ "[+|-]" +"\\s*"+regexDouble+"x"+"\\s*"+"[+|-]" +"\\s*"+regexDouble+"\\s*"+"="+"\\s*"+"0"+"\\s*";
		return input.matches(expr);
	}
	
	public static double[] findRoots(double a, double b, double c){
		double[] roots = new double[2];
		roots[0] = -1*b+Math.sqrt(Math.pow(b,2)-4*a*c)/(2*a);
		roots[1] = -1*b-Math.sqrt(Math.pow(b,2)-4*a*c)/(2*a);
		return roots;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String input;
		double a,b,c;
		double[] roots;
		System.out.println("Please type in a quardratic equation(in form of ax2+bx+c=0): ");
		input = sc.nextLine();
		if (verifyInput(input)){
			input = input.replaceAll("(x2)|([x|=])"," ");
			sc = new Scanner(input);
			a = sc.nextDouble();
			b = sc.nextDouble();
			c = sc.nextDouble();
			roots = findRoots(a,b,c);
			for (int i=0;i<roots.length;i++){
				System.out.println(String.format("root %d = %.4f",(i+1), roots[i]));
			}
			
		}
		else System.out.println("invalid input");

	}
}
