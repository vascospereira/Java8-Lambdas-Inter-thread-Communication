import java.math.BigDecimal;

public class Entity {
	
	private String entity;
	private BigDecimal price;
	private boolean priceChange;
	
	public Entity(String entity, BigDecimal price, boolean priceChange) {
		this.entity = entity;
		this.price = price;
		this.priceChange = priceChange;
	}

	public String getEntity() {
		return entity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public boolean isPriceChange() {
		return priceChange;
	}
	public void setPriceChange(boolean priceChange) {
		this.priceChange = priceChange;
	}
	@Override
	public String toString() {
		return "Entity [entity=" + entity + ", price=" + price + ", priceChange=" + priceChange + "]";
	}
	
}
