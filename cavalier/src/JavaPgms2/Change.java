package JavaPgms2;

import java.util.Scanner;
public class Change{
	int quarters;
	int dimes;
	int nickels;
	int pennies;
	
	public Change(int q, int d, int n, int p){
		this.quarters = q;
		this.dimes = d;
		this.nickels = n;
		this.pennies = p;
	}

	public double total(){
		return .25*quarters+.1*dimes+.05*nickels+.01*pennies;
	}
	public static void main(String[] args){
		int q,d,n,p;
		Scanner sc = new Scanner(System.in);
		System.out.print("How many quarters do you have? " );
		q = sc.nextInt();
		System.out.print("How many dimes do you have? " );
		d = sc.nextInt();
		System.out.print("How many nickels do you have? " );
		n = sc.nextInt();
		System.out.print("How many pennies do you have? " );
		p = sc.nextInt();
		Change c = new Change(q,d,n,p);
		System.out.println(String.format("You have $%.2f", c.total()));
	}
}