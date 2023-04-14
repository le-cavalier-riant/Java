// =============================================================================================================== //
//                                                                                                                 //
//                                       Program coded by Artus de Chavagnac                                       //
//                                                                                                                 //
//                                                  December 2022                                                  //
//                                                                                                                 //
//                                        ČVUT - AE 2B 32 PRI - Programming                                        //
//                                                                                                                 //
// =============================================================================================================== //

import java.util.Scanner;
import java.util.Random;

class War {

	private static int turnCount = 1; // will count the number of turns
	private static String clear = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
	// used to clear the console by passing many lines

	static Random random = new Random(); // for the computer part

	static DeckOfCards firstDeck = new DeckOfCards(); // create a new full 52 cards deck
	static DeckOfCards wonFirst = new DeckOfCards((DeckOfCards) null); // will contain the won cards of player 1

	static DeckOfCards secondDeck = new DeckOfCards((DeckOfCards) null); // create a new empty deck
	static DeckOfCards wonSecond = new DeckOfCards((DeckOfCards) null); // will contain the won cards of player 2

	static DeckOfCards toWin = new DeckOfCards((DeckOfCards) null); // will store the cards during equality

	static Scanner read = new Scanner(System.in);


	static void turn(boolean equality) { // PLAYER 1 vs. PLAYER 2

		System.out.println("\n	=== Let's start turn n\u00B0" + turnCount + ". ===");
		System.out.println("\n	=== PLAYER 1, your turn. ===");
		System.out.println("\nYour deck: " + firstDeck.toString());
		System.out.println("\n === Now, chose the card you will use (type the index). ===");

		int indexPlayer1 = read.nextInt() - 1;

		while (indexPlayer1 < 0 || indexPlayer1 >= firstDeck.getSize()) {
		// the user used an index out of the deck

			System.out.println("\n	There is no such card, please chose a corect card.");
			indexPlayer1 = read.nextInt() - 1;

		}

		int rank1 = firstDeck.getRank(indexPlayer1); // the rank of the selected card

		System.out.println("OK, you just chose the card: " + firstDeck.getCard(indexPlayer1) + ".");

		wait(1); // waits 1 second

		System.out.println(clear);
		// we have to pass many lines so that the next player cannot see the previous card and deck

		System.out.println("\n	=== turn n\u00B0" + turnCount + ". ===");
		System.out.println("\n	=== PLAYER 2, your turn. ===");
		System.out.println("\nYour deck: " + secondDeck.toString());
		System.out.println("\n === Now, chose the card you will use (type the index). ===");

		int indexPlayer2 = read.nextInt() - 1;

		while (indexPlayer2 < 0 || indexPlayer2 >= secondDeck.getSize()) {
		// the user used an index out of the deck

			System.out.println("\n	There is no such card, please chose a corect card.");
			indexPlayer2 = read.nextInt() - 1;

		}

		int rank2 = secondDeck.getRank(indexPlayer2); // the rank of the selected card

		System.out.println("OK, you just chose the card: " + secondDeck.getCard(indexPlayer2) + ".");

		wait(1);

		System.out.println(clear);

		if (!equality) { // normal game

			if (rank1 > rank2) { // PLAYER 1 has a bigger card than PLAYER 2

				System.out.println("\n	" + firstDeck.getCard(indexPlayer1) + " is stonger than " + secondDeck.getCard(indexPlayer2) + ".");

				firstDeck.removeAndAdd(indexPlayer1, wonFirst);
				secondDeck.removeAndAdd(indexPlayer2, wonFirst);
				// both chosen cards are going into the won cards deck of PLAYER 1

				System.out.println("\n	=== PLAYER 1 won! ===");

			} else if (rank2 > rank1) { // PLAYER 2 has a bigger card than PLAYER 1

				System.out.println("\n	" + firstDeck.getCard(indexPlayer1) + " is weaker than " + secondDeck.getCard(indexPlayer2) + ".");

				firstDeck.removeAndAdd(indexPlayer1, wonSecond);
				secondDeck.removeAndAdd(indexPlayer2, wonSecond);
				// both chosen cards are going into the won cards deck of PLAYER 2

				System.out.println("\n	=== PLAYER 2 won! ===");

			} else { // equality

				System.out.println("\n	" + firstDeck.getCard(indexPlayer1) + " is equal to " + secondDeck.getCard(indexPlayer2) + ".");

				firstDeck.removeAndAdd(indexPlayer1, toWin);
				secondDeck.removeAndAdd(indexPlayer2, toWin);
				// both chosen cards are going into the storage deck toWin

				System.out.println("\n	=== Equality! ===");

				turnCount++;

				turn(true);

			}

		} else {

			if (rank1 > rank2) { // PLAYER 1 has a bigger card than PLAYER 2

				firstDeck.removeAndAdd(indexPlayer1, wonFirst);
				secondDeck.removeAndAdd(indexPlayer2, wonFirst);
				// both chosen cards are going into the won cards deck of PLAYER 1

				System.out.println("\n	=== PLAYER 1 won! ===");

				wonFirst.addDeck(toWin); // add the card from the equality

			} else if (rank2 > rank1) { // PLAYER 2 has a bigger card than PLAYER 1

				firstDeck.removeAndAdd(indexPlayer1, wonSecond);
				secondDeck.removeAndAdd(indexPlayer2, wonSecond);
				// both chosen cards are going into the won cards deck of PLAYER 2

				System.out.println("\n	=== PLAYER 2 won! ===");

				wonSecond.addDeck(toWin); // add the card from the equality

			} else { // equality

				firstDeck.removeAndAdd(indexPlayer1, toWin);
				secondDeck.removeAndAdd(indexPlayer2, toWin);
				// both chosen cards are going into the storage deck toWin

				System.out.println("\n	=== Equality! ===");

				turnCount++;

				turn(true);

			}

		}

		turnCount++;

	}

