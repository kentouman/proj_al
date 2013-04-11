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
}
