package OOPExs;

public class AscendingListOfNumbers {
	private int[] array;
	private int length;
	
	public AscendingListOfNumbers(int maxsize){
		length = 0;
		if (maxsize > 0)
			array = new int[maxsize];
		else 
			array = new int[1];
	}

	public void add(int newInt){
		if (length<=array.length){
		array[length]=newInt;
		for(int i=length;i>0;i--){
			if (array[i-1]>array[i]) swap(i-1,i);
		}
		length++;	
		} else {
			int[] arr = new int[length+10];
			for(int i=0;i<length;i++){
				arr[i] = array[i];
			}
			array=arr;
			add(newInt);
		}
	}
	
	public int whichIndex(int number){	
		return binarySearch(number,0,length-1);
	}
	
	private int binarySearch(int n, int l, int r){
		if(l==r){
			if (n==array[l]) return l;
			return -1;
		} 
		else {
			int mid = (l+r)/2;
			if(n==mid) return mid;
			if(n>mid) return binarySearch(n,mid,r);
			return binarySearch(n,l,mid);
		}
	}
	
	public int whichInt(int index){
		if(index<length) return array[index];
		else throw new NullPointerException();
		
	}
	public void removeInt(int index){
		if (index==length-1) length--;
		else {
			for (int i=index;i<length-1;i++){
				array[i]=array[i+1];
			}
		}
	}
	public int length(){
		return length;
	}
	
	private void swap(int i1, int i2){
		int temp = array[i1];
		array[i1]=array[i2];
		array[i2]=temp;
	}
	
	public String toString(){
		String s = "";
		for (int i: array) s+=(i+" ");
		return s;
	}

}
