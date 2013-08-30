package basicz;

import java.util.ArrayList;
import java.util.Arrays;

public class basictry {

	
    public int firstMissingPositive(int[] A)
    {
       
        if(A.length == 0)
        {
            return 1;
        }
        if((A.length == 1) && (A[0] <= 0))
        {
            return 1;           
        }
       
          int i = 0;
          int j = A.length - 1;
          while(i < j)
          {
               while((i < A.length) && (A[i] > 0)) i++;
               while((j >= 0) && (A[j] <= 0)) j--;
               if(i < j) swap(A, i, j);
          }
       
          i = 0;
          while(i < j + 1)
          {
               if(A[i] < 0)
               {
                    i++;
               }
               else if(A[i] > j + 1)
               {
                    A[i] = -A[i];
                    i++;
               }
               else if(A[i] != i + 1)
               {
                   
                    if(A[A[i] - 1] == A[i])
                    {
                        A[i] = -A[i];
                        i++;
                    }
                    else
                    {
                        swap(A, i, A[i] - 1);
                    }
               }
               else
               {
                    i++;
               }
          }
         
          for(i = 0; i < j + 1; i++)
          {
               if(A[i] < 0)
               {
                    return i+1;
               }
          }
         
          return j+2;
         
     }
    
     void swap(int[] A, int i, int j)
     {
          int temp = A[i];
          A[i] = A[j];
          A[j] = temp;
     }

	
	
	public static void main(String[] args)
	{
		basictry a = new basictry();
		char[][] input = new char[9][9];
		input[0] = "..9748...".toCharArray();
		input[1] = "7........".toCharArray();
		input[2] = ".2.1.9...".toCharArray();
		input[3] = "..7...24.".toCharArray();
		input[4] = ".64.1.59.".toCharArray();
		input[5] = ".98...3..".toCharArray();
		input[6] = "...8.3.2.".toCharArray();
		input[7] = "........6".toCharArray();
		input[8] = "...2759..".toCharArray();

		
		//a.solveSudoku(input);
		int[] aa = {1,1};
		a.firstMissingPositive(aa);
	}
}

