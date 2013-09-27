package basicz;

public class Solution {
	
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
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	for(int i = 1 ; i < 100; i++)
    	{
    		System.out.println(i + " : " + s.sqrt(i));
    	}
    }
}
