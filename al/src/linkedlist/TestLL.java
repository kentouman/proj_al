package linkedlist;

import java.util.Arrays;

public class TestLL {
	
	
	public static void main(String[] args)
	{
		test0();
		//test2();
	}
	
	private static void test0()
	{
		final int inputSize = 10;
		final int maxInput = 49;
		
		LinkedList<Integer> a = new LinkedList<Integer>();
		int[] b = new int[inputSize];
		
		System.out.println("Now add node");
		for(int i = 0; i < inputSize; i++)
		{
			int temp = (int)(Math.random() * maxInput);
			a.addNode(temp);
			b[i] = temp;
			System.out.print(temp);
			System.out.print(" ");
		}
		System.out.println();
		System.out.println();		
		
		System.out.println("Now traverse queue");
		a.traversal();
		
		System.out.println("Now delete node");
		for(int i = 2; i < inputSize; i++)
		{
			System.out.println("Now: " + Integer.toString(b[i]));
			a.delete(b[i]);
			a.traversal();
		}
		System.out.println("Now delete first node");
		a.delete(b[0]);
		a.traversal();
		System.out.println("Now delete non-existing node");
		a.delete(b[5]);
		a.traversal();
		System.out.println("Now delete first node");
		a.delete(b[0]);
		a.traversal();

		
	}
	
	private static void test1()
	{
		final int inputSize = 10;
		final int maxInput = 49;
		
		QueueLL<Integer> a = new QueueLL<Integer>();
		StackLL<Integer> b = new StackLL<Integer>();
		
		System.out.println("Now enqueue");
		for(int i = 0; i < inputSize; i++)
		{
			int temp = (int)(Math.random() * maxInput);
			a.enqueue(temp);
			b.push(temp);
			System.out.print(temp);
			System.out.print(" ");
		}
		System.out.println();
		System.out.println();
		
		/* Now start testing Queue */
		System.out.println("Now traverse queue");
		a.traversal();
		
		System.out.println("Now dequeue");
		while(!(a.isEmpty()))
		{
			a.dequeue().display();
		}
		System.out.println();
		System.out.println();
		
		/* Now start testing Stack */
		System.out.println("Now traverse stack");
		b.traversal();
		b.reverse();
		b.traversal();
		
		System.out.println("Now stack pop");
		while(!(b.isEmpty()))
		{
			b.pop().display();
		}
		System.out.println();
	
	}
	
	private static void test2()
	{
		final int inputSize = 10;
		final int maxInput = 10;
		final int testNum = 50;
		boolean[] f1 = new boolean[testNum];
		boolean[] f2 = new boolean[testNum];
		
		for(int i = 0; i < testNum; i++)
		{
			f1[i] = false;
		}
		
	
		System.out.println("Now add to list");

		for(int j = 0; j < testNum; j++)
		{
			QueueLL<Integer> a = new QueueLL<Integer>();
			
			for(int i = 0; i < inputSize; i++)
			{
				int temp = (int)(Math.random() * maxInput);
				a.enqueue(temp);
				if((int)(Math.random() * 1000) % (inputSize * 3) == 0)
				{
					a.tail.next = a.head;
					f1[j] = true;
					break;
				}
			}
			
			f2[j] = a.checkLoop();
		}
		
		System.out.println(Arrays.toString(f1));
		System.out.println(Arrays.toString(f2));
			
	}
}
