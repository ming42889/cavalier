package lectureEx.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {
	public static void main(String[] args){
		System.out.println("Collection HastMap Test");
		Map<String, Employee> collection1 = new TreeMap<String, Employee>();
		System.out.println("Collection 1 created, size="+collection1.size()
					+", isEmpty="+collection1.isEmpty());
		
		
		collection1.put("Harriet",new Employee(1,""));
		collection1.put("Bailey",new Employee(2,""));
		collection1.put("Max", new Employee(3,""));
		collection1.put("Max1", new Employee(6,""));
		collection1.put("Ma2x", new Employee(7,""));
		collection1.put("Max3", new Employee(8,""));
		collection1.put("Max4", new Employee(9,""));
		

		/*
		String key = new String("Harriet");
		if(collection1.containsKey(key));
			System.out.println("Collection1 access, key="+key+", value="+ collection1.get(key));
			Set keys = collection1.keySet();
			System.out.println("Collection1 iteration (unsorted), collection contains");
			Iterator iterator = keys.iterator();
			while (iterator.hasNext())
				System.out.println(" "+iterator.next());
			collection1.clear();
			System.out.println("Collection1 cleared, size="+collection1.size()+", isEmpty="+collection1.isEmpty());
	*/
		Object[] a;
		a = collection1.values().toArray();
		Arrays.sort(a);
		System.out.println(a[0]);
		System.out.println(a[a.length-1]);
		
	}
}
