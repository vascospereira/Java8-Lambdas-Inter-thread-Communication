final public class ImmutableAccount implements Account {

	private Account delegate;
	
	public ImmutableAccount(long initialBalance) {
		delegate = new UpdatableAccountImpl(initialBalance);
	}
	
	public ImmutableAccount(Account acct) {
		delegate = acct;
	}
	
	@Override
	public long balance() {
		return delegate.balance();
	}

}
