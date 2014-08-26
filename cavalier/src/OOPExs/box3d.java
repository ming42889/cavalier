package OOPExs;

public class box3d extends box{
	private int height;
	public box3d(int l, int b, int h){
		super(l,b);
		this.setHeight(h);
	}
	
	public int area(){
		return this.getLength()*this.getBreadth()*2+height*this.getBreadth()*2+this.getLength()*height*2;
	}
	
	public int volume(){
		return this.getLength()*this.getBreadth()*height;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

}
