package poker;

public class CardSuit {

	private TCardSuit suit;
	
	public CardSuit(TCardSuit suit)
	{
		this.setSuit(suit);
	}

	public TCardSuit getSuit() {
		return suit;
	}

	private void setSuit(TCardSuit suit) {
		this.suit = suit;
	}
	
	public int compareSuit(CardSuit anotherSuit)
	{
		if(suit.ordinal() > anotherSuit.getSuit().ordinal())
		{
			return 1;
		}
		else if(suit.ordinal() < anotherSuit.getSuit().ordinal())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	public String toString()
	{
		switch(suit)
		{
			case Spade: return "����";
			case Heart: return "����";
			case Diamond: return "����";
			case Club: return "÷��";
			default: return "ERROR";
		}
	}
}
