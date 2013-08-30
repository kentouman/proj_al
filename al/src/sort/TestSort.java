package sort;

import java.util.Arrays;

public class TestSort {
	public static void main(String[] args)
	{
		int[] a = new int[30];
		
		for(int i=0; i < a.length; i++)
		{
			a[i] = (int) (Math.random()*Integer.MAX_VALUE);
		}
		
		/*Before Sorting*/
		System.out.println(Arrays.toString(a));	
		
		/*Initilize sort engine*/
		SortEngine.sort(a, "bubblesort");
		
		
		System.out.println("After Sorting:");
		System.out.println(Arrays.toString(a));	
		
		System.out.println("validating..." + validateSortedArray(a));		
	}
	
	private static boolean validateSortedArray(int[] array)
	{
		boolean f = true;
		for(int i=1; i < array.length; i++)
		{
			if(array[i] < array[i-1])
			{
				f = false;
				System.out.println(Integer.toString(array[i]) + " - " + Integer.toString(array[i-1]) + " = ?" );
			}
		}
		return f;
	}
}
