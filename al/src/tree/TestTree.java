package tree;

import java.util.Iterator;

public class TestTree {
	public static void main (String[] args)
	{
		final int inputSize = 10;
		final int maxInput = 100;
		BinarySearchTree a = new BinarySearchTree();
		
		for(int i = 0; i < inputSize; i++)
		{
			int val = (int)(Math.random() * maxInput);
			System.out.print(val);
			System.out.print(" ");
			a.insertNode(val);
		}
		System.out.println();
		System.out.println();
		
		a.traversal();
		System.out.println();
		System.out.println();
		
		Iterator<TreeNode> iter = a.iterator();
		
		System.out.println(iter.hasNext());
		
		while(iter.hasNext())
		{
			iter.next().dispaly();
		}  
	
		System.out.println(iter.hasNext());
		
	}
}
