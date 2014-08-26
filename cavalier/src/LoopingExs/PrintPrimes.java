package LoopingExs;

import JavaPgms1.PrimalityTest;
public class PrintPrimes {
	public static void print1(){
		PrimalityTest pl = new PrimalityTest();
		System.out.println("result by for-loop version:");
		for (int i=2;i<100;i++){
			if (pl.isPrime(i, 15)) System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public static void print2(){
		PrimalityTest pl = new PrimalityTest();
		System.out.println("result by while-loop version:");
		int i=2;
		while (i<100){
			if (pl.isPrime(i, 15)) System.out.print(i+" ");
			i++;
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		print1();
		print2();
	}
}
