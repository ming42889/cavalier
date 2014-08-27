package lectureEx;

import java.io.FileOutputStream;
import java.io.FileReader;

public class ObjectWriterDemo {
	public static void main(String arg[]){
		Employee e1 = new Employee();
		e1.setValue(1001,"Kayal");
		try {
			FileOutputStream out = new FileOutputStream("emp.obj");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	

}
