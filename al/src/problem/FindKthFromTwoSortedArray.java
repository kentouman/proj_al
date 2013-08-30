package problem;

public class FindKthFromTwoSortedArray {

	
	public int findKth(int k, int[] A, int[] B)
	{
		
		if(k > A.length + B.length)
		{
			System.out.println("Invalid k, now exit...");
			return -1;
		}
		
		int pivot;
		int cnt;
		Integer indexA, indexB;
		
		pivot = A[0];
		indexA=0;
		indexB=0;
		cnt = 0;
		
		int[] currentArray = B;
		Integer indexC = indexB;
		
		
		while(cnt <= k-1)
		{
			if (currentArray[indexC] > )
		}
	}
}