	static void turnComputer(boolean equality) { // PLAYER vs. COMPUTER

		System.out.println("\n	=== Let's start turn n\u00B0" + turnCount + ". ===");
		System.out.println("\n	=== PLAYER, your turn. ===");
		System.out.println("\nYour deck: " + firstDeck.toString());
		System.out.println("\n === Now, chose the card you will use (type the index). ===");

		int indexPlayer = read.nextInt() - 1;

		while (indexPlayer < 0 || indexPlayer >= firstDeck.getSize()) {
		// the user used an index out of the deck

			System.out.println("\n	There is no such card, please chose a corect card.");
			indexPlayer = read.nextInt() - 1;

		}

		int rankPlayer = firstDeck.getRank(indexPlayer); // the rank of the selected card

		System.out.println("OK, you just chose the card: " + firstDeck.getCard(indexPlayer) + ".");

		int indexComputer = random.nextInt(secondDeck.getSize()); // select a random card in the deck
		int rankComputer = secondDeck.getRank(indexComputer); // the rank of the selected card

		wait(1);

		System.out.println(clear);

		if (!equality) { // normal game

			if (rankPlayer > rankComputer) { // PLAYER has a bigger card than COMPUTER

				System.out.println("\n	" + firstDeck.getCard(indexPlayer) + " is stonger than " + secondDeck.getCard(indexComputer) + ".");

				firstDeck.removeAndAdd(indexPlayer, wonFirst);
				secondDeck.removeAndAdd(indexComputer, wonFirst);
				// both chosen cards are going into the won cards deck of PLAYER

				System.out.println("\n	=== PLAYER won! ===");

			} else if (rankComputer > rankPlayer) { // COMPUTER has a bigger card than PLAYER

				System.out.println("\n	" + firstDeck.getCard(indexPlayer) + " is weaker than " + secondDeck.getCard(indexComputer) + ".");

				firstDeck.removeAndAdd(indexPlayer, wonSecond);
				secondDeck.removeAndAdd(indexComputer, wonSecond);
				// both chosen cards are going into the won cards deck of COMPUTER

				System.out.println("\n	=== COMPUTER won! ===");

			} else { // equality

				System.out.println("\n	" + firstDeck.getCard(indexPlayer) + " is equal to " + secondDeck.getCard(indexComputer) + ".");

				firstDeck.removeAndAdd(indexPlayer, toWin);
				secondDeck.removeAndAdd(indexComputer, toWin);
				// both chosen cards are going into the storage deck toWin

				System.out.println("\n	=== Equality! ===");

				turnCount++;

				turnComputer(true);

			}

		} else {

			if (rankPlayer > rankComputer) { // PLAYER has a bigger card than COMPUTER

				firstDeck.removeAndAdd(indexPlayer, wonFirst);
				secondDeck.removeAndAdd(indexComputer, wonFirst);
				// both chosen cards are going into the won cards deck of PLAYER

				System.out.println("\n	=== PLAYER won! ===");

				wonFirst.addDeck(toWin); // add the card from the equality

			} else if (rankComputer > rankPlayer) { // COMPUTER has a bigger card than PLAYER

				System.out.println("\n	" + firstDeck.getCard(indexPlayer) + " is equal to " + secondDeck.getCard(indexComputer) + ".");

				firstDeck.removeAndAdd(indexPlayer, wonSecond);
				secondDeck.removeAndAdd(indexComputer, wonSecond);
				// both chosen cards are going into the won cards deck of COMPUTER

				System.out.println("\n	=== COMPUTER won! ===");

				wonSecond.addDeck(toWin); // add the card from the equality

			} else { // equality

				firstDeck.removeAndAdd(indexPlayer, toWin);
				secondDeck.removeAndAdd(indexComputer, toWin);
				// both chosen cards are going into the storage deck toWin

				System.out.println("\n	=== Equality! ===");

				turnCount++;

				turn(true);

			}

		}

		turnCount++;

	}

