package tree;

public class BinarySearchTree extends BinaryTree{
	
	public void insertNode(int val)
	{
		TreeNode temp = root;
		
		if(root == null)
		{
			root = new TreeNode(val);
			return;
		}
		
		while(temp != null)
		{
			if(temp.compare(val) > 0)
			{
				if(temp.l != null)
				{
					temp = temp.l;
				}
				else
				{
					temp.l = new TreeNode(val);
				}
			}
			else if(temp.compare(val) < 0)
			{
				if(temp.r != null)
				{
					temp = temp.r;
				}
				else
				{
					temp.r = new TreeNode(val);
				}			
			}
			else
			{
				return; /*no dup*/
			}
		}
		
	}
	
	public boolean searchNode(int val)
	{
		TreeNode temp = root;
			
		while(temp != null)
		{
			if(temp.compare(val) > 0)
			{
				if(temp.l != null)
				{
					temp = temp.l;
				}
				else
				{
					return false;
				}
			}
			else if(temp.compare(val) < 0)
			{
				if(temp.r != null)
				{
					temp = temp.r;
				}
				else
				{
					return false;
				}			
			}
			else
			{
				return true; /*found*/
			}
		}
		
		return false;
			
	}
}
