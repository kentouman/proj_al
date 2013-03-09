package sortingz;

public class SortEngine {
	public Boolean insertionSort(int[] mylist){
		
		for(int i=1; i<mylist.length; i++)
		{
			for(int j=i; j>0; j--)
			{
				if(mylist[j]<mylist[j-1])
				{
					mySwap(mylist,j,j-1);
				}
			}
		}
		return true;
	}
	
	public Boolean quickSort()
	{
		return true;
	}
	
	public Boolean mergeSort(){
		return true;
	}
	
	public void mySwap(int[] x, int a, int b)
	{
		int temp;
		temp = x[a];
		x[a] = x[b];
		x[b] = temp;
	}
}
