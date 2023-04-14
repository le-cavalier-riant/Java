// ================================================================================================================= //
//                                                                                                                   //
//                                        Program coded by Artus de Chavagnac                                        //
//                                                                                                                   //
//                                                   December 2022                                                   //
//                                                                                                                   //
//                                         ČVUT - AE 2B 32 PRI - Programming                                         //
//                                                                                                                   //
// ================================================================================================================= //

import java.util.*;
import java.io.*;

class Poker {

	static int playersNumber; // number of players during the game
	static int maxPlayers = 10; // maximum number of players (can go from 9 to 12 depending on specific rule)
	static int toWin = 0; // the money to win during a game
	static int minimalBet = 10; // first value $10
	static int turnBet = 0; // will store the bet during one turn
	static int time = 0; // the time we will wait between two players
	static int turnCount = 0; // will be useful during the loading of a game save
	static int playerCount = 0; // will be useful during the loading of a game save
	static int equalizedPlayers = 0;
	static int spade = 0;
	static int heart = 0;
	static int diamond = 0;
	static int club = 0;
	static int ace = 0;
	static int two = 0;
	static int three = 0;
	static int four = 0;
	static int five = 0;
	static int six = 0;
	static int seven = 0;
	static int eight = 0;
	static int nine = 0;
	static int ten = 0;
	static int jack = 0;
	static int queen = 0;
	static int king = 0;
	static int[] moneyPlayer = new int[maxPlayers]; // will store the money of each player
	static int[] betPlayer = new int[maxPlayers]; // will store the bet of each player
	static boolean newGame = true; // we will make a new game after one ends, while this is true
	static Scanner read = new Scanner(System.in); // needed to reed the inputs
	static DeckOfCards communityCards = new DeckOfCards((DeckOfCards) null); // create a void deck of cards
	static String presentation = "=================================================================================================================\n\n                                       Program coded by Artus de Chavagnac\n\n                                                  December 2022December 2022\n\n                                        \u010cVUT - AE 2B 32 PRI - Programming\n\n=================================================================================================================";
	static String clearScreen = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
	// used to clear the console by passing many lines
	static String[] statePlayer = new String[maxPlayers]; // will store the current state of each player
	static ArrayList <DeckOfCards> container = new ArrayList <DeckOfCards>();
	// will contain the deck of all the players
	static ArrayList <DeckOfCards> finalCardsPlayer = new ArrayList <DeckOfCards>();

	static void firstTurn(int playerCount) {

		turnCount = 1;
		read.nextLine(); // I have to put this to fix a bug
		turnBet = 0; // we reset the bet of this turn since we start it
		System.out.println("\n=================================================================================================================\n");
		System.out.println("	let's start turn n\u00B0 1.\n");

		for (int i = playerCount; i < playersNumber; i++) {

			int j = i + 1;
			System.out.println("	Here are the cards on the table:");
			communityCards.draw(0); // print the cards in the communityCards
			System.out.println("\n	PLAYER " + j + ", your deck:");
			container.get(i).draw(2); // prints the deck of the player

			if (i == 0) { // small blind

				System.out.println("\n	PLAYER 1, you will BET the small BLIND: $" + (minimalBet / 2) + ".");
				statePlayer[i] = "b";
				betPlayer[i] = minimalBet / 2;
				moneyPlayer[i] -= betPlayer[i];
				turnBet = betPlayer[i];

			} else if (i == 1) { // big blind

				System.out.println("\n	PLAYER 2, you will BET the big BLIND: $" + minimalBet + ".");
				statePlayer[i] = "b";
				betPlayer[i] = minimalBet;
				moneyPlayer[i] -= betPlayer[i];
				turnBet = betPlayer[i];

			} else {

				System.out.println("\n	PLAYER " + j +", please type [B] to BET, [K] to CHECK, [C] to CALL, [R] to RAISE, [F] to FOLD, [+] to save the game, or [-] to quit the game.");
				statePlayer[i] = read.nextLine();
				actionPlayer(i);

			}

			System.out.println("\n	OK, PLAYER " + j + ", your turn is FINISHED.");
			wait(time);
			clear();

		}

		equalizer(); // we equalize the bets
		secondTurn(0); // then we start turn 2

	}

