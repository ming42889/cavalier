package JavaPgms2;

public class DiceExperiment{
	public static int run(Dice d1, Dice d2, int n){
		int i;
		for (i=0;true;i++){
			if (d1.roll()+d2.roll()==n){
				i++;
				return i;
			}
		}
	}

	public static int run(PairOfDice dices, int n){
		int i;
		for (i=0;true;i++){
			if (dices.roll()==n){
				i++;
				return i;
			}
		}
	}
	
	public static void main(String[] args){
		Dice d1 = new Dice();
		Dice d2 = new Dice();
		int n = Integer.parseInt(args[0]);
		if (n>=2&&n<=12) System.out.println("The experiment terminates at round "+run(d1, d2, n));
		else System.out.println("invalid input");
		
	}
	
}