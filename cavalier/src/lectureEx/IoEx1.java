package lectureEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class IoEx1 {
	public static void main(String[] args){
		char c;
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Type in input:");

		try{
		
			System.out.print(br.readLine());
		} 
		catch (Exception e){}
	}
}