	static void secondTurn(int playerCount) {

		turnCount = 2;
		turnBet = 0; // we reset the bet of this turn since we start it
		System.out.println("\n=================================================================================================================\n");
		System.out.println("	let's start turn n\u00B0 2.\n");

		for (int i = playerCount; i < playersNumber; i++) {

			int j = i + 1;
			System.out.println("	Here are the cards on the table:");
			communityCards.draw(3); // print the cards in the communityCards
			System.out.println("\n	PLAYER " + j + ", your deck:");

			if (statePlayer[i].equals("f")) { // the player has already FOLDED

				container.get(i).draw(0); // prints the deck of the player but hidden
				System.out.println("	PLAYER " + j + ", you are already FOLDED.");

			} else {

				container.get(i).draw(2); // prints the deck of the player
				System.out.println("\n	PLAYER " + j + ", please type [B] to BET, [K] to CHECK, [C] to CALL, [R] to RAISE, [F] to FOLD, [+] to save the game, or [-] to quit the game.");
				statePlayer[i] = read.nextLine();
				actionPlayer(i);
				System.out.println("\n	OK, PLAYER " + j + ", your turn is FINISHED.");

			}

			wait(time);
			clear();

		}

		equalizer(); // we equalize the bets
		thirdTurn(0); // then we start turn 3

	}

	static void thirdTurn(int playerCount) {

		turnCount = 3;
		turnBet = 0; // we reset the bet of this turn since we start it
		System.out.println("\n=================================================================================================================\n");
		System.out.println("	let's start turn n\u00B0 3.\n");

		for (int i = playerCount; i < playersNumber; i++) {

			int j = i + 1;
			System.out.println("	Here are the cards on the table:");
			communityCards.draw(4); // print the cards in the communityCards
			System.out.println("\n	PLAYER " + j + ", your deck:");

			if (statePlayer[i].equals("f")) { // the player has already FOLDED

				container.get(i).draw(0); // prints the deck of the player but hidden
				System.out.println("	PLAYER " + j + ", you are already FOLDED.");

			} else {

				container.get(i).draw(2); // prints the deck of the player
				System.out.println("\n	PLAYER " + j + ", please type [B] to BET, [K] to CHECK, [C] to CALL, [R] to RAISE, [F] to FOLD, [+] to save the game, or [-] to quit the game.");
				statePlayer[i] = read.nextLine();
				actionPlayer(i);
				System.out.println("\n	OK, PLAYER " + j + ", your turn is FINISHED.");

			}

			wait(time);
			clear();

		}

		equalizer(); // we equalize the bets
		lastTurn(0); // then we start last turn
		comparator();

	}

	static void lastTurn(int playerCount) {

		turnCount = 4;
		turnBet = 0; // we reset the bet of this turn since we start it
		System.out.println("\n=================================================================================================================\n");
		System.out.println("	let's start turn n\u00B0 4.\n");

		for (int i = playerCount; i < playersNumber; i++) {

			int j = i + 1;
			System.out.println("	Here are the cards on the table:");
			communityCards.draw(5); // print the cards in the communityCards
			System.out.println("\n	PLAYER " + j + ", your deck:");

			if (statePlayer[i].equals("f")) { // the player has already FOLDED

				container.get(i).draw(0); // prints the deck of the player but hidden
				System.out.println("	PLAYER " + j + ", you are already FOLDED.");

			} else {

				container.get(i).draw(2); // prints the deck of the player
				System.out.println("\n	PLAYER " + j + ", please type [B] to BET, [K] to CHECK, [C] to CALL, [R] to RAISE, [F] to FOLD, [+] to save the game, or [-] to quit the game.");
				statePlayer[i] = read.nextLine();
				actionPlayer(i);
				System.out.println("\n	OK, PLAYER " + j + ", your turn is FINISHED.");

			}

			wait(time);
			clear();

		}

	}

