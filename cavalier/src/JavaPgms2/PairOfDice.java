package JavaPgms2;

public class PairOfDice{
	private int val;
	private Dice d1;
	private Dice d2;
	
	public PairOfDice(){
		this.d1 = new Dice();
		this.d2 = new Dice();
	}
	
	public int roll(){
		val = d1.roll()+d2.roll();
		return val;
	}
	
	public int getD1Val(){
		return d1.getVal();
	} 
	
	public int getD2Val(){
		return d2.getVal();
	} 

	public static void main(String[] args){
		PairOfDice dices = new PairOfDice();
		int i;
		for(i=0;true;i++){
			if(dices.roll()==2) {
				i++;
				break;
			}
		}
		System.out.println("The pair of dice is rolled for "+i+" times before total of two dice is equal to 2.");
	}
}