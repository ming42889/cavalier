package JavaPgms2;

import java.util.Scanner;
public class SnakeEyes{
	public static int findSnakeEyes(Dice d1, Dice d2, int n){
		int i;
		int i1,i2;
		for (i=0;i<n;i++){
			i1 = d1.roll(); i2 = d2.roll();
			if (i1==i2&&i2==1){
				i++;
				break;
			}
		}
		return i;
	}
	
	public static void main(String[] args){
		Dice d1 = new Dice(); 
		Dice d2 = new Dice();
		Scanner sc = new Scanner(System.in);
		int n, result;
		int round = 0;
		while(true) {
			System.out.println("Enter the number of round the experiment is going to perform(<=0 to give up): ");
			n = sc.nextInt();
			if(n<=0) break;
			result = findSnakeEyes(d1, d2, n);
			round += result;
			if (result<n) {
				System.out.println("SnakeEyes is observed in round "+round);
				break;
			}
		} 
	}
}