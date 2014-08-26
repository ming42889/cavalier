package lectureEx.stringReverse;

public class Consumer extends Thread{
	private RawMaterial RawMat;
	private int size;
	public Consumer(RawMaterial c, int size){
		this.RawMat=c;
		this.size = size;
	}
	
	public void run(){
		char value;
		for (int i=0;i<size;i++){
			value = RawMat.get();
			System.out.println("Consumer got: "+value);
		}
	}
}
	