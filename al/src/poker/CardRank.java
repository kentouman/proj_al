package poker;


public class CardRank {
	private TCardRank rank;
	
	public CardRank (TCardRank rank)
	{
		this.setRank(rank);
	}

	public TCardRank getRank() {
		return rank;
	}

	private void setRank(TCardRank rank) {
		this.rank = rank;
	}
	
	public int compareRank(CardRank anotherRank)
	{
		if(rank.ordinal() > anotherRank.getRank().ordinal())
		{
			return 1;
		}
		else if(rank.ordinal() < anotherRank.getRank().ordinal())
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
		switch(rank)
		{
			case Two: return "2";
			case Three: return "3";
			case Four: return "4";
			case Five: return "5";
			case Six: return "6";
			case Seven: return "7";
			case Eight: return "8";
			case Nine: return "9";
			case Ten: return "10";
			case Jack: return "J";
			case Queen: return "Q";
			case King: return "K";
			case Ace: return "A";
			default: return "Error";
		}
	}
}
