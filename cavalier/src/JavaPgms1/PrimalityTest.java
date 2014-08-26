package JavaPgms1;

import java.math.BigInteger;
import java.util.Random;


public class PrimalityTest {
	
	/**
	 * A naive approach for primality test
	 */
	public boolean isPrime(int n){
		// base cases
		if (n==2) return true;
		if (n<2 || n%2==0) return false;
		
		for (int i=3;i<=Math.sqrt(n);i+=2) {
			if (n%i==0) return false;
		}
		return true;
	}
	
	/**
	 * A primality test based on miller-rabin algorithm
	 *  k is a factor for accuracy
	 */
	public boolean isPrime(int n, int k){
		// base cases
		if (n==2||n==3) return true;
		if (n<2 || n%2==0) return false;
		
		if (k<1) k=1; //k can't be smaller than 1
		int a;
		Random r = new Random();
		
		int d = n-1;
		int s = 0;	
		while (d%2==0){
			d /= 2;
			s++;
		}

		BigInteger x;
		while (k>0){
			a = r.nextInt(n-3)+2;	// Generate random int in range(2, n-2)
			x = BigInteger.valueOf(a).pow(d).mod(BigInteger.valueOf(n));
			
			
			if(x.intValue()==1 || x.intValue()==n-1) {
				k--;
				continue;
			}
			
			int i = s-1;
			while (i>0){
				x = x.pow(2).mod(BigInteger.valueOf(n));
			
				if(x.intValue()==1) return false;
				if(x.intValue()==n-1) break;
				i--;
			}
			if (i>0) {
				k--;
				continue;	
			}
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args){
		PrimalityTest p = new PrimalityTest();
		System.out.println("Output by naive approach: "+
				p.isPrime(Integer.parseInt(args[0])));	
		System.out.println("Output by running Miller_Rabin with k=10: "+
				p.isPrime(Integer.parseInt(args[0]), 10));	
	}

}
