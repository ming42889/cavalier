package lectureEx.stringReverse;

import java.util.Scanner;
public class ProducerConsumerTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type in a String: ");
		String input = sc.nextLine();
		RawMaterial c = new RawMaterial();
		Producer p1 = new Producer(c,input);
		Consumer c1 = new Consumer(c,input.length());
		p1.start();
		c1.start();
	}
}