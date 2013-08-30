package tree;

public class TreeNode extends ATreeNode{
	private int val;
	
	public TreeNode(int val)
	{
		setVal(val);
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
	
	public void dispaly()
	{
		System.out.println(getVal());
	}
	
	public int compare(TreeNode node)
	{
		if (this.getVal() > node.getVal())
		{
			return 1;
		}
		else if(this.getVal() == node.getVal())
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}
	
	public int compare(int val)
	{
		if (this.getVal() > val)
		{
			return 1;
		}
		else if(this.getVal() == val)
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}
}