	static void equalizer() { // check if every player bet the same amount of bet money

		while (equalizedPlayers != playersNumber) {

			equalizedPlayers = 0;

			for (int i = 0; i < playersNumber; i++) {

				int j = i + 1;

				if (betPlayer[i] != turnBet) { // the player have a different bet

					if (statePlayer[i].equals("f") || statePlayer[i].equals("F")) {
					// the player FOLDED

						equalizedPlayers++;

					} else {

						System.out.println("	PLAYER " + j + ", you have to CALL the current bet: $" + turnBet + ", RAISE or FOLD. (you have $" + moneyPlayer[i] + ")");
						System.out.println("\n	PLAYER " + j + ", please [C] to CALL, [R] to RAISE, [F] to FOLD, [+] to save the game, or [-] to quit the game.");
						statePlayer[i] = read.nextLine();
						actionPlayer(i);

					}

				} else {

					equalizedPlayers++;

				}

			}

		}

	}

	static void comparator() { // compare the cards of every player and give the money to the winner

		for (int i = 0; i < playersNumber; i++) {

			int j = i + 1;

			if (!statePlayer[i].equals("f")) { // the player not FOLDED

				System.out.println("	Here are the cards on the table:");
				communityCards.draw(5); // print the cards in the communityCards
				System.out.println("\n	PLAYER " + j + ", your deck:");
				container.get(i).draw(2); // prints the deck of the player


				if (royalFlushPlayer(i)) {

					System.out.println("	Congratulations PLAYER " + j + ", you have a ROYAL FLUSH!!!");

				} else if (straightFlushPlayer(i)) {

					System.out.println("	Congratulations PLAYER " + j + ", you have a STRAIGHT FLUSH!!");

				} else if (fourOfAKindPlayer(i)) {

					System.out.println("	Congratulations PLAYER " + j + ", you have 4 OF A KIND!");

				} else if (fullHousePlayer(i)) {

					System.out.println("	Congratulations PLAYER " + j + ", you have a FULL HOUSE.");

				} else if (flushPlayer(i)) {

					System.out.println("	Congratulations PLAYER " + j + ", you have a FLUSH.");

				} else if (straightPlayer(i)) {

					System.out.println("	Congratulations PLAYER " + j + ", you have a STRAIGHT.");

				} else if (threeOfAKindPlayer(i)) {

					System.out.println("	Congratulations PLAYER " + j + ", you have 3 OF A KIND.");

				} else if (twoPairsPlayer(i)) {

					System.out.println("	Congratulations PLAYER " + j + ", you have 2 PAIRS.");

				} else if (pairPlayer(i)) {

					System.out.println("	Congratulations PLAYER " + j + ", you have a PAIR.");

				} else {

					System.out.println("	PLAYER " + j + ", you have nothing.");

				}

			}

		}

		System.out.println("	Do you want to play another game? (type [Y] for yes, or [N] for no)");

		newGame = switch (read.nextLine()) {

			case "y", "Y" -> true;
			default -> false;

		};

		if (newGame) {

			for (int i = 0; i < 5; i++) {

				communityCards.removeCard(0); // we have to clean the communityCards deck, if we make another game

			}

			// start() or something like that, I'm too drunk to think about that, but I'm machine enough to be genial!!!

		}

	}

