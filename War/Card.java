// =============================================================================================================== //
//                                                                                                                 //
//                                       Program coded by Artus de Chavagnac                                       //
//                                                                                                                 //
//                                                  December 2022                                                  //
//                                                                                                                 //
//                                        ČVUT - AE 2B 32 PRI - Programming                                        //
//                                                                                                                 //
// =============================================================================================================== //

class Card {

	private final int rank;
	private final String suit;
	static boolean unicode = false; // turn this one "true" in order to print the unicodes symbols

	static String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	// this array store the suits values, we will use it later, in other classes

	Card (int rank, String suit) {

		this.rank = rank;
		this.suit = suit;

	}

	public String toString() { // returns the card as a String

		String suitOrUnicode;

		if (unicode) {

				suitOrUnicode = switch (this.suit) {

					case "Spades" -> "♠";
					case "Hearts" -> "♥";
					case "Diamonds" -> "♦";
					default -> "♣";

				};

			} else {

				suitOrUnicode = this.suit;

			}

		return switch (this.rank) {

			case 1 -> "Ace of " + suitOrUnicode;
			case 11 -> "Jack of " + suitOrUnicode;
			case 12 -> "Queen of " + suitOrUnicode;
			case 13 -> "King of " + suitOrUnicode;
			default -> this.rank + " of " + suitOrUnicode;
		};

	}

	int getRank() {

		return this.rank;

	}

}
