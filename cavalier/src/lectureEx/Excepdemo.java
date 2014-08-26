package lectureEx;

public class Excepdemo{
	static void compute(int a) throws myexcep{
		System.out.println("Called compute("+a+")");
			if(a>10)
				throw new myexcep(a);
		System.out.println("Normal exit");
	}
	
	public static void main(String[] args){
		try{
			compute(1);
			compute(20);
		} catch (myexcep e){
			System.out.println("Caught"+e);
		}
			
	}
		static class myexcep extends Exception{
			int a;
			public myexcep(int a){
				super();
				this.a = a;
			}
		}
}