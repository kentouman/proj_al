package restaurant;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class Restaurant {
	public BusinessHours businessHours; 
	private ArrayList<Table> tables;
	
	public Restaurant()
	{
		businessHours = new BusinessHours();
		tables = new ArrayList<Table>();
	}
	
	public void addTable(int capacity, int minimum)
	{
		tables.add(new Table(capacity, minimum));
	}
	
	public boolean checkAvailability(int year, int month, int date, int hour, int diner)
	{
		// Filter if the date and hour is within normal business hours
		Calendar d = Calendar.getInstance();
		d.set(year, month, date);
		if(!businessHours.isOpen(d, hour))
		{
			return false;
		}
		
		Iterator<Table> iter = tables.iterator();
		
		while(iter.hasNext())
		{
			// Then filter the table with appropriate capacity
			Table t = iter.next();
			if(t.fit(diner))
			{
				if(t.check(d, hour))
				{
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	public boolean reserve(int year, int month, int date, int hour, int diner, String contactName, String contactPhone)
	{
		Calendar d = Calendar.getInstance();
		d.set(year, month, date);
		if(!businessHours.isOpen(d, hour))
		{
			return false;
		}
		
		Iterator<Table> iter = tables.iterator();
		
		while(iter.hasNext())
		{
			// Then filter the table with appropriate capacity
			Table t = iter.next();
			if(t.fit(diner))
			{
				if(t.check(d, hour))
				{
					return t.reserve(d, hour, diner, contactName, contactPhone);
				}
			}
		}
		
		return false;
	}
	
	public boolean cancelReservation(int year, int month, int date, int hour, int diner, String contactName, String contactPhone)
	{
		Calendar d = Calendar.getInstance();
		d.set(year, month, date);
		if(!businessHours.isOpen(d, hour))
		{
			return false;
		}
		
		Iterator<Table> iter = tables.iterator();
		
		while(iter.hasNext())
		{
			// Then filter the table with appropriate capacity
			Table t = iter.next();
			if(t.fit(diner))
			{
				if(t.cancel(d, hour, diner, contactName, contactPhone))
				{
					return true;
				}
			}
		}
		
		return false;
	}
}
