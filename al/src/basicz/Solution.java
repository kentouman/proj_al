package basicz;

public class Solution {
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

    }
}
