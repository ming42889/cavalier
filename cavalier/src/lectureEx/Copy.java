package lectureEx;

import java.io.*;
public class Copy{
	public static void main(String[] args) throws IOException{
		File inputFile = new File("in.txt");
		File outputFile = new File("out.txt");
		File outputFile2 = new File("out2.txt");
		FileReader in = new FileReader(inputFile);
		FileWriter out = new FileWriter(outputFile);
		String s = "";
		
		int c;
		while((c=in.read()) != -1) {
			out.write(c);
			s+=(char)c;
		}
	
		in.close();
		out.close();
		int [] count = CountVowals.countVowals(s);
		out = new FileWriter("out2.txt");
		out.write("a = "+count[0]+",e = "+count[1]+
			", i = "+count[2]+", o = "+count[3]+", u = "+count[4]);
		out.close();
		 
	}
}