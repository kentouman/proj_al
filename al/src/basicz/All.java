package basicz;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class All {
	public static void main(String[] args)
	{
		All all = new All();
		//all.printPrime(100);
		
		int[] array = {7, 9, 10, -2, 2,3,5};
		//System.out.println(all.BinarySearchRotated(array, 5));
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		int[] a = {};
		int[] b = {};
		
		System.out.println(all.checkArray3(a, b));
		
		String[] x = all.testRegex("He2llo  Word", "\\s+|\\d");
		for(int i = 0; i < x.length; i++)
		{
			System.out.println(x[i]);
		}
		
		System.out.println("==============");
		
		all.testRegex2("Hel2lo  World", "[a-zA-Z]+");
		
		for(int i = 20; i < 40; i++)
		{
			System.out.println(i + " --> " + all.findCloset(i));
		}
		
		System.out.println(all.longestCommonSubsequence("1234567890", "33858779770"));
		
		
		for(int i = 1; i < 100; i++)
		{
			System.out.println("Sqrt(" + i + ") = " + all.sqrt2(i));
		}
	}
	
	
	
	public int longestCommonSubstring(String a, String b)
	{
		int lenA = a.length();
		int lenB = b.length();
		int[][] m = new int[lenA][lenB];
		
		m[0][0] = a.charAt(0) == b.charAt(0) ? 1 : 0;
		
		for(int i = 1; i < lenA; i++)
		{
			m[i][0] = a.charAt(i) == b.charAt(0) ? 1 : m[i-1][0];
		}
		for(int i = 1; i < lenB; i++)
		{
			m[0][i] = b.charAt(i) == a.charAt(0) ? 1 : m[0][i-1];
		}
		
		for(int i = 1; i < lenA; i++)
		{
			for(int j = 1; j < lenB; j++)
			{
				int temp = Math.max(m[i-1][j], m[i][j-1]);
				m[i][j] = a.charAt(i) == b.charAt(j) ? m[i-1][j-1] + 1 : temp;
 			}
		}
		
		
		
		return m[lenA-1][lenB-1];

	}
	
	public int longestCommonSubsequence(String a, String b)
	{
		int lenA = a.length();
		int lenB = b.length();
		int[][] m = new int[lenA][lenB];
		
		m[0][0] = a.charAt(0) == b.charAt(0) ? 1 : 0;
		
		for(int i = 1; i < lenA; i++)
		{
			m[i][0] = a.charAt(i) == b.charAt(0) ? 1 : m[i-1][0];
		}
		for(int i = 1; i < lenB; i++)
		{
			m[0][i] = b.charAt(i) == a.charAt(0) ? 1 : m[0][i-1];
		}
		
		for(int i = 1; i < lenA; i++)
		{
			for(int j = 1; j < lenB; j++)
			{
				int temp = Math.max(m[i-1][j], m[i][j-1]);
				m[i][j] = a.charAt(i) == b.charAt(j) ? m[i-1][j-1] + 1 : temp;
 			}
		}
		
		return m[lenA-1][lenB-1];
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
	
	public int sqrt2(int n)
	{
		double now = n / 2;
		double prev = 0;
		
		while((int) now != (int) prev)
		{
			prev = now;
			now = now - (now * now - n) / (2 * now);
		}
		
		int ceil = (int) Math.ceil(now);
		int floor = (int) Math.floor(now);
		return ceil * ceil - n <= n - floor * floor ? ceil : floor;
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

    
    boolean BinarySearchRotated(int[] array, int target)
    {
        int len = array.length;
        if(len == 0)
        {
            return false;
        }
        
        
        // find the start of rotated sorted array
        int pivot = 0;
        for(int i = 0; i < len - 1; i++)
        {
            if(array[i] > array[i+1])
            {
                pivot = i + 1;
            }
        }
        
        int start = 0;
        int end = len - 1;
        int mid = 0;
        
        while(start <= end)
        {
            mid = (start + end) / 2;
            if(target == array[(mid + pivot) % len])
            {
                return true;
            }
            else if(target > array[(mid + pivot) % len])
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        
        return false;
    }
    
    public boolean checkArray(int[] a, int[] b)
    {
    	return checkArrayImpl(a, 0, b, 0);
    }
    
    public boolean checkArrayImpl(int[] a, int indexA, int[]b, int indexB)
    {
    	/*====================Termination condition============================*/
    	if(indexB == b.length)
    	{
    		return true;
    	}
    	
    	if(indexA == a.length)
    	{
    		return false;
    	}
    	
    	/*======================Recursion path==========================*/    	
    	if(a[indexA] < b[indexB])     // move a[] forward if cannot find a match but we still have hope
    	{
    		return checkArrayImpl(a, indexA + 1, b, indexB);
    	}
    	else if(a[indexA] == b[indexB])
    	{
    		return checkArrayImpl(a, indexA + 1, b, indexB + 1);  // move both forward if found a match
    	}
    	else    // never gonna happen
    	{
    		return false;
    	}
    }
    
    public boolean checkArray2(int[] a, int[] b){
        int lena=a.length;
        int lenb=b.length;
        
        if (lena==0){
            return false;
        }
        if (lenb==0){
            return true;
        }
        if ((a[lena-1]<b[lenb-1]) || (a[0]>b[0])){
            return false;
        }
        
        int j=0;
        for (int i=0;i<lenb;i++){
            boolean flag=false;
            for (;j<lena;j++){
                if (b[i]==a[j]){
                    j=j+1;
                    flag=true;
                    break;
                }           
            }
            if (flag==false){
                return false;
            }   
        }
        
        return true; 
        
    }
    public boolean checkArray3(int[] a, int[] b){
        int lena=a.length;
        int lenb=b.length;
        
        if (lenb==0){
            return true;
        }
        if (lena < lenb){
            return false;
        }
        
        int indexA = 0;
        int indexB = 0;
        
        // core logic
        while(indexA < lena && indexB < lenb)
        {
            if(a[indexA] > b[indexB])
            {
                return false;
            }
            else if(a[indexA] == b[indexB])
            {
                indexA++;
                indexB++;
            }
            else
            {
                indexA++;
            }
        }
        
        // returning 
        if (indexB == lenb)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    public String[] testRegex(String s, String separater)
    {
    	return s.split(separater);
    }
    
    public void testRegex2(String s, String pattern)
    {
    	Pattern p = Pattern.compile(pattern);
    	
    	Matcher m = p.matcher(s);
    	
    	while(m.find())
    	{
    		System.out.println(m.group());
    	}
    }
    
    public int findCloset(int a)
    {
    	int one = a % 10;
    	int ten = a / 10;
    	
    	int temp1 = 11 - (one - ten);
    	int temp2 = Math.max(one - ten, ten - one);
    	int temp3 = 11 - (ten - one);
    	
    	
    	if(temp1 <= temp2)
    	{
    		if(temp1 <= temp3)
    		{
    			return (ten+1) * 10 + ten+1;
    		}
    		else
    		{
    			return (ten-1) * 10 + ten - 1;
    		}
    	}
    	else
    	{
    		if(temp2 <= temp3)
    		{
    			return ten* 10 + ten;
    		}
    		else
    		{
    			return (ten-1) * 10 + ten - 1;
    		}
    	}
    }
   
    
}
