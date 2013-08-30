package sort;

public class SortEngine {

	public static void sort(int[] array, String sortMethod)
	{
		ASort sortEngine; 
		switch(sortMethod)
		{
		case "heapsort": sortEngine = new HeapSort();break;
		case "mergesort": sortEngine = new MergeSort();break;
		case "quicksort": sortEngine = new QuickSort();break;
		case "insertionsort": sortEngine = new InsertionSort();break;
		case "bubblesort": sortEngine = new BubbleSort(); break;
		
		default: sortEngine = new HeapSort();break;
		}
		
		sortEngine.sort(array);
	}
}
