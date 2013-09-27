package basicz;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CC150 {
	
	public void paddingSpace(char[] A)
	{
	    // first scan how many space are in the array
	    int cnt = 0;
	    int len;
	    for(len = 0; len < A.length; len++)
	    {
	        if((A[len] == ' ')&&(A[len+1]==' '))
	        {
	            break;
	        }
	        if(A[len] == ' ')
	        {
	            cnt++;
	        }
	    }
	    
	    int destEnd = len + cnt * 2 - 1;
	    
	    for(int i = len - 1; i >= 0; i--)
	    {
	        if(A[i]==' ')
	        {
	            A[destEnd] = '0';
	            A[destEnd - 1] = '2';
	            A[destEnd - 2] = '%';
	            destEnd = destEnd - 3;
	        }
	        else
	        {
	            A[destEnd] = A[i];
	            destEnd--;
	        }
	    }
	}
	
	public boolean isNumber(String s)
	{
		/**first define the state diagram
		 * 
		 * 		        input_space    input_sign    input_num    input_dot    input_e     input_letter
		 * space 0           0              1           2             9           8            8
		 * sign  1           8              8           2             9           8            8
		 * num   2           7              8           2             3           4            8
		 * dot   3           7              8           5             8           4            8
		 * e     4           8              10          6             8           8            8
		 * numafterdot 5     7              8           5             8           4            8
		 * numaftere   6     7              8           6             8           8            8
		 * finalspace  7     7              8           8             8           8            8
		 * invalid     8
		 * just dot    9     8              8           5             8           8            8
    	 * signafter e 10    8              8           6             8           8            8
		 */
		
		int[][] stateDiagram = {
				{0,1,2,9,8,8},
				{8,8,2,9,8,8},
				{7,8,2,3,4,8},
				{7,8,5,8,4,8},
				{8,10,6,8,8,8},
				{7,8,5,8,4,8},
				{7,8,6,8,8,8},
				{7,8,8,8,8,8},
				{8,8,8,8,8,8},
				{8,8,5,8,8,8},
				{8,8,6,8,8,8}
		};
		
		int state = 0;
		int input;
		
		for(int i = 0; i < s.length(); i++)
		{
			if(state == 8)
			{
				return false;
			}
			
			char c = s.charAt(i);
			
			
			if      (c==' ') input = 0;
			else if (c=='+' ||  c=='-') input = 1;
			else if (c-'0' <= 9 && c-'0' >= 0) input = 2;
			else if (c=='.') input = 3;
			else if (c=='e') input = 4;
			else  input = 5;
			
			state = stateDiagram[state][input];
		}
	
		if(state == 2 || state == 3 ||   state == 5 ||   state == 6 ||   state == 7)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		CC150 a = new CC150();
		
		char[] A = {'a',' ','b','c',' ','d',' ',' ',' ',' ',' ',' ',' '};
		a.paddingSpace(A);
		
		System.out.println(Arrays.toString(A));
		
		ArrayStack aaa = new ArrayStack();
		aaa.s1.printme();
		aaa.s2.printme();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		
		System.out.println(a.isNumber("64..e"));
		
	}
}

class ArrayStack
{
	private static final int LENTGH_ARRAY = 128;
	private static final int NUM_STACK = 4;
	
	int[] array;
	
	class SingleStack
	{
		int id;
		public SingleStack(int id)
		{
			this.id = id;
		}
		
		public void printme()
		{
			printinner(id);
		}
	}
	
	SingleStack s1;
	SingleStack s2;
	
	public ArrayStack()
	{
		array = new int[LENTGH_ARRAY];
		s1 = new SingleStack(1);
		s2 = new SingleStack(2);
	}
	
	public void printinner(int id)
	{
		System.out.println("I am " + id);
	}
	
	
}
