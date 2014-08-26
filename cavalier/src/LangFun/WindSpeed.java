package LangFun;

import java.util.Random;
public class WindSpeed {
	private double v; // velocity in km/h
	public WindSpeed(double v){
		this.v = v;
	}
	
	public double getSpeed(){
		return v;
	}
	
	public boolean isCalm(){
		return v<2;
	}
	
	public boolean isStorm(){
		return v>120;
	}
	
	public double getSpeedInKnots(){
		return v*.53996;
	}
	
	public int getSpeedInBeaufort(){
		return (int)Math.round(Math.pow((v/3.01),2/3.0));

	}
	
	public static void main(String[] args){
		System.out.println(new WindSpeed(120).getSpeedInKnots());
	}
}
