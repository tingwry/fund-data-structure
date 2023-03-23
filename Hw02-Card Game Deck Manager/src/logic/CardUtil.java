package logic;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class CardUtil {
	
	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		for (UnitCard c : list) {
			if(c.equals(card)) {
				return true;
			}
		}
		return false;

	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		for (UnitDeck d : list) {
			if(d.equals(deck)) {
				return true;
			}
		}
		return false;

	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		for (UnitDeck d : deckList) {
			if (d.existsInDeck(cardToTest)) {
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<UnitCard> getCardsFromFile(String filename){
		
		File fileToRead = new File(filename);
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();

		try {
			Scanner scnr = new Scanner(fileToRead);
			while (scnr.hasNextLine()) {
				String line = scnr.nextLine();
				String[] i = line.split(",");
				
				UnitCard newCard = new UnitCard(i[0], Integer.parseInt(i[1]), Integer.parseInt(i[2]), Integer.parseInt(i[3]), i[4]);
				cardsFromFile.add(newCard);
			}
			scnr.close();
			return cardsFromFile;
		} catch (FileNotFoundException fileEx) {
			System.out.println("Cannot find file!");
			return null;
		} catch (Exception e) {
			System.out.println("File contains string with incorrect format!");
			return null;
		}
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}
}
