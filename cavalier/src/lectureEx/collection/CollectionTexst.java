package lectureEx.collection;

import java.util.HashSet;
import java.util.Iterator;

public class CollectionTexst {
	public static void main(String[] args){
		System.out.println("Collection Test");
		HashSet<Employee> collection = new HashSet<Employee>();
		Employee dog1 = new Employee(1,"n1");
		Employee dog2 = new Employee(2,"n2");
		Employee dog3 = new Employee(1,"n3");
		System.out.println(dog1.equals(dog3));
		collection.add(dog1);
		collection.add(dog2);
		collection.add(dog3);

		
		
		System.out.println("Collection created, size="+collection.size()+", isEmpty="+collection.isEmpty());
		System.out.println("Collection contains"+dog3+":"+collection.contains(dog3));
		System.out.println("Collection iteration (unsorted)");
		Iterator iterator = collection.iterator();
		while (iterator.hasNext())
			System.out.println(" "+iterator.next());
		collection.remove(dog1);
		collection.clear();
	}

}
