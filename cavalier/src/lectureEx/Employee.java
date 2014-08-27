package lectureEx;

import java.io.*;
public class Employee implements Serializable{
	int empno;
	String name;
	void diso(){
		System.out.println("Emp no  :+empno");
		System.out.println("Emp Name:"+name);
	}
	void setValue(int eno, String na){
		empno=eno;
		name = na;	
	}
}