	static boolean royalFlushPlayer(int playerIndex) {
	// includes a 10, Jack, Queen, King, and Ace, of the same suit

		boolean tenInside = false;
		DeckOfCards tens = new DeckOfCards((DeckOfCards) null);

		boolean jackInside = false;
		DeckOfCards jacks = new DeckOfCards((DeckOfCards) null);

		boolean queenInside = false;
		DeckOfCards queens = new DeckOfCards((DeckOfCards) null);

		boolean kingInside = false;
		DeckOfCards kings = new DeckOfCards((DeckOfCards) null);

		boolean aceInside = false;
		DeckOfCards aces = new DeckOfCards((DeckOfCards) null);

		for (int i = 0; i < 5; i++) {

			switch (communityCards.getRankCard(i)) {

				case 10:

					tenInside = true;
					tens.addCard(communityCards.getCard(i));
					break;

				case 11:

					jackInside = true;
					jacks.addCard(communityCards.getCard(i));
					break;

				case 12:

					queenInside = true;
					queens.addCard(communityCards.getCard(i));
					break;

				case 13:

					kingInside = true;
					kings.addCard(communityCards.getCard(i));
					break;

				default:

					aceInside = true;
					aces.addCard(communityCards.getCard(i));

			}

		}

		for (int i = 0; i < 2; i++) {

			switch (container.get(playerIndex).getRankCard(i)) {

				case 10:

					tenInside = true;
					tens.addCard(container.get(playerIndex).getCard(i));
					break;

				case 11:

					jackInside = true;
					jacks.addCard(container.get(playerIndex).getCard(i));
					break;

				case 12:

					queenInside = true;
					queens.addCard(container.get(playerIndex).getCard(i));
					break;

				case 13:

					kingInside = true;
					kings.addCard(container.get(playerIndex).getCard(i));
					break;

				default:

					aceInside = true;
					aces.addCard(container.get(playerIndex).getCard(i));

			}

		}

		if (tenInside && jackInside && queenInside && kingInside && aceInside) {
		// if there is at least one of each, we will check the suits

			spade = 0;
			heart = 0;
			diamond = 0;
			club = 0;
			countSuitsDeck(tens);
			countSuitsDeck(jacks);
			countSuitsDeck(queens);
			countSuitsDeck(kings);
			countSuitsDeck(aces);

			if (spade == 5) {

				return true;

			}

			if (heart == 5) {

				return true;

			}

			if (diamond == 5) {

				return true;

			}

			if (club == 5) {

				return true;

			}

		}

		return false;

	}

	static boolean straightFlushPlayer(int playerIndex) {
	// made up of 5 consecutive cards of the same suit

		boolean spadeInside = false;
		DeckOfCards spades = new DeckOfCards((DeckOfCards) null);

		boolean heartInside = false;
		DeckOfCards hearts = new DeckOfCards((DeckOfCards) null);

		boolean diamondInside = false;
		DeckOfCards diamonds = new DeckOfCards((DeckOfCards) null);

		boolean clubInside = false;
		DeckOfCards clubs = new DeckOfCards((DeckOfCards) null);

		for (int i = 0; i < 5; i++) {

			switch (communityCards.getSuitCard(i)) {

				case "Spades":

					spadeInside = true;
					spades.addCard(communityCards.getCard(i));
					break;

				case "Hearts":

					heartInside = true;
					hearts.addCard(communityCards.getCard(i));
					break;

				case "Diamonds":

					diamondInside = true;
					diamonds.addCard(communityCards.getCard(i));
					break;

				default:

					clubInside = true;
					clubs.addCard(communityCards.getCard(i));

			}

		}

		for (int i = 0; i < 2; i++) {

			switch (container.get(playerIndex).getSuitCard(i)) {

				case "Spades":

					spadeInside = true;
					spades.addCard(container.get(playerIndex).getCard(i));
					break;

				case "Hearts":

					heartInside = true;
					hearts.addCard(container.get(playerIndex).getCard(i));
					break;

				case "Diamonds":

					diamondInside = true;
					diamonds.addCard(container.get(playerIndex).getCard(i));
					break;

				default:

					clubInside = true;
					clubs.addCard(container.get(playerIndex).getCard(i));

			}

		}

		// spades = 0;
		// hearts = 0;
		// diamonds = 0;
		// clubs = 0;

		// countSuitsDeck(communityCards);
		// countSuitsDeck(container.get(playerIndex));

		if (spade == 5) {

			//

		}


		return false;

	}

	static boolean fourOfAKindPlayer(int playerIndex) {
	// means you have 4 cards of the same rank (but different suits, of course) and a fifth card of any rank (such as 4 aces and a 9)

		//
		return false;

	}

