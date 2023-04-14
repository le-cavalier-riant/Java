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

	private ArrayList <Card> deck = new ArrayList <> ();

	DeckOfCards() { // 52 cards

		for (int i = 0; i < 4; i++) {

			for (int j = 1; j < 14 ; j++) {

				Card card = new Card(j, Card.suits[i]); // Card.suits is the array storing the suits
				this.deck.add(card);

			}

		}

	}

	DeckOfCards(DeckOfCards oldDeck) { // create a deck from an existing deck

		if (oldDeck != null) {

			this.deck = oldDeck.deck;

		}

	}

	DeckOfCards(Card card) { // create a deck from a single card (Card object)

		this.deck.add(card);

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

		this.deck.add(new Card(rank, suit));

	}

	void addCard(Card card) { // add a card to the deck

		this.deck.add(card);

	}

	Card pickRandom() { // picks a random card from the deck

		Random random = new Random();
		int randomInt = random.nextInt(0, this.getSize());
		Card pickedCard = this.deck.get(randomInt);
		this.deck.remove(randomInt);
		return pickedCard;

	}

	void shuffle() { // shuffle the deck by picking random cards inside

		for (int i = 0; i < this.getSize() * 3; i++) {

			this.deck.add(this.pickRandom());

		}

	}

	ArrayList <Card> getDeck() { // get the deck as an ArrayList

		return this.deck;

	}

	void addDeck(DeckOfCards deck) { // add a whole deck to this one

		this.deck.addAll(deck.getDeck());

	}

	void removeAndAdd(int cardIndex, DeckOfCards deck) {
	// remove a card from the deck and add it to another one

		Card card = this.deck.get(cardIndex); // get the selected card
		this.deck.remove(cardIndex); // remove the card from the first deck
		deck.addCard(card); // add the card to the second deck

	}

	Card getCard(int cardIndex) { // returns one card of the deck

		return this.deck.get(cardIndex);

	}

	int getRankCard(int cardIndex) { // get the rank of a selected card of the deck

		return this.deck.get(cardIndex).getRank();

	}

	String getSuitCard(int cardIndex) {

		return this.deck.get(cardIndex).getSuit();		

	}

	int getSize() { // simply returns the size of the deck

		return this.deck.size();

	}

	void draw(int visibleCards) {
	// draws every card of the deck, but only a certain amount of card on the front

		for (int j = 0; j < 7; j++) {

			for (int i = 0; i < visibleCards; i++) {

				System.out.print("		" + this.deck.get(i).draw(true)[j]);

			}

			for (int i = visibleCards; i < this.deck.size(); i++) {

				System.out.print("		" + this.deck.get(i).draw(false)[j]);

			}

			System.out.println();

		}

		System.out.println();

	}

	public String toString() { // returns the deck as a String

		String description = "";

		description += "[#1: " + this.deck.get(0).toString() + "]";

		for (int i = 1; i < this.deck.size(); i++) {

			description += ", [#" + (i + 1) + ": " + this.deck.get(i).toString() + "]";

		}

		return description;

	}

	String toStringCard(int cardIndex) {

		return this.deck.get(cardIndex).toString();

	}

	void removeCard(int cardIndex) {

		this.deck.remove(cardIndex);
	}

}