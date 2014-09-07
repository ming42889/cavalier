package lectureEx.generic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SumDemo<E> {
	public E sum(List<E> elist){
		Iterator<E> itr = elist.listIterator();
		
		E sum = itr.next();
		while(itr.hasNext())
			sum = (E) add(sum, itr.next());
		return sum;	
	}
	public E add(E e1, E e2){
		if (e1 instanceof Integer) return (E) (new Integer((Integer) e1+(Integer) e2));
		if (e1 instanceof Long) return (E) (new Long((Long) e1+(Long) e2));
		if (e1 instanceof Double) return (E) (new Double((Double) e1+(Double) e2));
		else return (E) (new Float((Float) e1+(Float) e2));
	}
	
	public static void main(String[] args){
		List<Integer> intList = new LinkedList<Integer>();
		for (int i=0;i<10;i++) intList.add(i);
		SumDemo<Integer> sumInt = new SumDemo<Integer>();
		System.out.println(sumInt.sum(intList));
	}

}
