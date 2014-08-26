package OperatorEx;

import java.util.Scanner;
public class ComputeSalary{
	private static int base = 1500;
	private static int bonus = 200;
	private static int commission = 2;

	public static int compute(int price, int quantity){
		return base+quantity*bonus+quantity*price*commission;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int price;
		int quantity;
		System.out.print("enter the price of each computer: ");
		price = sc.nextInt();
		System.out.print("enter the number sold during the month: ");
		quantity = sc.nextInt();
		System.out.println("salary = "+compute(price,quantity));
	}
}