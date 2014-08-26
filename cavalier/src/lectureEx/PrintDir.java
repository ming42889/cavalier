package lectureEx;

import java.io.File;
import java.util.Stack;

public class PrintDir {
	public static void main(String[] args){
		File file = new File(new File("").getAbsolutePath());	//current dir
		String root = file.toPath().getRoot().toString();				//root dir
		Stack<String> s = new Stack<String>();
		
		System.out.println(root);
		for (File f:file.listFiles()){
			if (f.getName()=="Users")
			System.out.print(" ->");
		}
		
		
	}

}
