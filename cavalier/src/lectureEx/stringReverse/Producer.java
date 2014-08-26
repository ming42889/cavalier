package lectureEx.stringReverse;

public class Producer extends Thread{
	private RawMaterial RawMat;
	private String s;
	public Producer(RawMaterial c, String s){
		RawMat = c;
		this.s = s;
	}
	public void run(){
		for(int i=s.length()-1;i>=0;i--){
			RawMat.put(s.charAt(i));
			System.out.println("Producer put: "+s.charAt(i));
			try{
				sleep((int)(Math.random()*100));
			} catch (InterruptedException e){}
		}
	}
}