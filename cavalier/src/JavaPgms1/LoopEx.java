package JavaPgms1;

public class LoopEx{
	public static void printStruc(){
		for (int i=0; i<5;i++){
			if (i==0|i==4) System.out.println("* ");
			if (i==1|i==3) System.out.println("*** ");
			if (i==2) System.out.println("***** ");
		}
	}
	
	public static void main(String[] args){
		printStruc();
	}
}