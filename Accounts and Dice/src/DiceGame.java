
import java.util.Scanner;

/* Sample output for DiceGame:
 ---- Welcome to DiceGame! ----
You may bet by entering "bet" then entering a number,
or quit by entering "q"
Computer and player both roll 2 6-sided dice
High doubles beat low doubles, doubles beat non-doubles, and high beats low
bet
Enter an amount to bet
0.0000001
Bad input, try entering "bet" again, and then a valid input this time please
bet
Enter an amount to bet
1.000001
You are betting $1.0
Computer rolls... 6, 2 for a total of 8
Press enter to roll

You rolled 4, 4 for a total of 8
Lucky, you rolled doubles
You won! Your funds now equal $501.0
bet
Enter an amount to bet
34
You are betting $34.0
Computer rolls... 4, 4 for a total of 8
The computer rolled doubles, good luck
Press enter to roll

You rolled 5, 5 for a total of 10
Lucky, you rolled doubles
You won! Your funds now equal $535.0
q
You finished the game with $535.0, a net of $35.0
 */

public class DiceGame {
	//starting funds, $500
	private double funds = 500.0;
	
	public void run() {
		println("---- Welcome to DiceGame! ----\nYou may bet by entering `bet` then entering a number,\nor quit by entering `q`".replace('`', '"'));
		println("Computer and player both roll 2 6-sided dice\nHigh doubles beat low doubles, doubles beat non-doubles, and high beats low");
		//instantiate 2 TwoDice, 1 each for computer and user
		TwoDice compRoll = new TwoDice();
		TwoDice userRoll = new TwoDice();
		//begin game as infinite loop
		while (true) {
			
			//read user input
			String input = readString();
			
			//if you entered 'bet', 'bEt', 'Bet' etc
			if (input.toLowerCase().equals("bet")) {
				
				//initialize a variable to store your betting amount, ask for input
				double bet;
				println("Enter an amount to bet");
				
				//try catch for parsing a double out of your input
				try {
					
					bet  = ((int)(Double.parseDouble(readString())*100)/100);
					
					//check that the amount user is betting is a real amount (greater than 1 cent, not more than your available funds)
					if (bet > 0.0 && bet <= funds) {
						//print it
						println("You are betting $" + bet);
						
						//initialize a boolean for determining whether user won this round
						boolean win;
						
						//have the computer roll their TwoDice, get total and determine if dubs
						compRoll.roll();
						int compTotal = compRoll.getTotal();
						boolean compDubs = compRoll.isDoubles();
						
						//print it
						println("Computer rolls... " + compRoll.getFaces() + " for a total of " + compTotal);
						if (compDubs) {
							println("The computer rolled doubles, good luck");
						}
						
						//ask user for input, waiting on readString()
						println("Press enter to roll");
						readString();
						
						//roll your TwoDice, get total and determine if dubs
						userRoll.roll();
						int userTotal = userRoll.getTotal();
						boolean userDubs = userRoll.isDoubles();
						
						//print it
						println("You rolled " + userRoll.getFaces() + " for a total of " + userTotal);
						if (userDubs) {
							println("Lucky, you rolled doubles");
						}
						
						//check for a winner
						//if both or neither of you rolled dubs, the winner is the one with a higher total, sets win to true if you were the winner, Vice Versa
						if ((compDubs && userDubs) || (!compDubs && !userDubs)) {
							win = (userTotal > compTotal);
						}
						//otherwise (one but not the other rolled dubs, only other outcome) winner is whoever got dubs
						else {
							win = (userDubs);
						}
						
						//if you won this round, add your bet to your funds and print
						if (win) {
							funds += bet;
							println("You won! Your funds now equal $" + funds);
						}
						//otherwise subtract your bet from your funds and print
						else {
							funds -= bet;
							println("You lost, your funds now equal $" + funds);
						}
					}
					
					//if you tried to bet less than 1 cent or more than your funds
					else {
						println("Bad input, try entering `bet` again, and then a valid input this time please".replace('`', '"'));
					}
				}
				
				//catch error thrown by parseDouble
				catch (NumberFormatException e) {
					println("Bad Input " + e.getMessage());
				}
			}
			
			//if you input a 'q', break the while loop, game is over
			else if (input.toLowerCase().equals("q")) {
				break;
			}
			//if you input anything other than 'q' or 'bet' initially, error
			else {
				println("Bad input");
			}
		}
		//when game is over, print out your final funds and net
		println("You finished the game with $" + funds + ", a net of $" + (funds - 500.0));
	}
	
	public String readString() {
		Scanner scan=new Scanner(System.in);
		String input=scan.nextLine();
		//scan.close();
		return input;

	}
	
	public void print(String s) {
		System.out.print(s);
	}
	public void println(String s) {
		System.out.println(s);
	}
	

	public static void main(String[] args) {
		DiceGame g = new DiceGame();
		g.run();
	}
}
