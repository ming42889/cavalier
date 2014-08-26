package com.cavalier.ops;

public class Triangle extends Figure{
	int height;
	int base;
		
	public Triangle(int h, int b) {
		this.height = h;
		this.base = b;
	}
	public void area() {
		System.out.println(.5*height*base);
			
	}
}
