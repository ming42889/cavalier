package LangFun;

public class PrintByte{
	public static void print(int bytes){
		if (bytes<1000) System.out.println(String.format("%d Byte are %f Byte",bytes, (double) bytes));
		else {
			double b = bytes/1000.0;
			int i;
			for (i=0;b>=1000;i++){
				b/=1000;
			}
			
		
			switch(i){
				case 0: System.out.println(String.format("%d Byte are %f KByte",bytes, b)); break;
				case 1: System.out.println(String.format("%d Byte are %f MByte",bytes, b)); break;
				case 2: System.out.println(String.format("%d Byte are %f GByte",bytes, b));
			}
		}
			
	
	}
	public static void main(String[] args){
		print(Integer.parseInt(args[0]));
	}
}