package LangFun;

import java.util.Random;
public class QuickSort {
	static Random r = new Random();
	public static void sort(int[] a, int i, int k){
		if (i<k){
			int p = partition(a, i, k);
			sort(a, i, p-1);
			sort(a, p+1, k);
		}
	}
	public static int partition(int[] a, int i, int k){
		int pi = r.nextInt(k-i+1)+i;
		int pv = a[pi];
		swap(a, pi, k);

		int si = i;
		for (int j = i;j<k;j++){
			if(a[j]<pv){
				swap(a, j, si);
				si++;
			}
		}
		
		a[k] = a[si];
		a[si] = pv;	
		return si;
	}
	
	public static void swap(int[] arr, int i1, int i2){
		int temp = arr[i1];
		arr[i1]=arr[i2];
		arr[i2]=temp;
	}
	
	public static void main(String[] args){
		int[] arr = InputParser.seqToArr();
		if (!(arr==null)){
			sort(arr,0,arr.length-1);
			System.out.println("The sorted array: ");
			for (int i: arr) System.out.print(i+" ");
			System.out.println();
		} else System.out.println("invalid input");
		
	}
}
