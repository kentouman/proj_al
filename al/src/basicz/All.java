package basicz;

import java.util.ArrayList;
import java.util.Arrays;

public class All {
	public static void main(String[] args)
	{
		All all = new All();
		all.printPrime(100);
	}
	
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

	
	public int sqrt(int n)
	{
		int x = (int) (Math.pow(2, Math.ceil(numbits(n) / 2)));
		while(true)
		{
			int y = (int) (Math.floor((x + Math.floor(n / x)) / 2));
			if(y >= x)
			{
				return x;
			}
			x = y;
		}
	}
	
	public int numbits(int n)
	{
		int i = 0;
		while(n != 0)
		{
			i++;
			n = n/2;
		}
		return i;
	}
	
	public long fib(int n)
	{
		long now = 1;
		long prev = 0;
		
		for(int i = 0; i < n; i++)
		{
			now = now + prev;
			prev = now - prev;
		}
		
		return now;
	}
	// Leetcode: Sort Color
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int len = A.length;
        int i = 0;
        int m = 0;
        int n = len - 1; 
        int temp;
        
        while(i<=n)
        {
            int e = A[i];
            
            if ( e == 0 )
            {
                if ( i > m)
                {
                    temp = A[i];
                    A[i] = A[m];
                    A[m] = temp;
                }
                                    
                i++;
                m++;
            }
            else if ( e == 1)
            {
                i++;
            }
            else if (e == 2)
            {
                temp = A[i];
                A[i] = A[n];
                A[n] = temp;
                
                n--;
            }
        }
    }
    
    // Leetcode: 
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i,j,k;
        int rowLen = matrix.length - 1;
        int colLen = matrix[0].length - 1;
        
        k = 1;
        
        for (i = 0; i <= rowLen; i++)
        {
        	for(j = 0; j<= colLen; j++)
        	{
        		if(0 == matrix[i][j])
        		{

    				matrix[0][j] = 0;
    				if(i == 0)
    				{
    					k = 0;
    				}
    				else
    				{
    					matrix[i][0] = 0;
    				}
        		}
        	}
        }
        
        for (j = 1; j <= colLen; j++)
        {
        	if(matrix[0][j] == 0 )
        	{
        		for(i = 1; i<=rowLen; i++)
        		{
        			matrix[i][j] = 0;
        		}
        	}
        }
        
        for (i = 1; i <= rowLen; i++)
        {
        	if(matrix[i][0] == 0 )
        	{
        		for(j = 1; j<=colLen; j++)
        		{
        			matrix[i][j] = 0;
        		}
        	}
        }
        
        if (matrix[0][0]==0)
        {
    		for(i = 0; i<=rowLen; i++)
    		{
    			matrix[i][0] = 0;
    		}
        }       
        if (k==0)
        {
    		for(j = 0; j<=colLen; j++)
    		{
    			matrix[0][j] = 0;
    		}
        }
    }
    
	public void reverseWord(char[] input)
	{
		boolean fhead, ftail;
		fhead=false;
		ftail=false;
		
		int head, tail;
		head = 0;
		tail = 0;
		
		for(int i = 0; i < input.length; i++)
		{
			if(!fhead)
			{
				if(input[i] == ' ')
				{
					continue;
				}
				else
				{
					fhead = true;
					head = i;
				}
			}
			
			else if(!ftail)
			{
				if(input[i] == ' ')
				{
					ftail = true;
					tail = i - 1;
				}
				else
				{
					continue;
				}
			}
			
			if(ftail)
			{
				int len = (tail - head) / 2;
				for(int j = 0; j < len; j++)
				{
					char temp = input[head + j];
					input[head + j] = input[tail - j];
					input[tail - j] = temp;
				}
				fhead = false;
				ftail= false;
			}
			
		}
		
		if(fhead)
		{
			tail = input.length - 1;
			int len = (tail - head) / 2;
			for(int j = 0; j < len; j++)
			{
				char temp = input[head + j];
				input[head + j] = input[tail - j];
				input[tail - j] = temp;
			}
		}
		
	}
	
	public void permute(String s)
	{
		int len = s.length();
		char[] buffer = new char[len];
		boolean[] used = new boolean[len];
		int bufferLen = 0;
		
		doPermuteRecursively(s.toCharArray(), used, buffer, bufferLen);
	}
	
	public void doPermuteRecursively(char[] c, boolean[] used, char[] buffer, int bufferLen)
	{
		if(bufferLen == buffer.length)
		{
			// do print
			System.out.println(Arrays.toString(buffer));
			return;
		}
		
		int len = c.length;
		
		for(int i = 0; i < len; i++)
		{
			if(used[i])
			{
				continue;
			}
			else
			{
				buffer[bufferLen] = c[i];
				used[i] = true;
				doPermuteRecursively(c, used, buffer, bufferLen+1);
				used[i] = false;
			}
		}
	}

}
