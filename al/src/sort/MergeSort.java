package sort;

public class MergeSort extends ASort{
	public void sort(int[] array)
	{
		int[] temp = mergeSort(array);
		
		for(int i = 0; i < array.length; i++)
		{
			array[i] = temp[i];
		}
	}
	
	private int[] mergeSort(int[] array)
	{
		if (array.length <= 1)
		{
			return array;
		}
		
		/* find pivot point */
		int mid = array.length / 2;
		
		int[] left = new int[mid];
		int[] right = new int[array.length - mid];
		
		for(int i = 0; i < mid; i++)
		{
			left[i] = array[i];
		}
		for(int i = 0; i < array.length - mid; i++)
		{
			right[i] = array[i + mid];
		}
				
		left = mergeSort(left);
		right = mergeSort(right);
		
		return merge(left, right);
	}

	private int[] merge(int[] left, int[] right)
	{
		int[] result = new int[left.length + right.length];
		
		int l = 0;
		int r = 0;
		int m = 0;
		
		while((l < left.length) || (r < right.length))
		{
			if((l < left.length) && (r < right.length))
			{
				if(left[l] < right[r])
				{
					result[m] = left[l];
					l++;
					m++;
				}
				else
				{
					result[m] = right[r];
					r++;
					m++;
				}
			}
			else if(l < left.length) 
			{
				result[m] = left[l];
				l++;
				m++;
			}
			else if(r < right.length)
			{
				result[m] = right[r];
				r++;
				m++;
			}
		}
		
		return result;
	}
}
