package restaurant;

public class TestRestaurant {
	
	public static void main(String[] args)
	{
		Restaurant r = new Restaurant();
		
		final int TABLE_4 = 1;
		final int TABLE_8 = 1;
		final int TABLE_2 = 1;
		final int TESTROUND = 50;
		final int YEAR = 2013;
		final int MONTH = 8;
		final int DAY = 10;
	
		
		for(int i = 0; i < TABLE_4; i++)
		{
			r.addTable(4, 2);
		}
		
		for(int i = 0; i < TABLE_8; i++)
		{
			r.addTable(8, 5);
		}
		
		for(int i = 0; i < TABLE_2; i++)
		{
			r.addTable(2, 2);
		}
		
		
		for(int i = 0; i < TESTROUND; i++)
		{
			int hour = (int)(Math.random() * 8 + 16);
			if((hour < 16) || (hour > 23))
			{
				continue;
			}
			int diner = (int)(Math.random() * 10);
			//diner = 7;
			boolean success;

			success = r.reserve(YEAR, MONTH, DAY, hour, diner, "lalala", "999-999-9999");
			
			if(success)
			{
				System.out.printf("Reservation for %d at %2d:00\n", diner, hour);
			}
			else
			{
				//System.out.printf("----Reservation for %d at %2d:00 unavailable\n", diner, hour);
			}
			
		}
		
		System.out.printf("\n\n =========Now cancelling===========\n\n\n");

		for(int i = 0; i < 10 * TESTROUND; i++)
		{
			int hour = (int)(Math.random() * 8 + 16);
			if((hour < 16) || (hour > 23))
			{
				continue;
			}
			int diner = (int)(Math.random() * 10);
			//diner = 7;
			boolean success;

			success = r.cancelReservation(YEAR, MONTH, DAY, hour, diner, "lalala", "999-999-9999");

			if(success)
			{
				System.out.printf("Reservation cancelled for %d at %2d:00\n", diner, hour);
			}
			else
			{
				//System.out.printf("----Reservation could not be found for %d at %2d:00 unavailable\n", diner, hour);
			}
			
		}
		
	}
}
