package OOPExs;

public class Client3 {
	static class PrintFunc extends Print{
		private Function func;
		public PrintFunc(Function func){
			this.func = func;
		}
		
		public int evaluate(int i) {
			super.evaluate(func.evaluate(i));
			return i;
		}
	}
	
	public static int[] apply(int[] arr){
		PrintFunc pf = new PrintFunc(new Half()); 
		for(int i=0;i<arr.length;i++) arr[i]=pf.evaluate(arr[i]);
		return arr;
	}
	
	public static void main(String[] args){
		int[] arr = new int[10];
		for(int i=0;i<10;i++) arr[i] = i+1;
		apply(arr);
	}
	
}
