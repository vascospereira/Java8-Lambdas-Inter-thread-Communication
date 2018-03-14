import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class TestPriceHolder {

	public static void main(String[] args) {
		PriceHolder ph = new PriceHolder();
		priceConsumers(ph).start();
		priceProducers(ph).stream().forEach(t -> {
			t.start();
			threadWaitOneSecond();
		});
	}

	private static Thread priceConsumers(PriceHolder ph) {
		return new Thread(() -> {
			while (true) {
				tryCatchConsumer(ph, "a");
				tryCatchConsumer(ph, "b");
			}
		});
	}

	private static List<Thread> priceProducers(PriceHolder ph) {
		return Arrays.asList(new Thread(() -> tryPutPrice(ph, "a", new BigDecimal(10))),
				new Thread(() -> tryPutPrice(ph, "a", new BigDecimal(10))),
				new Thread(() -> tryPutPrice(ph, "a", new BigDecimal(12))),
				new Thread(() -> tryPutPrice(ph, "a", new BigDecimal(12))),
				new Thread(() -> tryPutPrice(ph, "b", new BigDecimal(4))),
				new Thread(() -> tryPutPrice(ph, "a", new BigDecimal(12))),
				new Thread(() -> tryPutPrice(ph, "b", new BigDecimal(6))),
				new Thread(() -> tryPutPrice(ph, "b", new BigDecimal(6))),
				new Thread(() -> tryPutPrice(ph, "a", new BigDecimal(9))),
				new Thread(() -> tryPutPrice(ph, "a", new BigDecimal(9))));
	}

	private static void tryPutPrice(PriceHolder ph, String entity, BigDecimal price) {
		ph.putPrice(entity, price);
		System.out.println("Price for \"" + entity + "\": $" + price);
	}

	private static void tryCatchConsumer(PriceHolder ph, String entity) {
		BigDecimal price = null;
		try {
			price = ph.waitNewPrice(entity);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("New Price for \"" + entity + "\": $" + price);
	}

	private static void threadWaitOneSecond() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
