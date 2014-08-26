package lectureEx;

import java.util.Random;
public class RandomArray {
	
	public static void main(String[] args){

		Random r = new Random();
	
		double arr[] = new double[10];
	
		for(int i = 0; i< arr.length; i++) {
		
			arr[i] = r.nextDouble();
	
		}
	
		for (double d: arr) {
		
			System.out.println(d);
   	
		}

	}

}
  
   
 
 
