public class AccountHolder {
	private UpdatableAccount acct = new UpdatableAccountImpl(0);
	private AccountRecorder recorder;
	
	public AccountHolder(AccountRecorder r){
		recorder = r;
	}
	
	public synchronized void fundOperation(long amount){
		try {
			acct.operation(amount);
			recorder.recordBalance(new ImmutableAccount(acct));
		} catch (InsufficientFunds e) {
			System.out.println("Negative balance.");
		}
	}
}
