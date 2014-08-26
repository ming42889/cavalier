package JavaPgms2;

import java.util.Scanner;
public class Greeting{
	public static void greets(String name){
		System.out.println("Hello, "+name.toUpperCase()+", nice to meet you!");
	}	

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("What is your name? ");
		greets(sc.nextLine());
	}

}