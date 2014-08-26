package LoopingExs;

import java.util.Scanner;

public class InputParser {
	public static int[] seqToArr(){
		Scanner sc = new Scanner(System.in);
		String expr = "\\s*(\\d+\\s)*\\d+\\s*";
		System.out.println("Type in a sequence of int (for example 1 2 3 4 5): ");
		String input = sc.nextLine();
		if (input.matches(expr)) {
			String[] list = input.trim().split(" ");
			int[] arr = new int[list.length];
			for(int i=0;i<list.length;i++){
				arr[i]=Integer.parseInt(list[i]);
				//System.out.println(arr[i]);
			}
			return arr;
		}
		else return null;
		
	}
	
	public static int[] parseDate(){
		Scanner sc = new Scanner(System.in);
		String expr = "\\s*\\d+/\\d+/\\d+\\s*";
		System.out.println("Type in a date in format of mm/dd/yyyy): ");
		String input = sc.nextLine();
		if (input.matches(expr)) {
			String[] list = input.trim().split("/");
			int[] arr = new int[list.length];
			for(int i=0;i<list.length;i++){
				arr[i]=Integer.parseInt(list[i]);
			}
			if (!(0<=arr[2]&&arr[2]<10000)) return null;
			if (!(1<=arr[0]&&arr[0]<=12)) return null;
			if (!(1<=arr[1]&&arr[1]<=31)) return null;
			if (arr[0]==2){
				if(arr[2]%4==0&&arr[1]>29) return null;
				if(arr[2]%4!=0&&arr[1]>28) return null;
			}
			if ((arr[0]==4||arr[0]==6||arr[0]==9||arr[0]==11)&&arr[1]>30) return null; 
			return arr;
		}
		else return null;
	}
	
}
