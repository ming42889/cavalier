package lectureEx.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class ListTest {

	public static void main(String[] args){
		System.out.println("List Test");
		ArrayList<String> list = new ArrayList<String>();
		String[] toys = {"Shoe", "Ball", "Frisbee"};
		list.addAll(Arrays.asList(toys));
		System.out.println("List created"+", size="+list.size()+", isEmpty="+list.isEmpty());
		System.out.println("List iteration (unsorted):");
		for (int i=0;i<list.size();i++){
			System.out.println(" "+list.get(i));
		}
		System.out.println("List iteration (reverse):");
		ListIterator<String> iterator = list.listIterator(list.size());
		while (iterator.hasPrevious())
			System.out.println(" "+iterator.previous());
		list.remove(0);
		list.removeAll(Arrays.asList(toys));
		System.out.println("List created"+", size="+list.size()+", isEmpty="+list.isEmpty());
	
	}
}
