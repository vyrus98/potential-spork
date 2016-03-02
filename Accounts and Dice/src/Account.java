public class Account {
	private double balance;
	private String acctHolder;
	private int acctNum;
	private double interestRate;
	
	public Account(String acctHolder, double balance, double interestRate) {
		this.acctHolder = acctHolder;
		this.balance = balance;
		this.interestRate = interestRate;
		acctNum = (int)Math.random()*100000 + 1000;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public String withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
			return "You withdrew " + amount + " dollars";
		}
		else {
			return "You do not have that much money in your account";
		}
	}

	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double rate) {
		interestRate = rate;
	}
	public void addInterest() {
		balance += (interestRate * balance);
	}
}
