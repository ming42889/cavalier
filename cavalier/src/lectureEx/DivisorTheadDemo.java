package lectureEx;

import java.util.Iterator;
import java.util.LinkedList;

import JavaPgms2.PrimeList;

public class DivisorTheadDemo {
	public static void main(String[] args){
		double startTime = System.currentTimeMillis();
		LinkedList<int[]> result = new LinkedList<int[]>();
		LinkedList<Thread> ThreadList = new LinkedList<Thread>();
		
		int numOfThread = 4;
	
		int problemSize =100000;
		int subsetSize = problemSize/numOfThread;
		PrimeList pl = new PrimeList((int)Math.sqrt(problemSize));
		
		//create thread and add to the threadlist
		for (int i=0;i<numOfThread;i++) ThreadList.add(new DivisorThread(pl,i*subsetSize+1,(i+1)*subsetSize,result));
		
		//start all threads
		Iterator itr = ThreadList.listIterator();		
		while(itr.hasNext()) ((Thread)(itr.next())).start();
		
		//join all threads
		itr = ThreadList.listIterator();
		while(itr.hasNext()){
			try {
				 ((Thread)(itr.next())).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//converge the result
		int maxDiv = 0;
		int maxInt = 0;
		itr = result.listIterator();		
		int[] r;
		while(itr.hasNext()){
			r = (int[])itr.next();
			if(maxDiv<r[0]) maxDiv = r[0];
			if(maxInt<r[1]) maxInt = r[1];
		}
		
		System.out.println(maxInt+" has largest number of divisor, "+maxDiv+", between 1 to 10000");
		double endTime = System.currentTimeMillis();
		System.out.println("numberOfThread = "+result.size());
		System.out.println("Time spent = "+(endTime-startTime)+"ms");
	}

}
