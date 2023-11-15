// ================================================================================================================== //
//                                                                                                                    //
//                                                       Poker                                                        //
//                                                                                                                    //
// ================================================================================================================== //

import java.util.ArrayList;
import java.util.Random;

class DeckOfCards {

	private ArrayList <Card> deck = new ArrayList <> ();

	DeckOfCards() {

		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14 ; j++) {
				Card card = new Card(j, Card.suits[i]);
				this.deck.add(card);
			}
		}

	}

	DeckOfCards(DeckOfCards oldDeck) {if (oldDeck != null) {this.deck = oldDeck.deck;}}

	DeckOfCards(Card card) {this.deck.add(card);}

	DeckOfCards(String card) {

		int rank;
		String level = card.split(" ")[0]; // level is like rank but with "Ace", "King", "Queen" and "Jack"
		rank = switch (level) {
			case "Ace" -> 1;
			case "Jack" -> 11;
			case "Queen" -> 12;
			case "King" -> 13;
			default -> Integer.parseInt(level);
		};
		String suit = card.split(" ")[2];
		// if: card = "Jack of Diamonds"
		// then: card.split(" ")[2] --> "Diamonds"
		this.deck.add(new Card(rank, suit));

	}

	void addCard(Card card) {this.deck.add(card);}

	Card pickRandom() {

		Random random = new Random();
		int randomInt = random.nextInt(0, this.getSize());
		Card pickedCard = this.deck.get(randomInt);
		this.deck.remove(randomInt);
		return pickedCard;

	}

	void shuffle() {for (int i = 0; i < this.getSize() * 3; i++) {this.deck.add(this.pickRandom());}}

	ArrayList <Card> getDeck() {return this.deck;}

	void addDeck(DeckOfCards deck) {this.deck.addAll(deck.getDeck());}

	void removeAndAdd(int cardIndex, DeckOfCards deck) {

		Card card = this.deck.get(cardIndex);
		this.deck.remove(cardIndex);
		deck.addCard(card);

	}

	Card getCard(int cardIndex) {return this.deck.get(cardIndex);}

	int getRankCard(int cardIndex) {return this.deck.get(cardIndex).getRank();}

	String getSuitCard(int cardIndex) {return this.deck.get(cardIndex).getSuit();}

	int getSize() {return this.deck.size();}

	void draw(int visibleCards) {

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

	public String toString() {

		String description = "";
		description += "[#1: " + this.deck.get(0).toString() + "]";
		for (int i = 1; i < this.deck.size(); i++) {
			description += ", [#" + (i + 1) + ": " + this.deck.get(i).toString() + "]";
		}
		return description;

	}

	String toStringCard(int cardIndex) {return this.deck.get(cardIndex).toString();}

	void removeCard(int cardIndex) {this.deck.remove(cardIndex);}

}

// ================================================================================================================== //
//                                                                                                                    //
//                                                       Poker                                                        //
//                                                                                                                    //
// ================================================================================================================== //