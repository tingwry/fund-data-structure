package logic;

import java.util.ArrayList;

public class UnitDeck {
	private ArrayList<CardCounter> cardsInDeck;
	private String deckName;
	
	public UnitDeck(String deckName) {
		// Constructor
		this.setDeckName(deckName);
		this.cardsInDeck = new ArrayList<CardCounter>();
	}

	public void setDeckName(String deckName) {
		if (deckName.isBlank()) {
			this.deckName = "Untitled Deck";
		} else {
			this.deckName = deckName;
		}
	}
	
	public String getDeckName() {
		return this.deckName;
	}
	
	public ArrayList<CardCounter> getCardsInDeck() {
		return cardsInDeck;
	}
	
	public boolean existsInDeck(UnitCard card) {
		for (CardCounter cardInDeck : cardsInDeck) {
			if (cardInDeck.getCard().equals(card) && cardInDeck.getCount() >= 1) {
				return true;
			} 
		}
		return false;
	}
	
	public boolean equals(UnitDeck other) {
		return this.deckName.equals(other.deckName);
	}
	
	public void addCard(UnitCard newCard, int count) {
		if (count < 1) {
			return;
		}
		for (CardCounter cardInDeck : cardsInDeck) {
			if (cardInDeck.getCard().equals(newCard)) {
				cardInDeck.setCount(cardInDeck.getCount() + count);
				return;
			}
		}
		
		CardCounter u = new CardCounter(newCard, count); 
		cardsInDeck.add(u);
	}
	
	public void removeCard(UnitCard toRemove, int count) {
		if (count < 1 || !this.existsInDeck(toRemove)) {
			return;
		}
		for (CardCounter cardInDeck : cardsInDeck) {
			if (cardInDeck.getCard().equals(toRemove)) {
				cardInDeck.setCount(cardInDeck.getCount() - count);
				if (cardInDeck.getCount() == 0) {
					cardsInDeck.remove(cardInDeck);
				}
				return;
			}
		}
	}
	
	public int cardCount() {
		int sum = 0;
		for (CardCounter cardInDeck : cardsInDeck) {
			sum = sum + cardInDeck.getCount();
		}
		return sum;
	}
}
