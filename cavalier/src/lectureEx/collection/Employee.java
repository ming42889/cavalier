package lectureEx.collection;

public class Employee implements Comparable {
	private int id;
	private String name;
	
	public Employee(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public int hashCode(){
		return super.hashCode();
		//return this.id;
	}
	
	public boolean equals(Object o){
		return ((Employee) o).id==this.id;
	}

	@Override
	public int compareTo(Object o) {
		if (((Employee) o).id<this.id) return 1;
		if (((Employee) o).id>this.id) return -1;
		return 0;
	}
	
	public String toString(){
		return id+"";
	}
	
}
