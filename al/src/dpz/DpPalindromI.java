package dpz;

public class DpPalindromI {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int len = s.length();
        int i,j,step;
        int[][] result = new int[len][len];
        
        for (i = 0; i < len; i++)
        {
            result[i][i] = 1;
        }
        
        for (step = 1; step < len; step++)
        {
            int max = len - step - 1;
            for (i=0; i <= max; i++)
            {
                int indexmin = i;
                int indexmax = i + step;
                int tempmin = len;
                                
                if(true == testPalindrom(s.substring(indexmin, indexmax+1)))
                {
                    tempmin = 1;
                }
                else
                {
                    for(j = indexmin; j < indexmax; j++)
                    {
                        if (tempmin > result[indexmin][j] + result[j+1][indexmax])
                        {
                           tempmin = result[indexmin][j] + result[j+1][indexmax];
                        }
                    }                    
                }
                
                result[indexmin][indexmax] = tempmin;                
            }
        }
        
        for (i = 0; i < len; i++)
        {
        	for(j = 0; j< len; j++)
        	{
        		System.out.print(result[i][j]);
        	}
        	System.out.println();
        }
        return(result[0][len-1] - 1);
        
    }
    
    public boolean testPalindrom(String s)
    {
        int lenmid, i, indexmax;
        int len = s.length();
        
        lenmid = len/2;
        
        for(i=0; i<lenmid; i++)
        {
            indexmax = len - i -1;
            if(s.charAt(i) != s.charAt(indexmax))
            {
                return false;
            }
        }
        
        return true;
    }
}

