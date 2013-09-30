package basicz;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class ListNode
{
	ListNode next;
	int val;
	public ListNode(int val)
	{
		this.val = val;
	}
	public ListNode()
	{
		this(0);
	}
}


public class Solution
{
	
   public int[] der(int[] x) {
	   int[] result = new int[x.length - 1];
	   for(int i = 1; i< x.length; i++)
	   {
		   result[i-1] = x[i] * i;
	   }
	   
	   return result;
       
   }
   
   public int myDivide(Integer a, Integer b) throws ArithmeticException, NullPointerException

   {
	   int result = 0; 
	   try
	   {
		   result = a / b;
	   }
	   catch(Exception e)
	   {
		   System.out.println("pass to the caller to handle it");
	   }
	   return result;
   }
   
   //One's at the head
   public ListNode addListNode(ListNode a, ListNode b)
   {
	   ListNode result = new ListNode();
	   int carry = 0;
	   
	   ListNode head = result;
	   
	   while(a!=null || b!=null)
	   {
		   if(a!=null)
		   {
			   head.val = head.val + a.val;
			   a=a.next;
		   }
		   if(b!=null)
		   {
			   head.val = head.val + b.val;
			   b=b.next;
		   }
		   if(head.val >= 10)
		   {
			   head.val = head.val - 10;
			   carry = 1;
		   }
		   
		   if(a!=null || b!= null || carry != 0)
		   {
			   head.next = new ListNode(carry);
			   carry = 0;
			   head = head.next;
		   }
	   }
	   
	   return result;
   }
   
   //One's at tail
   public ListNode addListNode2(ListNode a, ListNode b)
   {
	   ListNode result = new ListNode(); 
	   ListNode head = result;
	   int num9 = 0;
	   
	   int lenA = 0;
	   int lenB = 0;
	   
	   ListNode aa = a;
	   ListNode bb = b;
	   while(aa!=null)
	   {
		   aa=aa.next;
		   lenA++;
	   }
	   while(bb!=null)
	   {
		   bb=bb.next;
		   lenB++;
	   }
	   
	   if(lenB > lenA)
	   {
		   int temp = lenB;
		   lenB=lenA;
		   lenA=temp;
		   ListNode temp1 = b;
		   b = a;
		   a = temp1;
	   }
	   
	   while(lenA > lenB)
	   {
		   num9 = addListNode2Helper(head, a.val, 0, num9);
		   a=a.next;
		   lenA--;
	   }
	   
	   while(lenA > 0)
	   {
		   num9 = addListNode2Helper(head, a.val, b.val, num9);
		   a=a.next;
		   b=b.next;
		   lenA--;
	   }
	   
	   while(num9 > 0)
	   {
		   head.next = new ListNode(9);
		   head = head.next;
		   num9--;
	   }
	   
	   if(result.val == 0)
	   {
		   result = result.next;
	   }
	   return result;
	   
   }
   
   public int addListNode2Helper(ListNode head, int a, int b, int num9)
   {
	   int tempSum = a + b;
	   if(tempSum == 9)
	   {
		   num9++;
	   }
	   else
	   {
		   int carry = tempSum / 10;
		   while(num9 > 0)
		   {
			   head.val = (head.val + carry) % 10;
			   head.next = new ListNode(9);
			   head=head.next;
			   num9--;
		   }
		   head.val = (head.val + carry) % 10;
		   head.next = new ListNode(tempSum % 10); 
		   head=head.next;
	   }
	   
	   return num9; 
   }
   
   public int maxSum(int[] A)
   {
	   int sum = 0;
	   int max = A[0];
	   
	   for(int a : A)
	   {
		   sum = (sum <= 0) ? a : sum + a;
		   max = Math.max(sum, max);
	   }
	   return max;
   }

	// to find the kth largest number in a array;
	
	static int findKth(int[] array, int start, int end, int k)
	{
	    // will use the quick sort but modified to solve this question
	    
	    // first, partition the array around the pivot
	    
	    if(k > end || k < start)
	    {
	        return Integer.MIN_VALUE;
	    }    
	    if(start > end)
	    {
	        return Integer.MIN_VALUE;
	    }
	    else if(start == end)
	    {
	        return array[start];
	    }
	    
	    int pivot = array[end];
	    
	    int i = start;
	    int j = end - 1;
	    
	    while(i <= j)
	    {
	        if(array[j] < pivot)
	        {
	            swap(array, i, j);
	            i++;
	        }
	        else
	        {
	            j--;
	        }
	    }
	    swap(array, i, end);
	    
	    // then, only find in the parition that contains the kth number
	
	    if(k < i)
	    {
	        return findKth(array, start, i - 1, k);
	    }
	    else if(k > i)
	    {
	        return findKth(array, i + 1, end, k);
	    }
	    else
	    {
	        return array[i];
	    }
	      
	}
	
