package OperatorEx;

public class Survey{
	private double[] data;
	public Survey(){
		double[] d = {35.0,40.5,25.0,31.25,68.15,47.0,26.65,29.0,53.45,62.5};
		this.data = d;
	}
	public void printStat(){	
		double min = data[0]; 
		double max = data[0];
		double sum = 0;

		for (double d: data){
			sum += d;
			if (d<min) min = d;
			if (d>max) max = d;
		}
		System.out.println(String.format("Avg = %.4f, Range = %.4f",sum/data.length, (max-min)));

	}
	public static void main(String[] args){
		Survey s = new Survey();
		s.printStat();
	}
}