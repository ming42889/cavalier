package lectureEx;

public class ProducerConsumerTest {
	public static void main(String[] args) {
		RawMaterial c = new RawMaterial();
		Producer p1 = new Producer(c,1);
		Consumer c1 = new Consumer(c,1);
		p1.start();
		c1.start();
	}
}