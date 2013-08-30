package poker;

public class Deck {
	final private int numberOfCards = 52; 
	private Card[] cards = new Card[numberOfCards];
	
	public Deck()
	{
		int i = 0;
		
		for(TCardSuit suit : TCardSuit.values())
		{
			for(TCardRank rank: TCardRank.values())
			{
				cards[i] = new Card(suit, rank);
				i++;
			}
		}
	}
	
	public Card[] getCards() {
		return cards;
	}
	
	public Card getCard(int i) {
		return cards[i];
	}
	
	public void setCards(Card[] cards) {
		//this.cards = cards;
	}
	
	public void displayAllCards()
	{
		for(int i = 0; i < numberOfCards; i++)
		{
			System.out.println(i + ") " +  cards[i].toString());
		}
	}
}
