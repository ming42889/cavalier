package lectureEx;

public class Consumer extends Thread{
	private RawMaterial RawMat;
	private int number;
	public Consumer(RawMaterial c, int number){
		this.RawMat=c;
		this.number = number;
	}
	
	public void run(){
		int value = 0;
		for (int i=0;i<10;i++){
			value = RawMat.get();
			System.out.println("Consumer#"+this.number+"got: "+value);
		}
	}
}
	