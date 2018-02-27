interface UpdatableAccount extends Account {
	void operation(long amount) throws InsufficientFunds;
}