	static boolean fullHousePlayer(int playerIndex) {
	// contains 3 matching cards of 1 rank and 2 matching cards of another rank

		//
		return false;

	}

	static boolean flushPlayer(int playerIndex) {
	// contains any 5 cards of the same suit, these skip around in rank or sequence, but are from the same suit

		//
		return false;

	}

	static boolean straightPlayer(int playerIndex) {
	// contains 5 cards of consecutive rank but from more than one suit

		//
		return false;

	}

	static boolean threeOfAKindPlayer(int playerIndex) {
	// means you have 3 cards of the same rank, plus two unmatched cards

		//
		return false;

	}

	static boolean twoPairsPlayer(int playerIndex) {
	// is made up of two cards of one rank, plus two cards of another rank (different from the first pair), plus one unmatched card

		//
		return false;

	}

	static boolean pairPlayer(int playerIndex) {
	// means you have 2 cards of the same rank, plus 3 other unmatched cards

		//
		return false;

	}

	static void countSuitsDeck(DeckOfCards deck) {

		for (int i = 0; i < deck.getSize(); i++) {

			switch (deck.getSuitCard(i)) {

				case "Spades":

					spade++;

				case "Hearts":

					heart++;

				case "Diamonds":

					diamond++;

				default:

					club++;

			}

		}
	}

	static void countRanksDeck(DeckOfCards deck) {

		for (int i = 0; i < deck.getSize(); i++) {

			switch (deck.getRankCard(i)) {

				case 1:

					ace++;

				case 2:

					two++;

				case 3:

					three++;

				case 4:

					four++;

				case 5:

					five++;

				case 6:

					six++;

				case 7:

					seven++;

				case 8:

					eight++;

				case 9:

					nine++;

				case 10:

					ten++;

				case 11:

					jack++;

				case 12:

					queen++;

				default:

					king++;

			}

		}

	}

	static void wait(int time) { // time is in seconds

		try { // we have to use try/catch to prevent an error

			Thread.sleep(time * 1000); // we transform the seconds into milliseconds

		} catch (InterruptedException e) {

			//

		}

	}

