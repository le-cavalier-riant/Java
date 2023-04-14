// =============================================================================================================== //
//                                                                                                                 //
//                                       Program coded by Artus de Chavagnac                                       //
//                                                                                                                 //
//                                                  December 2022                                                  //
//                                                                                                                 //
//                                        ČVUT - AE 2B 32 PRI - Programming                                        //
//                                                                                                                 //
// =============================================================================================================== //

import java.util.ArrayList;
import java.util.Random;

class DeckOfCards {

	// ==== variables ====

	private ArrayList <Card> deck = new ArrayList <> ();
	private String state = "visible"; // by default, the deck is hidden

	// ==== constructors ====

	DeckOfCards() { // 52 cards

		for (int i = 0; i < 4; i++) {

			for (int j = 1; j < 14 ; j++) {

				Card card = new Card(j, Card.suits[i]); // Card.suits is the array storing the suits
				this.addCard(card);

			}

		}

	}

	DeckOfCards(DeckOfCards oldDeck) { // create a deck from an existing deck

		if (oldDeck != null) {

			this.state = oldDeck.state;
			this.deck = oldDeck.deck;

		}

	}

	DeckOfCards(Card card) { // create a deck from a single card (Card object)

		this.addCard(card);

	}

	DeckOfCards(String card) { // create a deck from a single card (String)

		int rank;
		String level = card.split(" ")[0]; // level is like rank but with "Ace", "King", "Queen" and "Jack"
		// if: card = "Jack of Diamonds"
		// then: card.split(" ")[0] --> "Jack"

		rank = switch (level) {

			case "Ace" -> 1;
			case "Jack" -> 11;
			case "Queen" -> 12;
			case "King" -> 13;
			default -> Integer.parseInt(level);
			// we have to put all the stuff before "level" to convert from String to in

		};

		String suit = card.split(" ")[2];
		// if: card = "Jack of Diamonds"
		// then: card.split(" ")[2] --> "Diamonds"

		this.addCard(new Card(rank, suit));

	}

	void addCard(Card card) { // add a card to the deck

		this.deck.add(card);

	}

	public String toString() { // returns the deck as a String

		String description = "";

		switch (state) {

			case "firstVisible":

				description += "[#1: " + this.deck.get(0).toString() + "]";

				for (int i = 1; i < this.getSize(); i++) {

					description += ", [#" + (i + 1) + ": hidden]";

				}

				break;

			case "visible":

				description += "[#1: " + this.deck.get(0).toString() + "]";

				for (int i = 1; i < this.getSize(); i++) {

					description += ", [#" + (i + 1) + ": " + this.deck.get(i).toString() + "]";

				}

				break;

			default:

				description += "[#1: hidden]";

				for (int i = 1; i < this.getSize(); i++) {

					description += ", [#" + (i + 1) + ": hidden]";

				}

		}

		return description;

	}

	Card pickRandom() { // picks a random card from the deck

		Random random = new Random();

		int randomInt = random.nextInt(0, this.getSize());

		Card pickedCard = this.deck.get(randomInt);

		this.deck.remove(randomInt);

		return pickedCard;

	}

	int countBlack() { // counts the value of the deck using Blackjack rules

		int value = 0;

		for (Card card: this.deck) { // for each card of the deck

			switch (card.getRank()) {

				case 11, 12, 13 -> // Jack, Queen and King

					value += 10;

				case 1 -> // Ace

					value += 11;

				default -> // every other card

					value += card.getRank();
			}

		}

		return value;

	}

	void setState(String newState) { // redefines the set of the deck

		this.state = newState;

	}

	void shuffle() { // shuffle the deck by picking random cards inside

		for (int i = 0; i < this.getSize() * 3; i++) {

			this.addCard(this.pickRandom());

		}

	}

	ArrayList <Card> getDeck() { // get the deck as an ArrayList

		return this.deck;

	}

	void addDeck(DeckOfCards newDeck) {

		this.deck.addAll(newDeck.getDeck());

	}

	void removeAndAdd(int index, DeckOfCards deck) {
	// remove a card from the first deck and add it to se second

		Card card = this.deck.get(index); // get the selected card

		this.deck.remove(index); // remove the card from the first deck

		deck.addCard(card); // add the card to the second deck

	}

	Card getCard(int index) {

		return this.deck.get(index);

	}

	int getRank(int index) {

		return this.deck.get(index).getRank();

	}

	int getSize() {

		return this.deck.size();

	}

}
