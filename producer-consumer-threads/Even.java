package prodconsumer;

public class Even {

	private int number;
	private boolean even = false;
	
	synchronized public int get() {
		if (!even) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		even = false;
		notify();
		return number;
	}

	synchronized public void put(int number) {
		if (even) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		if(number % 2 == 0){
			even = true;
			this.number = number;
			notify();
		}
	}
}