	static void actionPlayer(int playerIndex) {

		int j = playerIndex + 1;

		switch (statePlayer[playerIndex]) {

			case "b": // BET
			case "B":

				if (turnBet != 0) { // there is already a bet

					System.out.println("	Sorry but someone has already bet $" + turnBet + ", you will CALL instead. ");
					statePlayer[playerIndex] = "c";
					actionPlayer(playerIndex);
					// we reiterate the actionPlayer(playerIndex) method since statePlayer[playerIndex] changed
					break;

				} // we don't need "else" because there is a "break" before

				// the player can bet

				if (minimalBet > moneyPlayer[playerIndex]) { // the player can't even pay the minimal bet

					System.out.println("	Sorry PLAYER " + j + " but you don't have enough money to play this game, you have to FOLD.");
					statePlayer[playerIndex] = "f"; // make the player FOLD
					actionPlayer(playerIndex);
					// we reiterate the actionPlayer(playerIndex) method since statePlayer[playerIndex] changed
					break;

				} // same here, no "else"

				// betting part

				System.out.println("\n	How much do you want to BET? (minimal bet: $" + minimalBet + " and you have $" + moneyPlayer[playerIndex] + ")");
				betPlayer[playerIndex] = read.nextInt();

				if (betPlayer[playerIndex] < minimalBet) { // the PLAYER want to bet less than the minimal BET

					System.out.println("	Sorry PLAYER" + j + ", but you can't BET less than the minimal BET: $" + minimalBet + ".");
					actionPlayer(playerIndex);
					break;

				}

				if (betPlayer[playerIndex] > moneyPlayer[playerIndex]) { // the player can't pay this bet

					System.out.println("	Sorry, PLAYER" + j + ", but you don't have enough money to BET $" + betPlayer[playerIndex] + ", you have to BET less of FOLD");
					actionPlayer(playerIndex);

				}

				moneyPlayer[playerIndex] -= betPlayer[playerIndex];
				toWin += betPlayer[playerIndex];
				// we take the money of the player and store it into the toWin deck

				if (betPlayer[playerIndex] > turnBet) {

					turnBet = betPlayer[playerIndex];

				}

				break;

			case "c": // CALL
			case "C":

				if (turnBet == 0) { // means that the other players checked

					if (playerIndex == 1) { // first player

						System.out.println("	Sorry, you are the first PLAYER to talk, you cannot CALL someone's bet, you will CHECK.");

					} else {

						System.out.println("	Every other players CHECKED or FOLDED, you will CHECK.");

					}

					statePlayer[playerIndex] = "k";
					actionPlayer(playerIndex);
					// we reiterate the actionPlayer(playerIndex) method since statePlayer[playerIndex] changed
					break;

				} else if (minimalBet > moneyPlayer[playerIndex]) { // the player can't pay the bet

					System.out.println("	Sorry PLAYER " + j + " but you don't have enough MONEY to play this game, you have to FOLD.");
					statePlayer[playerIndex] = "f"; // make the player FOLD
					// we don't break here because we want the "FOLD" state to be performed juste after

				} else { // calling part

					System.out.println("	OK, PLAYER " + j + ", you will CALL $" + turnBet + ".");
					betPlayer[playerIndex] = turnBet;
					moneyPlayer[playerIndex] -= betPlayer[playerIndex];
					toWin += betPlayer[playerIndex];
					// we take the money of the player and store it into the toWin deck

				}

				break;

			case "r": // RAISE
			case "R":

				System.out.println("\n	How much want you to RAISE? (current bet: $" + turnBet + " and you have $" + moneyPlayer[playerIndex] + ")");
				betPlayer[playerIndex] = read.nextInt();

				if (betPlayer[playerIndex] > moneyPlayer[playerIndex]) {

					System.out.println("	Sorry PLAYER " + j + " but you don't have enough money to play this game, you have to CALL.");
					statePlayer[playerIndex] = "c";
					actionPlayer(playerIndex);

				} else {

					System.out.println("	OK, PLAYER " + j + ", you will RAISE $" + betPlayer[playerIndex] + ".");

					if (betPlayer[playerIndex] > turnBet) {

						turnBet = betPlayer[playerIndex];

					}

					moneyPlayer[playerIndex] -= betPlayer[playerIndex];
					toWin += betPlayer[playerIndex];
					// we take the money of the player and store it into the toWin deck

				}

				break;

			case "f": // FOLD
			case "F":

				System.out.println("	OK, PLAYER " + j + ", you will FOLD.");
				break;

			case "k": // CHECK
			case "K":

				break;

			case "+": // save the game

				saveGame(playerIndex);
				break;

			case "-": // exit the game

				System.out.println("	OK, the game is finished, I hope you enjoyed it!");
				System.exit(0);

			case "":

				System.out.println("\n	PLAYER " + j + ", please type [B] to BET, [K] to CHECK, [C] to CALL, [R] to RAISE, [F] to FOLD, [+] to save the game, or [-] to quit the game.");
				statePlayer[playerIndex] = read.nextLine();
				actionPlayer(playerIndex);

		}

	}

