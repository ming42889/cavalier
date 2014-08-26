package JavaPgms2;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class StatCalc{
	private double max;
	private double min;
	private Set<Double> dataSet;
	public StatCalc(){
		max = Double.NEGATIVE_INFINITY;
		min = Double.POSITIVE_INFINITY;
		dataSet= new HashSet<Double>();
	}
	
	public void enter(double item){
		dataSet.add(item);
		if (max<item) max = item;
		if (min>item) min = item;
	}
	
	public int getCount(){
		return dataSet.size();
	}
	
	public double getSum(){
		Iterator<Double> itr = dataSet.iterator();
		double sum=0;
		while (itr.hasNext()) sum+=itr.next();
		return sum;
	}

	public double getMean(){
		return getSum()/getCount();
	}

	public double getStandardDeviation() {
		double mean = getMean();
		Iterator<Double> itr = dataSet.iterator();
		double sum_squares=0;
		double x;
		while(itr.hasNext()){
			x = itr.next();
			sum_squares += x*x;
		}
		return Math.sqrt(sum_squares/getCount()-mean*mean);
	}

	public double getMin(){
		return min;
	}

	public double getMax(){
		return max;
	}


}