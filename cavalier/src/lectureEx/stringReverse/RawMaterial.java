package lectureEx.stringReverse;

public class RawMaterial{
	private char contents;
	private boolean available = false;
	public synchronized char get(){
		while(available==false){
			try{
				wait();
			} catch (InterruptedException e){}
		}
		available = false;
		notifyAll();
		return contents;
	}
	
	public synchronized void put(char value){
		while (available==true){
			try{
				wait();
			} catch (InterruptedException e) {}
		}
		contents = value;
		available = true;
		notifyAll();
	}
}