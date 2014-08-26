package OOPExs;

import JavaPgms1.PrimalityTest;
import JavaPgms1.ArmstrongNum;
import JavaPgms1.Factorial;
public class Number {
	private double val;
	
	public Number(double val){
		this.val = val;
	}
	
	public boolean isZero(){
		return val==0;
	}
	
	public boolean isNegative(){
		return val<0;
	}
	
	public boolean isPositive(){
		return val>=0;
	}
	
	public boolean isEven(){
		return val%2==0;
	}
	
	public boolean isOdd(){
		return val%2!=0;
	}
	
	public boolean isPrime(){
		if (val == (int)val) return new PrimalityTest().isPrime((int)val, 15);
		else return false;	
	}
	
	public boolean isAmstrong(){
		if (val == (int)val) return ArmstrongNum.isArmstrong((int)val+"");
		else return false;	
	}
	
	public double getFactorial(){
		if (val == (int)val) return Factorial.factItr((int)val);
		else return -1;
	}
	
	public double getSqrt(){
		return Math.sqrt(val);
	}
	
	public double getSqr(){
		return val*val;
	}
	
	public double sumDigits(){
		String s = val+"";
		int sum = 0;
		for (int i=0;i<s.length();i++){
			if(Character.isDigit(s.charAt(i))) sum+=Character.getNumericValue(s.charAt(i));
		}
		return sum;
	}
	
	public double getReverse(){
		String s = val+"";
		s = new StringBuffer(s).reverse().toString();
		return Double.parseDouble(s);
		
	}
	
	public void listFactor(){
		if(val!=(int)(val)) System.out.println("None");
		for(int i=1;i<=val;i++){
			if (val%i==0) System.out.println(i+" ");
			
		}
		System.out.println();
	}
	
	public void dispBinary(){
		System.out.println(Integer.toBinaryString((int)val));
	}

}
