import java.util.Scanner;

public class HiLo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String playAgain = "";
		int numberOfTries = 0;
		
		do {
		//Create a random number for the user to guess
		int theNumber = (int)(Math.random() * 100 + 1);
		//System.out.println( theNumber );
		int guess = 0;
		while (guess != theNumber) {
			System.out.println("Guess a number between 1 and 100:");
			guess = scan.nextInt();
			numberOfTries += 1;
			System.out.println("You entered " + guess);
			if (guess < theNumber) {
				System.out.println(guess + " is too low. Try again.");
			} else if (guess > theNumber) {
				System.out.println(guess + " is too high. Try again.");
			} else {
				System.out.println(guess + " is correct! You win! It took you " + numberOfTries + " tries.");
			} //End of while loop for guessing
		} System.out.println("Would you like to play again (y/n)?");
		numberOfTries = 0;
		playAgain = scan.next();
		} 
			while (playAgain.equalsIgnoreCase("y"));
				if (playAgain.equalsIgnoreCase("n")) {
					System.out.println("Thanks for playing my game!");
					scan.close();
				}
	}	
}
