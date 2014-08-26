package OOPExs;

import LangFun.InputParser;
public class Client {
	public static int[] apply(int[] arr){
		Half hf= new Half();
		for(int i=0;i<arr.length;i++) arr[i]=hf.evaluate(arr[i]);
		return arr;
	}
	
	public static void main(String[] args){
		int[] arr = InputParser.seqToArr();
		if (!(arr==null)){
			for(int i: apply(arr)) System.out.print(i+" ");
		} else System.out.println("invalid input");
		 System.out.println();
	}
	
}
