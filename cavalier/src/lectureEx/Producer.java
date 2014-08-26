package lectureEx;

public class Producer extends Thread{
	private RawMaterial RawMat;
	private int number;
	public Producer(RawMaterial c, int number){
		RawMat = c;
		this.number = number;
	}
	public void run(){
		for(int i=0;i<10;i++){
			RawMat.put(i);
			System.out.println("Producer#"+this.number+"put: "+i);
			try{
				sleep((int)(Math.random()*100));
			} catch (InterruptedException e){}
		}
	}
}