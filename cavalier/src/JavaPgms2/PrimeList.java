package JavaPgms2;

import java.util.LinkedList;
import JavaPgms1.PrimalityTest;
import java.util.Iterator;
public class PrimeList{
	private LinkedList<Integer> primeList; //a list a prime
	private int size;


	/**
	 * A list of prime containing all primes upto a give n(exclusive)
	*/
	public PrimeList(int n){
		this.size = n;
		this.primeList = new LinkedList<Integer>(); 
		initialize();
	}
	
	private void initialize(){
		PrimalityTest pt = new PrimalityTest();
		primeList.add(2);
		for (int i=3;i<size;i++){
			if (pt.isPrime(i,15)) primeList.add(i);
		}
	}
	
	public void print(){
		Iterator<Integer> i = primeList.listIterator();
		while(i.hasNext()) System.out.print(i.next()+" ");
		System.out.println();	
	}

	public Iterator<Integer> getItr(){
		return primeList.listIterator();
	}

	public int size(){
		return size;
	}

}