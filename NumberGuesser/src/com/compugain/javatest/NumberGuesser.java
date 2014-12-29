package com.compugain.javatest;

import java.util.Scanner;

/**
 * @author Poorna
 *
 */
public class NumberGuesser {

	private static final String ready = "ready";
	private static final String end = "end";

	private static final String higher = "higher";
	private static final String lower = "lower";
	private static final String yes = "yes";

	private static final String question = "Is the number ";
	private static final String symbol = "?";

	/**
	 * Main method to play the game
	 * @param args
	 */
	public static void main(String[] args) {
		NumberGuesser ng = new NumberGuesser();
		ng.playGame();
	}


	/**
	 * When the user chooses a number in his mind and types 'ready',
	 * this method will guess the chosen number or asks a series of
	 * questions to arrive at the number the user has in mind. User
	 * can only respond with 'higher', 'lower', or 'yes' to play the
	 * game and can use 'end' to terminate the game.
	 * Any invalid response will terminate the game.  
	 */
	public void playGame() {
		Scanner scanner = new Scanner(System.in);
		String user_input = null;
		int no_of_guesses = 0;
		long lower_bound = 0;
		long upper_bound = 10000;
		long random_number = getRandom(lower_bound, upper_bound);

		System.out
				.println("Choose a number in your mind (0 to 10000), system will guess that number."
						+ "\nReply with words 'yes', 'higher' or 'lower' accordingly to play the game !!!\n");

		System.out
				.print("Type 'ready' to begin playing, type 'end' to quit the play:");
		user_input = scanner.next();

		if (end.equalsIgnoreCase(user_input)) {
			System.out.println("Terminating the program ... \nBye !!!");
		} else if (ready.equalsIgnoreCase(user_input)) {
			System.out.println(question + random_number + symbol);
			do {
				no_of_guesses++;
				System.out.print("Reply:");
				scanner.reset();
				user_input = scanner.next();
				if (yes.equalsIgnoreCase(user_input)) {
					System.out
							.println("\nSystem guessed the number in your mind in "
									+ no_of_guesses + " attempt(s)");
					System.out.println("Terminating the program ... \nBye !!!");
					break;
				} else if (higher.equalsIgnoreCase(user_input)) {
					lower_bound = random_number + 1;
					random_number = getRandom(lower_bound, upper_bound);
					System.out.println(question + random_number + symbol);
				} else if (lower.equalsIgnoreCase(user_input)) {
					upper_bound = random_number - 1;
					random_number = getRandom(lower_bound, upper_bound);
					System.out.println(question + random_number + symbol);
				} else {
					System.out
							.println("\nInvalid option, terminating the program ... \nBye !!!");
				}
			} while (user_input.equalsIgnoreCase(higher)
					|| user_input.equalsIgnoreCase(lower));
		} else {
			System.out
					.println("\nInvalid option, terminating the program ... \nBye !!!");
		}
		scanner.close();
	}
	
	/**
	 *  Method to generate random number between two numbers
	 *  i.e., this method takes lower and upper bounds as input  
	 *  and returns a random number in that range including the bounds.
	 *  
	 *  @param lower_bound
	 *  @param upper_bound
	 *  
	 *  @return a random number of type long 		
	 */
	private long getRandom(long lower_bound, long upper_bound) {
		long r = lower_bound
				+ Math.round(Math.random() * (upper_bound - lower_bound));
		return r;
	}

}