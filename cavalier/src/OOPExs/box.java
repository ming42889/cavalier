package OOPExs;

public class box {
	private int length;
	private int breadth;
	
	public box(int l, int b){
		this.setBreadth(b);
		this.setLength(l);
	}
	
	public int area(){
		return length*breadth;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
