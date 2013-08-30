package poker;

public class Play {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Deck deck = new Deck();
		
		deck.displayAllCards();

		
		int card1 = 5;
		int card2 = 18;
		
		
		System.out.println(deck.getCard(card1) + " vs " + deck.getCard(card2));
		
		System.out.println(deck.getCard(card1).compareCard(deck.getCard(card2)));
		
	}

}
