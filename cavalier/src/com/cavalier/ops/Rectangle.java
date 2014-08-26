package com.cavalier.ops;

public class Rectangle extends Figure{
	int height;
	int base;
		
	public Rectangle(int h, int b) {
		this.height = h;
		this.base = b;
	}
	public void area() {
		System.out.println(height*base);
			
	}
}

