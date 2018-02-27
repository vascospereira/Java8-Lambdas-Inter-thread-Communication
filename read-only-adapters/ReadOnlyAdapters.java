
public class ReadOnlyAdapters {

	public static void main(String[] args) {

		AccountRecorder acctRecorder = new AccountRecorder();
		AccountHolder acctHolder = new AccountHolder(acctRecorder);
		
		acctHolder.fundOperation(100);
		
		acctHolder.fundOperation(-50);
		
		acctHolder.fundOperation(1);
		
		acctHolder.fundOperation(-51);
		
		acctHolder.fundOperation(-1);
		
	}

}
