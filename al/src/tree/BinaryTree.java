package tree;

import linkedlist.StackLL;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTree implements Iterable<TreeNode> {
	public TreeNode root;

	private class BTIterator implements Iterator<TreeNode> {
		TreeNode current;
		StackLL<TreeNode> st = new StackLL<TreeNode>();
		
		public BTIterator()
		{
			pushLeft(BinaryTree.this.root);
		}
		
		private void pushLeft(TreeNode node)
		{
			while(node != null)
			{
				st.push(node);
				node = node.l;
			}
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return(!(st.isEmpty()));
		}

		@Override
		public TreeNode next() {
			// TODO Auto-generated method stub
			if(hasNext())
			{
				current = (TreeNode) st.pop().getVal();
				pushLeft(current.r);
				return current;
			}
			else
			{
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
	}
	
	private void traverse(TreeNode node, int order)
	{
		if(node == null)
		{
			return;
		}
		
		if(order < 0)
		{
			node.dispaly();
		}
		traverse(node.l, order);
		if(order == 0)
		{
			node.dispaly();
		}		
		traverse(node.r, order);
		if(order > 0)
		{
			node.dispaly();
		}
	}
	
	public void traversalPreOrder()
	{
		traverse(root, -1);
	}
	
	public void traversalInOrder()
	{
		traverse(root, 0);
	}
	
	public void traversalPostOrder()
	{
		traverse(root, 1);
	}
	
	public void traversal()
	{
		traversalInOrder();
	}

	@Override
	public Iterator<TreeNode> iterator() {
		// TODO Auto-generated method stub
		return new BTIterator();
	}
}