	static void wait(int time) { // time is in seconds

		try { // we have to use try/catch to prevent an error

			Thread.sleep(time * 1000); // wait for 1000 ms so 1 s

		} catch (InterruptedException e) {

			//

		}

	}

	public static void main(String[] args) {

		firstDeck.shuffle();

		int firstSize = firstDeck.getSize(); // 52

		for (int i = 0; i < firstSize / 2; i++) { // we remove te first half of the deck

			firstDeck.removeAndAdd(0, secondDeck);
			// each iteration, we remove the first card of firstDeck and give it to secondDeck

		}

		// we now have two decks of 26 cards

		System.out.println(clear);
		System.out.println("\n	Welcome to the...\n");

		System.out.println("	_           _   _     _____");
		System.out.println("	\\\\         //  /|\\    ||  \\\\");
		System.out.println("	 \\\\   _   //  // \\\\   ||__//");
		System.out.println("	  \\\\ /|\\ //  //===\\\\  || \\\\");
		System.out.println("	   \\|/ \\|/  //     \\\\ ||  \\\\");
		System.out.println("\n	     G     A     M     E");

		System.out.println("\n	Please, select the game mode by typing:");
		System.out.println("\n	PLAYER 1 vs. PLAYER 2:  [P] + [V] + [P]");
		System.out.println("	PLAYER vs. COMPUTER:    [P] + [V] + [C]");

		boolean computer;

		switch (read.nextLine()) {

			case "pvp":

				computer = false;

				System.out.println("\n	OK, let's start PLAYER 1 vs. PLAYER 2. Good luck!");

				while (firstDeck.getSize() > 0) { // we repeat turn until the deck is empty

					turn(false);

				}

				break;

			case "pvc":

				computer = true;

				System.out.println("\n	OK, let's start PLAYER vs. COMPUTER. Good luck!");

				while (firstDeck.getSize() > 0) { // we repeat turn until the deck is empty

					turnComputer(false);

				}

				break;

			default:

				computer = false;

		}

		read.close();

		int scoreFirst = wonFirst.countBlack();
		int scoreSecond = wonSecond.countBlack();

		System.out.println("\n\n\n === The game is finished. ===");

		if (!computer) {

			System.out.println("\n === PLAYER 1, you scored " + scoreFirst + " points. ===");
			System.out.println("\n === PLAYER 2, you scored " + scoreSecond + " points. ===");

			if (scoreFirst > scoreSecond) { // PLAYER 1 won

				System.out.println("\n === Congratulations PLAYER 1, you won the game! ===");

			} else if (scoreSecond > scoreFirst) { // PLAYER 2 won

				System.out.println("\n === Congratulations PLAYER 2, you won the game! ===");

			} else { // equality

				System.out.println("\n === Unbelievable!! Equality!! ===");

			}

		} else {

			System.out.println("\n === PLAYER, you scored " + scoreFirst + " points. ===");
			System.out.println("\n === COMPUTER, scored " + scoreFirst + " points. ===");

			if (scoreFirst > scoreSecond) { // PLAYER won

				System.out.println("\n === Congratulations PLAYER, you won the game! ===");

			} else if (scoreSecond > scoreFirst) { // COMPUTER won

				System.out.println("\n === Sorry, COMPUTER won the game! ===");

			} else { // equality

				System.out.println("\n === Unbelievable!! Equality!! ===");

			}

		}

	}

}
