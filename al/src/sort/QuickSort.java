package sort;

public class QuickSort extends ASort{
	public void sort(int[] array)
	{
		sort(array, 0, array.length - 1);
	}
	
	private void sort(int[]array, int start, int end)
	{
		if(start < end)
		{
			int mid = partition(array, start, end);
		
			sort(array, start, mid - 1);
			sort(array, mid + 1, end);
		}
	}
	
	private int partition(int[] array, int start, int end)
	{
		int temp = array[end];
		int j = start;
		for(int i = start; i < end; i++)
		{
			if(array[i] < temp)
			{
				swap(array, i, j);
				j++;
			}
		}
		swap(array, end, j);
		
		return j;
	}
}
