package JavaPgms2;

public class DiceExperiment2{

	/**
	 * roll a pair of dices for 10000 round
	 */
	public static double run(Dice d1, Dice d2, int n){
		double avg = 0;
		
		for (int i=0;i<10000;i++){
			avg += DiceExperiment.run(d1,d2,n);
		}
		return avg/10000;
		
		

	}

	public static void printResult(double[] result){
		System.out.println("Total On Dice\tAverage Number of Rolls");
		System.out.println("-------------\t-----------------------");
		for (int i=0;i<result.length;i++) 
			System.out.println(String.format("\t%d\t\t%.4f", i+2, result[i]));
	}
	
	public static void main(String[] args){
		Dice d1 = new Dice();
		Dice d2 = new Dice();
		double[] result = new double[11];
		for (int i=0;i<result.length;i++){
			result[i]=run(d1, d2, i+2);
		}
		printResult(result);
		
		
	}
	
}