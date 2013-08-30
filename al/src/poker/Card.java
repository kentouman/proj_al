package poker;

public class Card {
	private CardSuit suit;
	private CardRank rank;
	
	public Card(TCardSuit suit, TCardRank rank)
	{
		this.setRank(rank);
		this.setSuit(suit);
	}
	  
	public CardSuit getSuit() {
		return suit;
	}
	private void setSuit(TCardSuit suit) {
		this.suit = new CardSuit(suit);
	} 
	public CardRank getRank() {
		return rank;
	}
	private void setRank(TCardRank rank) {
		this.rank = new CardRank(rank);
	}
	
	public int compareCard(Card anotherCard)
	{
		if(rank.compareRank(anotherCard.getRank()) > 0)
		{
			return 1;
		}
		else if(rank.compareRank(anotherCard.getRank()) < 0)
		{
			return -1;
		}
		else
		{
			if(suit.compareSuit(anotherCard.getSuit()) > 0)
			{
				return 1;
			}
			else if(suit.compareSuit(anotherCard.getSuit()) < 0)
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}
	}
	
	public String toString()
	{
		return suit.toString() + " " + rank.toString();
	}
}
