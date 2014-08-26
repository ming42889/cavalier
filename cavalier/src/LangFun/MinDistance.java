package LangFun;

import java.util.Scanner;
public class MinDistance{
	public static void findMinDis(int[] arr){
		int d = Math.abs(arr[0]-arr[1]);
		int i = 0;
		for(int j=1;j<arr.length-1;j++){
			 if (d>Math.abs(arr[j]-arr[j+1])) {
				 d = Math.abs(arr[j]-arr[j+1]);
				 i = j;
			 }	 
		}
		System.out.println("The minimum distance is "+d+", the index is "+i);
	}

	public static void main(String[] args){
		int[] arr = InputParser.seqToArr();
		if (!(arr==null)){
			findMinDis(arr);
		} else System.out.println("invalid input");
			
	}

}