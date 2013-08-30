package restaurant;

import java.util.Calendar;

public class DateAndHour {
	Calendar date;
	int hour;
	
	public DateAndHour(Calendar date, int hour)
	{
		this.date = date;
		//this.hour = (hour % 24 - 1) / 2 * 2 + 1;
		this.hour = hour % 24;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.get(Calendar.YEAR));
		result = prime * result + ((date == null) ? 0 : date.get(Calendar.MONTH));
		result = prime * result + ((date == null) ? 0 : date.get(Calendar.DATE));
		result = prime * result + hour;
		return result;
	}
	
	public Calendar getDate()
	{
		return date;
	}
	
	public int getHour()
	{
		return hour;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateAndHour other = (DateAndHour) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!(date.get(Calendar.YEAR) == other.date.get(Calendar.YEAR)))
		{
			return false;
		} else if (!(date.get(Calendar.MONTH) == other.date.get(Calendar.MONTH)))
		{
			return false;
		} else if (!(date.get(Calendar.DATE) == other.date.get(Calendar.DATE)))
		{
			return false;
		}
		if (hour != other.hour)
			return false;
		return true;
	}
}