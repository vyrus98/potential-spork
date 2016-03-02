
public class TwoDice {
	private Die die1;
	private Die die2;
	
	public TwoDice() {
		this(6);
	}
	
	public TwoDice(int numOfSides) {
		this(numOfSides, numOfSides);
	}
	
	public TwoDice(int numOfSides1, int numOfSides2) {
		die1 = new Die(numOfSides1);
		die2 = new Die(numOfSides2);
	}
	
	public int roll() {
		die1.roll(); die2.roll();
		return getTotal();
	}
	
	public String getFaces() {
		return die1.getFace() + ", " + die2.getFace();
	}
	
	public int getTotal() {
		return die1.getFace() + die2.getFace();
	}
	
	public boolean isDoubles() {
		return (die1.getFace() == die2.getFace());
	}
	
	public String toString() {
		return die1.toString() + "\n" + die2.toString();
	}
}