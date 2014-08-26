package LangFun;

public class ElecResistant{
	public static void main(String[] args){
		double A = Math.PI*Math.pow(.001,2);
		
		System.out.println("Resistant of copper: "+1.78*(10E-8)*(1/A));
		System.out.println("Resistant of silicon: "+2300*(1/A));
	
	}
}