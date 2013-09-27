package basicz;

import java.util.ArrayList;

public class All {
	
	// print all prime numbers not greater than input n
	public void printPrime(int max)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if(max < 2)
		{
			return;
		}
		
		result.add(2);
		int n = 3;
		
		while(n <= max)
		{
			boolean isPrime = true;
			int sqroot = (int)(Math.sqrt(n));
			for (int i : result)
			{
				if(i > sqroot)
				{
					break;
				}
				else if(n % i ==0)
				{
					isPrime = false;
					break;
				}
			}
			
			if(isPrime)
			{
				result.add(n);
			}
			n++;
		}
		
		for(int i : result)
		{
			System.out.println(i);
		}
	}

		public static void main(String[] args)
		{
			All all = new All();
			all.printPrime(100);
		}
}
