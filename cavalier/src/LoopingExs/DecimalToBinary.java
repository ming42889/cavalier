package LoopingExs;

public class DecimalToBinary {
	public static String convert(int n){		
		int i;
		String s="";
		for (i=0;true;i++){
			if(n<1<<i) break;
		}
		s+=1;
		n -= 1<<i-1;
		
		for (int j=i-2;j>=0;j--){
			if(n>=1<<j) {
				n-=1<<j;
				s+=1;
			} 
			else s+=0;
		}
			
		return s;
	}
	
	public static String convert2(int n){
		return Integer.toBinaryString(n);
	}
	
	public static void main(String[] args){
		System.out.println("By first method 42 = "+convert(42));
		System.out.println("By second method 42 = "+convert2(42));
	}
}
