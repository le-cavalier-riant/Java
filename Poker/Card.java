// ================================================================================================================== //
//                                                                                                                    //
//                                                       Poker                                                        //
//                                                                                                                    //
// ================================================================================================================== //

class Card {

	static boolean unicode = false; // turn this one "true" in order to print the unicode symbols
	private int rank;
	private String suit;
	private char icon;
	private String[] front = new String[7];
	private String[] back = {
		" -------",
		"|\\-----/|",
		"| |   | |",
		"| | ~ | |",
		"| |   | |",
		"|/-----\\|",
		" -------"
	};
	static String[] suits = {
		"Spades",
		"Hearts",
		"Diamonds",
		"Clubs"
	};
	// this array store the suits values, we will use it later, in other classes

	Card(int rank, String suit) {

		this.rank = rank;
		this.suit = suit;
		if (unicode) {
			this.icon = switch (this.suit) {
				case "Spades" -> '\u2660'; // ♠
				case "Hearts" -> '\u2665'; // ♥
				case "Diamonds" -> '\u2666'; // ♦
				default -> '\u2663'; // ♣
			};
		} else {
			this.icon = switch (this.suit) {
				case "Spades" -> '^'; // looks like the top of spade
				case "Hearts" -> 'v'; // looks like the bottom of a heart
				case "Diamonds" -> 'x'; // looks like a diamond
				default -> '&'; // looks like a club
			};
		}

	}

	Card(String card) { // "Ace of Diamonds"

		this.rank = switch (card.split("")[0]) {
			case "Ace" -> 1;
			case "King" -> 13;
			case "Queen" -> 12;
			case "Jack" -> 11;
			default -> Integer.parseInt(card.split("")[0]);
		};
		this.suit = card.split(" ")[3];

	}

	public String toString() { // returns the card as a String

		String suitOrUnicode;
		if (unicode) {
			suitOrUnicode = switch (this.suit) {
				case "Spades" -> "\u2660";
				case "Hearts" -> "\u2665";
				case "Diamonds" -> "\u2666";
				default -> "\u2663";
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

	String[] draw(boolean visible) { // return an array of the drawing of the card

		front[0] = " -------";
		front[6] = " -------";
		if (visible) {
			// ========== line 1 ==========
			int line = 1;
			if (this.rank == 13) {
				front[line] = "|K   WW |";
			} else if (this.rank == 12) {
				front[line] = "|Q   ~~ |";
			} else if (this.rank == 11) {
				front[line] = "|J      |";
			} else if (this.rank == 10) {
				front[line] = "|" + this.rank + "" + this.icon + " " + this.icon + "  |";
			} else if (this.rank > 6) {
				front[line] = "|" + this.rank + " " + this.icon + " " + this.icon + "  |";
			} else {
				front[line] = "|" + this.rank + "      |";
			}
			// ========== line 2 ==========
			line = 2;
			if (this.rank == 1) {
				front[line] = "|       |";
			} else if (this.rank == 12) {
				front[line] = "| \\  {]\\|";
			} else if (this.rank == 11 || this.rank == 13) {
				front[line] = "| \\  {] |";
			} else if (this.rank < 4) {
				front[line] = "|   " + this.icon + "   |";
			} else {
				front[line] = "|  " + this.icon + " " + this.icon + "  |";
			}
			// ========== line 3 ==========
			line = 3;
			if (this.rank == 10 || this.rank == 6) {
				front[line] = "|  " + this.icon + " " + this.icon + "  |";
			} else if (this.rank == 7) {
				front[line] = "|       |";
			} else if (this.rank > 10) {
				front[line] = "|| |" + this.icon + "| ||";
			} else if ((this.rank % 2) == 1) {
				front[line] = "|   " + this.icon + "   |";
			} else {
				front[line] = "|       |";
			}
			// ========== line 4 ==========
			line = 4;
			if (this.rank == 1) {
				front[line] = "|       |";
			} else if (this.rank == 7) {
				front[line] = "|   " + this.icon + "   |";
			} else if (this.rank < 4) {
				front[line] = "|   " + this.icon + "   |";
			} else if (this.rank == 12) {
				front[line] = "|\\[}  \\ |";
			} else if (this.rank > 10) {
				front[line] = "| [}  \\ |";
			} else {
				front[line] = "|  " + this.icon + " " + this.icon + "  |";
			}
			// ========== line 5 ==========
			line = 5;
			if (this.rank == 13) {
				front[line] = "| MM   K|";
			} else if (this.rank == 12) {
				front[line] = "|\\~~   Q|";
			} else if (this.rank == 11) {
				front[line] = "|      J|";
			} else if (this.rank == 10) {
				front[line] = "|  " + this.icon + " " + this.icon + "" + this.rank + "|";
			} else if (this.rank > 6 && this.rank < 10) {
				front[line] = "|  " + this.icon + " " + this.icon + " " + this.rank + "|";
			} else {
				front[line] = "|      " + this.rank + "|";
			}
			return front;
		} else {
			return back;
		}

	}

	int getRank() {return this.rank;}

	String getSuit() {return this.suit;}

}

// ================================================================================================================== //
//                                                                                                                    //
//                                                       Poker                                                        //
//                                                                                                                    //
// ================================================================================================================== //