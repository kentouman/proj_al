package sort;

public class HeapSort extends ASort{
	public void sort(int[] array)
	{
		heapify(array);
		for(int i = array.length - 1; i > 0 ; i--)
		{
			swap(array, 0, i);
			siftDown(array, i - 1);
		}		
	}
	
	private void heapify(int[] array)
	{
		for(int i = 1; i < array.length; i++)
		{
			siftUp(array, i);
		}
	}
	
	private void siftDown(int[] array, int end)
	{
		int temp = 0;
		
		while(temp * 2 + 1 <= end){
			int leftChild = temp * 2 + 1;
			int rightChild = leftChild + 1;
			
			if(array[temp] < array[leftChild])
			{
				if((rightChild <= end) && (array[leftChild] < array[rightChild]))
				{
					swap(array, temp, rightChild);
					temp = rightChild;
				}
				else
				{
					swap(array, temp, leftChild);
					temp = leftChild;
				}
			}
			else
			{
				if((rightChild <= end) && (array[temp] < array[rightChild]))
				{
					swap(array, temp, rightChild);
					temp = rightChild;
				}
				else
				{
					break;
				}
			}
		}
	}
	
	private void siftUp(int[] array, int index)
	{
		while(index != 0)
		{
			int parent = (index - 1) / 2;
			if(array[index] > array[parent])
			{
				swap(array, index, parent);
				index = parent;
			}
			else
			{
				break;
			}
		}
	}
}