	static void saveGame(int playerIndex) { // we have to store playerIndex in order to proper resume the game

		System.out.println("	What name do you want to give your save?");
		String saveName = read.nextLine();
		System.out.println("	Chose a password for your game save.");
		String password = read.nextLine();

		try {

			File saveFile = new File(saveName);

			if (saveFile.createNewFile()) { // the file is created

				try {

					FileWriter save = new FileWriter(saveName);
					save.write(playersNumber + ",");
					save.write(turnCount + ",");
					save.write(turnBet + ",");
					save.write(playerCount + ",");

					for (int i = 0; i < playersNumber; i++) {

						save.write(container.get(i).toStringCard(0) + ",");
						save.write(container.get(i).toStringCard(1) + ",");
					
					}

					for (int i = 0; i < 5; i++) {

						save.write(communityCards.toStringCard(i) + ",");

					}

					for (int i = 0; i < playersNumber; i++) {

						save.write(moneyPlayer[i] + ",");
						save.write(betPlayer[i] + ",");
						save.write(statePlayer[i] + ",");

					}

					save.write(password);
					save.close();
					System.out.println("	Game successfully saved in the save: " + saveFile.getName() + ".");

				} catch (IOException e) {

					System.out.println("An error occurred, the game is not saved.");

				}
				
			} else { // there is an existing file with this name

				System.out.println("	There already exists a save with the name \"" + saveFile.getName() + "\", please, chose another name.");
				saveGame(playerIndex);

			}

		} catch (IOException e) {

			System.out.println("An error occurred, the game is not saved.");
			saveGame(playerIndex);

		}

		System.out.println("\n	PLAYER " + (playerIndex + 1) + ", please type [B] to BET, [K] to CHECK, [C] to CALL, [R] to RAISE, [F] to FOLD, or [-] to quit the game.");
		statePlayer[playerIndex] = read.nextLine();
		actionPlayer(playerIndex); // there we resume the game

	}

	static void loadGame() {

		System.out.println("	What is the name of the game save?");
		String saveName = read.nextLine();
		System.out.println("	What is the password for this save?");
		String password = read.nextLine();

		try {

			FileInputStream save = new FileInputStream(saveName);
			Scanner readSave = new Scanner(save);
			String[] saveLine = readSave.nextLine().split(",");
			readSave.close();

			playersNumber = Integer.parseInt(saveLine[0]);

			if (password.equals(saveLine[9 + 5 * playersNumber])) {
			// the entered password is correct

				turnCount = Integer.parseInt(saveLine[1]);
				turnBet = Integer.parseInt(saveLine[2]);
				playerCount = Integer.parseInt(saveLine[3]);

				for (int i = 0; i < playersNumber; i++) {

					DeckOfCards deck = new DeckOfCards((DeckOfCards) null);

					for (int j = 0; j < 2; j++) { // every player has 2 cards

						int rank = switch (saveLine[4 + j + 2 * i].split(" ")[0]) {

							case "Ace" -> 1;
							case "King" -> 13;
							case "Queen" -> 12;
							case "Jack" -> 11;
							default -> Integer.parseInt(saveLine[4 + j + 2 * i].split(" ")[0]);

						};

						String suit = saveLine[4 + j + 2 * i].split(" ")[2];
						Card card = new Card(rank, suit);
						deck.addCard(card); // we add the card

					}

					container.add(deck);

				}

				for (int i = 0; i < 5; i++) {

					int rank = switch (saveLine[4 + 2 * playersNumber + i].split(" ")[0]) {

							case "Ace" -> 1;
							case "King" -> 13;
							case "Queen" -> 12;
							case "Jack" -> 11;
							default -> Integer.parseInt(saveLine[4 + 2 * playersNumber + i].split(" ")[0]);

						};

					String suit = saveLine[4 + 2 * playersNumber + i].split(" ")[2];
					Card card = new Card(rank, suit);
					communityCards.addCard(card); // we add the card

				}

				for (int i = 0; i < playersNumber; i++) {

					moneyPlayer[i] = Integer.parseInt(saveLine[9 + 2 * playersNumber + 3 * i]);
					betPlayer[i] = Integer.parseInt(saveLine[10 + 2 * playersNumber + 3 * i]);
					statePlayer[i] = saveLine[11 + 2 * playersNumber + 3 * i];

					if (statePlayer[i].equals("+")) {

						statePlayer[i] = "";

					}

				}

				System.out.println("	The game has been loaded successfully!");
				wait(2);
				clear();

				switch (turnCount) {

					case 1 -> firstTurn(playerCount);
					case 2 -> secondTurn(playerCount);
					case 3 -> thirdTurn(playerCount);
					default -> lastTurn(playerCount);

				}

			} else {

				System.out.println("	Sorry but the entered password is not correct");
				start();

			}

		} catch (FileNotFoundException e) {

			System.out.println("	Sorry, there is no such game save named \"" + saveName + "\".");

			loadGame();

		}

	}

