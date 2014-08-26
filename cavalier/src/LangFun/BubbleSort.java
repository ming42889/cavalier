package LangFun;

import java.util.Scanner;

public class BubbleSort {
	public static void sort(int[] arr){
		boolean swapped = true;
		int n = arr.length;
		while (swapped){
			swapped = false;
			for (int i=1;i<n;i++){
				if(arr[i-1]>arr[i]) {
					swap(arr,i-1,i);
					swapped = true;
				}

			}
			n--;
		}
	}

	public static void swap(int[] arr, int i1, int i2){
		int temp = arr[i1];
		arr[i1]=arr[i2];
		arr[i2]=temp;
	}
	
	public static void main(String[] args){
		int[] arr = InputParser.seqToArr();
		if (!(arr==null)){
			sort(arr);
			System.out.println("The sorted array: ");
			for (int i: arr) System.out.print(i+" ");
			System.out.println();
		} else System.out.println("invalid input");
		
	}
}
