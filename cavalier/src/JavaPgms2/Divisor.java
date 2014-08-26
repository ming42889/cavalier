package JavaPgms2;

import java.util.LinkedList;
import java.util.Iterator;

import JavaPgms1.PrimalityTest;
public class Divisor{
	
	/**
	 *  Use a pre-made primelist to count how many divisor a int n has
	 *  Assuming n>0;
	 */
	public static int countDivisor(int n, PrimeList pl){
		
		if (n==1) return 1;
		LinkedList<Integer> expon = new LinkedList<Integer>();
		Iterator<Integer> itr = pl.getItr();
		
		int nextPrime;
		int nextExpon;
		while (itr.hasNext()){
			if (n<=1) break;
			nextPrime = itr.next();
			if (n<nextPrime) break;
			nextExpon = 0;
			while (n%nextPrime==0) {
				n /= nextPrime;
				nextExpon++;	
			}
			expon.add(nextExpon);
		}
		int result=1;
		itr = expon.listIterator();
		while (itr.hasNext()){
			nextExpon = itr.next();
			if (nextExpon!=0) result *=nextExpon+1;
		}
		return result;
	}
	public static void main(String[] args){
		int problemSize =100000;
		double startTime = System.currentTimeMillis();
		PrimeList pl = new PrimeList((int)Math.sqrt(problemSize));
		int maxDiv = 1;	//largest divisor seem so far
		int maxInt = 1; //the int with the largest divisor
		int div;
		for (int i=2;i<=problemSize;i++){
			div = countDivisor(i,pl);
			if (maxDiv<div){
				maxDiv = div;
				maxInt = i;
			}
			
		}
		System.out.println(maxInt+" has largest number of divisor, "+maxDiv+", between 1 to 10000");
		double endTime = System.currentTimeMillis();
		System.out.println("Time spent = "+(endTime-startTime)+"ms");
	
	}
}