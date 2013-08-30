package restaurant;

import java.util.Calendar;
import java.util.HashMap;

public class Table {
	private static int count;
	private int id;
	private int capacity;
	private int minimum;
	HashMap<DateAndHour, Reservation> reservationMap;

	public Table()
	{
		this(0,0);
	}
	
	public Table(int capacity, int minimum)
	{
		count++;
		setId(count);
		setCapacity(capacity);
		setMinimum(minimum);
		reservationMap = new HashMap<DateAndHour, Reservation>();
	}
	
	public boolean fit(int diner)
	{
		if((diner <= capacity) && (diner >= minimum))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean check(Calendar date, int hour)
	{
		DateAndHour dateHour = new DateAndHour(date, hour);
		if (reservationMap.containsKey(dateHour))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean reserve(Calendar date, int hour, int diner, String contactName, String contactPhone)
	{
		if(!check(date, hour))
		{
			return false;
		}
		else
		{
			DateAndHour dateHour = new DateAndHour(date, hour);
			Reservation reservation = new Reservation(diner, contactName, contactPhone);
			reservationMap.put(dateHour, reservation);
			return true;
		}		
	}
	
	public boolean cancel(Calendar date, int hour, int diner, String contactName, String contactPhone)
	{

		DateAndHour dateHour = new DateAndHour(date, hour);
		if((reservationMap.containsKey(dateHour)) && (reservationMap.get(dateHour).checkReservation(diner, contactName, contactPhone)))
		{
			reservationMap.remove(dateHour);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
