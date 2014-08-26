package JavaPgms2;

public class Egg{
	public static void count(int i){
		int g = i/144;
		i %= 144;
		System.out.println("Your number of eggs is "+g+" gross, "+i/12+" dozen, and "+i%12);	
		
	}
	public static void main(String[] args){
		count(Integer.parseInt(args[0]));
	}
}