package lectureEx;

import java.io.File;
import java.util.Stack;

public class PrintDir {
	public static void main(String[] args){
		File file = new File(new File("").getAbsolutePath());	//current dir
		String root = file.toPath().getRoot().toString();//root dir
		Stack<String> s = new Stack<String>();
		
		for(File temp=file;temp!=null&&!temp.getAbsolutePath().equals(root);temp=temp.getParentFile()){
			s.add("-> "+temp.getName());
			System.out.println(temp.getName());
		}
		s.add(root);
		
		int space = s.size()+1;
		while(!s.isEmpty()){
			System.out.println(space(space-(s.size()+1))+s.pop());
		}
		
		printFileList(file,space);
			
		
	}
	
	static void printFileList(File file, int space){
		for (File f:file.listFiles()){
			if (f.isDirectory()) {
				System.out.println(space(space)+"-> "+f.getName());
				printFileList(f,space+1);
			}
			else System.out.println(space(space)+"-> "+f.getName());
		}
	}
	static String space(int n){
		if(n<=0) return "";	
		return String.format("%1$"+n+"s", "");
	}

}