	static void encrypt(String file, String key) { // will encrypt the save file for saving

		//

	}

	static void decrypt(String file, String key) { // will decrypt the save file for loading

		//

	}

	static void clear() { // clear the screen

		System.out.println(clearScreen);

	}

	static void start() {

		System.out.println(
			"\n\n" +
			"                     ~ MENU ~ \n" + 
			"       =============          =============\n\n" +
			"	[N] : New game  |  [L] : Load game\n" +
			"	[Q] : Quit      |  [C] : Credits\n\n" + 
			"       ====================================\n"
		);

		switch (read.nextLine()) {

			case "n": // new game
			case "N":
			case "":

				System.out.println("\n	How many players will be on the game? (from 2 to " + maxPlayers + ")");

				try {

					playersNumber = read.nextInt();

				} catch (InputMismatchException e) {

					System.out.println("	Please, enter an integer between 2 and " + maxPlayers + ".");
					start();
					break;

				}

				if (playersNumber > maxPlayers) {

					System.out.println("	Sorry but there are too many players.");
					read.nextLine();
					start();
					break;

				} else if (playersNumber < 2) {

					System.out.println("	Sorry but there are not enough players.");
					read.nextLine();
					start();
					break;

				}

				System.out.println("	OK, let's start the game with " + playersNumber + " players. Good luck!!");

				for (int i = 0; i < playersNumber; i++) {

					moneyPlayer[i] = 100; // every player starts with $100

				}

				DeckOfCards mainDeck = new DeckOfCards(); // create the main 52-card deck
				mainDeck.shuffle();

				for (int i = 0; i < playersNumber; i++) {

					DeckOfCards deck = new DeckOfCards((DeckOfCards) null); // we create an empty deck
					mainDeck.removeAndAdd(0, deck);
					mainDeck.removeAndAdd(0, deck);
					// remove the first two cards from mainDeck and give it to deck
					container.add(deck); // we add the deck as an element of container

				}

				for (int i = 0; i < 5; i++) {

					mainDeck.removeAndAdd(0, communityCards); // we give 5 cards to the communityCards

				}

				// now that the cards are distributed between the players, we can start the game
				firstTurn(0); // we start first turn, which will start the other turns
				break;

			case "q": // quit the game
			case "Q":

				System.out.println("	OK, goodbye!");
				break;

			case "c": // credits
			case "C":

				System.out.println(presentation);
				start();
				break;

			case "l": // load a game save
			case "L":

				loadGame();
				break;

			default:

				System.out.println("	Sorry, I don't understand.");
				start();

		}
	}


	public static void main(String[] args) {

		System.out.println("\n		Welcome to the...");
		System.out.println("\n	        ____			_____     ___    __  _  ______  _____		        ____");
		System.out.println("	   __--- __ ---__		||  \\\\   // \\\\   || //  ||      ||  \\\\		   __--- __ ---__");
		System.out.println("	  / __---  ---__ \\		||__//  ||   ||  ||//   ||___   ||__//		  / __---  ---__ \\");
		System.out.println("	 / /   /-||--   \\ \\		||      ||   ||  ||\\\\   ||      || \\\\		 / /   /-||--   \\ \\");
		System.out.println("	| |   |  ||      | |		||       \\\\_//   || \\\\  ||____  ||  \\\\		| |   |  ||      | |");
		System.out.println("	| |    \\-||-\\    | |								| |    \\-||-\\    | |");
		System.out.println("	| |      ||  |   | |		       /\\     _  _    /\\     __			| |      ||  |   | |");
		System.out.println("	 \\ \\__ --||-/ __/ /		      /  \\   ( \\/ )  /  \\   (__)		 \\ \\__ --||-/ __/ /");
		System.out.println("	  \\__ ---__--- __/		     (_  _)   \\  /   \\  /  (_)(_)		  \\__ ---__--- __/");
		System.out.println("	     ---____---			       ][      \\/     \\/     ][			     ---____---");
		start();

	}

}