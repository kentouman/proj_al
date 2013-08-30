package sort;

public class InsertionSort extends ASort{
	
	public void sort(int[] array)
	{
		for(int i=1; i<array.length; i++)
		{
			int temp = array[i];
			int hole = i;
			
			while((hole > 0) && (array[hole-1] > temp))
			{
				array[hole] = array[hole - 1];
				hole--;
			}
			
			array[hole] = temp;			
		}		
	}

}
