package prodconsumer;

public class ProducerConsumerTest {

	public static void main(String[] args) throws InterruptedException {
		
		Even e = new Even();
		
		new Thread(()->{
			int number = 0;
			for (int i = 0; i < 10; i++) {
				number = e.get();
				System.out.println("Get #" + number);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}
		}, "Consumer").start();
		
		Thread.sleep(500);
		
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				e.put(i);
				System.out.println("Put #" + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}
		}, "Producer").start();
	}
}
