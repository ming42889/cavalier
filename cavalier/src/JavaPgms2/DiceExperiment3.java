package JavaPgms2;

public class DiceExperiment3{

	public static void run(PairOfDice dices, StatCalc calc, int n){

		for (int i=0;i<10000;i++){
			calc.enter(DiceExperiment.run(dices,n));
		}	
	}

	public static void printResult(StatCalc[] calc){
		System.out.println("Total On Dice\tAverage Number of Rolls\tStandard Deviation\tMax roll");
		System.out.println("-------------\t-----------------------\t------------------\t--------");
		for (int i=0;i<calc.length;i++) 
			System.out.println(String.format("%13d\t%23.2f\t%17.2f\t%8d", i+2, calc[i].getMean(),calc[i].getStandardDeviation(), (int) calc[i].getMax()));
	}
	
	public static void main(String[] args){
		PairOfDice dices = new PairOfDice();
		StatCalc[] calc = new StatCalc[11];
		
		for (int i=0;i<calc.length;i++){
			calc[i] = new StatCalc();
			run(dices, calc[i],i+2);
		}
		
		printResult(calc);
	}
}