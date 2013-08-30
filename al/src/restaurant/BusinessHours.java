package restaurant;

import java.util.Calendar;

public class BusinessHours {
	private int[][] opening;
	private final static int WEEKDAYOPENING = 17;
	private final static int WEEKDAYCLOSING = 21;
	private final static int WEEKENDOPENING = 17;
	private final static int WEEKENDCLOSING = 23;
	
	public BusinessHours()
	{
		opening = new int[7][2];
		for(int i = 1; i < 5; i++)
		{
			opening[i][0] = WEEKDAYOPENING;
			opening[i][1] = WEEKDAYCLOSING;
		}
		
		for(int i = 5; i < 7; i++)
		{
			opening[i][0] = WEEKENDOPENING;
			opening[i][1] = WEEKENDCLOSING;
		}
		
		opening[0][0] = WEEKDAYOPENING;
		opening[0][1] = WEEKDAYCLOSING;
		
	}
	
	public int getOpeningHour(int day)
	{
		return opening[day][0];
	}
	
	public int getClosingHour(int day)
	{
		return opening[day][1];
	}
	
	public boolean isOpen(Calendar d, int hour)
	{
		if((hour >= getOpeningHour(d.get(Calendar.DAY_OF_WEEK))) && (hour < getClosingHour(d.get(Calendar.DAY_OF_WEEK))))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
