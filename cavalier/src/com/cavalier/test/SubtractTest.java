package com.cavalier.test;

import com.cavalier.ops.Subtract;

public class SubtractTest {
	public static void main(String args[]) {
	if (args != null && args.length <= 0) {
		System.out.println("Please supply argument to substract");
		System.exit(-1);
	}
	
	Subtract s = new Subtract();
	int result = s.sub(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	System.out.println("The Subtraction result between "+ args[0] + " and "+args[1]+" is: " +result);

	}
}