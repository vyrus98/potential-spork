
public class Die {
	private int numOfSides;
	private int face = 0;
	
	public Die() {
		this(6);
	}
	
	public Die(int numOfSides) {
		this.numOfSides = numOfSides;
	}
	
	public int roll() {
		face = (int)(Math.random()*numOfSides + 1);
		return getFace();
	}
	
	public int getFace() {
		return face;
	}
	
	public String toString() {
		
		return "current face: " + face + ", static number of sides: " + numOfSides;
	}
}
