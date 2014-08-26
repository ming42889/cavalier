package JavaPgms2;

import java.util.Scanner;
public class StatCalcTest{
	public static void printStat(StatCalc calc){
		System.out.println("Count = "+calc.getCount());
		System.out.println("Sum = "+calc.getSum());
		System.out.println("Mean = "+calc.getMean());
		System.out.println("sd = "+calc.getStandardDeviation());
		System.out.println("Max = "+calc.getMax());
		System.out.println("Min = "+calc.getMin());
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double item;
		StatCalc calc = new StatCalc();
		while(true){
			System.out.print("Enter the item you want to add to the dataSet(0 to stop and print stat): ");
			item = sc.nextDouble();
			if (item == 0) break;
			else calc.enter(item);
		}
		printStat(calc);
	}
}