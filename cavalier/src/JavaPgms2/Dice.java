package JavaPgms2;

import java.util.Scanner;
public class Dice{
	private int val;
	
	public Dice(){
		val = (int) (Math.random()*6)+1;
	}

	public int roll(){
		val = (int) (Math.random()*6)+1;
		return val;
	}
	
	public int getVal(){
		return val;
	}
	
	public static void main(String[] args){
		Dice d1 = new Dice();
		Dice d2 = new Dice();
		Scanner sc = new Scanner(System.in);
		int c1=0,c2=0, totalRoll=0;
		int r;

		while(true) {
			System.out.print("Enter the number of time you want to roll the dice(<=0 to terminate and print result): ");
			r = sc.nextInt();
			if(r<=0) break;

			for (int i=0;i<r;i++){
				if (d1.roll()==3) c1++;
				if (d2.roll()==5) c2++;
				totalRoll++;
			}
		}
		System.out.println("The first die comes up 3 ="+c1+" times");
		System.out.println("The second die comes up 5 ="+c2+" times");
		System.out.println("The total roll is "+totalRoll);	
	}
}