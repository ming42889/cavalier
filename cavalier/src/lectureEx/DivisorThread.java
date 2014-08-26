package lectureEx;

import java.util.List;
import JavaPgms2.Divisor;
import JavaPgms2.PrimeList;

public class DivisorThread extends Thread{
	private PrimeList pl;
	private int start;
	private int end;
	private List result;
	
	public DivisorThread(PrimeList pl, int start, int end, List result){
		this.pl = pl;
		this.start = start;
		this.end =end;
		this.result = result;
	}

	public void run(){
		int maxDiv = 0;	//largest divisor seem so far
		int maxInt = start-1; //the int with the largest divisor
		int div;
		for (int i=start;i<=end;i++){
			div = Divisor.countDivisor(i,pl);
			if (maxDiv<div){
				maxDiv = div;
				maxInt = i;
			}
			
		}
		int[] arr = {maxDiv,maxInt};
		result.add(arr);
		//System.out.println(maxInt+" has largest number of divisor, "+maxDiv+", between 1 to 10000");
	}
}