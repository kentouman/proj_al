package sortingz;
import java.util.Arrays;

public class Tests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Testcase1 t1 = new Testcase1();
		SortEngine sort1 = new SortEngine();
		
		
		int[] mylist = t1.inputGenerate();
		//t1.checkResults();
		System.out.println(Arrays.toString(mylist));
		sort1.insertionSort(mylist);
		System.out.println("After sorting:");
		System.out.println(Arrays.toString(mylist));
	}
}
