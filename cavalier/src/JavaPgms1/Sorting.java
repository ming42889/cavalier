package JavaPgms1;

import java.util.Random;

public class Sorting {
	static Random r = new Random();
	public static void quickSort(int[] a, int i, int k){
		if (i<k){
			int p = partition(a, i, k);
			quickSort(a, i, p-1);
			quickSort(a, p+1, k);
		}
	}
	public static int partition(int[] a, int i, int k){
		int pi = r.nextInt(k-i+1)+i;
		int pv = a[pi];
		a[pi] = a[k];
		a[k] = pv;
		int si = i;
		
		int temp;
		for (int j = i;j<k;j++){
			if(a[j]<pv){
				temp = a[j];
				a[j] = a[si];
				a[si] = temp;
				si++;
			}
		}
		
		a[k] = a[si];
		a[si] = pv;	
		return si;
	}
	
	public static void main(String[] args){
		int[] a = new int[10];
		for (int i=0;i<a.length;i++){
			a[i] = r.nextInt(100);
		}
		System.out.println("A random unsorted int array: ");
		for(int i: a) System.out.print(i+" ");
		quickSort(a,0,a.length-1);
		System.out.println();
		System.out.println();
		System.out.println("The sorted array: ");
		for(int i: a) System.out.print(i+" ");
	}
}
