package com.cavalier.test;
import com.cavalier.ops.Figure;
import com.cavalier.ops.Triangle;
import com.cavalier.ops.Rectangle;

public class FigureTest{
	public static void main(String[] args){
	
		Figure r = new Rectangle(10,10);
		Figure t = new Triangle(10,10);
		
		r.area();
		t.area();


	}
}