
public class UpdatableAccountImpl implements UpdatableAccount {

	private long currentBalance;
	
	public UpdatableAccountImpl(long initialBalance) {
		currentBalance = initialBalance;
	}
	
	@Override
	public synchronized long balance() {
		return currentBalance;
	}

	@Override
	public synchronized void operation(long amount) throws InsufficientFunds {
		if(currentBalance >= -amount || amount >= 0)
			currentBalance += amount;
		else 
			throw new InsufficientFunds();
	}

}
