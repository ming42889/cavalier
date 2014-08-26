package OOPExs;

import LangFun.InputParser;
public class Client2 {
	public static int[] apply(int[] arr, Function f){
		for(int i=0;i<arr.length;i++) arr[i]=f.evaluate(arr[i]);
		return arr;
	}
	
	public static void main(String[] args){
		int[] arr = new int[10];
		for(int i=0;i<10;i++) arr[i] = i+1;
		apply(arr, new Half());
		apply(arr, new Print());
	}
	
}
