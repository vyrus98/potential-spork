public class DiceTester {
 
    public static void main(String[] args) {
        Die testDie=new Die();
        testDie.roll();
        System.out.println("Test Die is showing " + testDie.getFace());
        System.out.println(testDie.toString());
        
        TwoDice testDice=new TwoDice(10,14);
        testDice.roll();
        System.out.println("Test Dice total is " + testDice.getTotal());
        System.out.println(testDice.toString());
        if (testDice.isDoubles())
            System.out.println("You rolled doubles");
        else
            System.out.println("You did not roll doubles");
    	Account a = new Account("John", 600.0, 0.05);
    	a.setInterestRate(0.05);
    	a.addInterest();
    	System.out.println(a.getBalance());
    }
 
}