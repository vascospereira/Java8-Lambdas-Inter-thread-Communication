import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

public final class PriceHolder {

	private final ConcurrentHashMap<String, Entity> data;

	PriceHolder() {
		data = new ConcurrentHashMap<>();
	}

	public void putPrice(String e, BigDecimal p) {
        if (data.containsKey(e)) {
            Entity ent = data.get(e);
            synchronized(this) {
                if (ent.getPrice().compareTo(p) != 0) {
                    ent.setPrice(p);
                    ent.setPriceChange(true);
                    notifyAll();
                }
            }
        } else {
            data.put(e, new Entity(e, p, false));
        }
	}

	public BigDecimal waitNewPrice(String e) throws InterruptedException {
		Entity entity = data.get(e);
		while (entity == null || !entity.isPriceChange()) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException ex) {
					throw ex;
				}
			}
			entity = data.get(e);
		}
		entity.setPriceChange(false);
		return entity.getPrice();
	}
}
