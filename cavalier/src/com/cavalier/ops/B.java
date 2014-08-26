package com.cavalier.ops;

public class B{
	public int divide(int a, int b){
		return a/b;
	}
	public int divide1(int a, int b){
		try {
			return a/b;
		}
		catch (ArithmeticException e){
			e.printStackTrace();
			return 0;
		}
	}
}