	// helper function to swap two positions in a array
	static void swap(int[] array, int a, int b)
	{
	    int temp = array[a];
	    array[a] = array[b];
	    array[b] = temp;
	}
	
	// testcase
	
	void test()
	{
	    int[] input1 = {};
	    int[] input2 = {1,6,2,-1,3,445};
	    
	    int k = 3;
	    
	    System.out.println(findKth(input1, 0, input1.length - 1, k));
	    System.out.println(findKth(input2, 0, input2.length - 1, k));
	
	}

	LinkedList<Integer> union(LinkedList<Integer> a, LinkedList<Integer> b)
	{
	    LinkedList<Integer> result = new LinkedList<Integer>();
	    
	    int indexA = 0;
	    int indexB = 0;
	    
	    int lenA = a.size();
	    int lenB = b.size();
	    
	    while(indexA < lenA && indexB < lenB)
	    {
	        int temp;
	        
	        if(a.get(indexA) < b.get(indexB))
	        {
	            temp = a.get(indexA);
	            indexA++;
	        }
	        else if(a.get(indexA) > b.get(indexB))
	        {
	            temp = b.get(indexB);
	            indexB++;
	        }
	        else
	        {
	            temp = a.get(indexA);
	            indexA++;
	            indexB++;
	        }
	        
	        if(result.isEmpty() || result.getLast() != temp)
	        {
	            result.add(temp);
	        }
	    }
	    
	    if(indexA < lenA)
	    {
	        int temp = a.get(indexA);
	        if(result.getLast() != temp)
	        {
	            result.add(temp);
	        }
	        indexA++;
	    }
	    else if(indexB < lenB)
	    {
	        int temp = b.get(indexB);
	        if(result.getLast() != temp)
	        {
	            result.add(temp);
	        }
	        indexB++;
	    }
	    
	    return result;
	}
	
	static LinkedList<Integer> intersection(LinkedList<Integer> a, LinkedList<Integer> b)
	{
	    /** validate arugment
	     *  it can be empty, but cannot be null
	     */
	    if(a == null || b == null)
	    {
	        throw new NullPointerException();
	    }
	    
	    if(a.isEmpty())
	    {
	        return b;
	    }
	    if(b.isEmpty())
	    {
	        return a;
	    }
	    
	    int indexA = 0;
	    int indexB = 0;
	    
	    LinkedList<Integer> result = new LinkedList<Integer>();
	    
	    while(indexA < a.size() && indexB < a.size())
	    {
	        if(a.get(indexA) < b.get(indexB))
	        {
	            indexA++;
	        }
	        else if(a.get(indexA) > b.get(indexB))
	        {
	            indexB++;
	        }
	        else
	        {
	            result.add(a.get(indexA));
	            indexA++;
	            indexB++;
	        }
	    }
	    
	    return result;
	}

	static void testIntersection()
	{
	    LinkedList<Integer> a = new LinkedList<Integer>();
	    LinkedList<Integer> b = new LinkedList<Integer>();
	    LinkedList<Integer> c = new LinkedList<Integer>();
	    a.add(1);
	    a.add(2);
	    a.add(3);
	    b.add(0);
	    b.add(4);
	    
	    System.out.println(Arrays.toString(intersection(a,c).toArray()));

	}
	
	int getMax(int[] array)
	{
	    if(array.length == 0)
	    {
	        throw new IllegalArgumentException();
	    }
	    
	    int max = array[0];
	    int sum = 0;
	    
	    for(int i = 0; i < array.length; i++)
	    {
	        if(sum <= 0)
	        {
	            sum = array[i];
	        }
	        else
	        {
	            sum = sum + array[i];
	        }
	        
	        if(max < sum)
	        {
	            max = sum;
	        }
	    }
	    
	    return max;
	}

	public void tecent()
	{
		boolean noChange = false;
		int len = 10;
		int[] a = new int[len];
		while(!noChange)
		{
			noChange = true;
			for(int i = 0; i < len; i++)
			{
				int cnt = 0;
				for(int j = 0; j < len; j++)
				{
					if(a[j] == i)
					{
						cnt++;
					}
				}
				if(cnt != a[i])
				{
					noChange = false;
					a[i] = cnt;
				}
			}
		}
		
		System.out.println(Arrays.toString(a));
	}
	

	public static void main(String[] args) throws InterruptedException
	{
		Solution z = new Solution();
	
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		b.add(1);
		b.add(2);
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		
		set.add(a);
		
		
		System.out.println(set.contains(b));
	}
}

