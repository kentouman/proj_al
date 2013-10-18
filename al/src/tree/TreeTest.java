package tree;

import java.util.Arrays;
import java.util.Stack;

public class TreeTest {

	class TreeNode
	{
	     TreeNode left;
	     TreeNode right;
	     int val;

	     public TreeNode(int val)
	     {
	          this.val = val;
	          this.left = null;
	          this.right = null;
	     }
	}

	public static void visitNode(TreeNode node)
	{
	     System.out.println(node.val);
	}

	public TreeNode getTestTree()
	{
	     TreeNode root = new TreeNode(100);
	     root.left = new TreeNode(50);
	     root.left.right = new TreeNode(51);
	     root.right = new TreeNode(150);
	     root.right.left = new TreeNode(149);
	     root.right.right = new TreeNode(151);

	     return root;
	}

	public void traverseInOrder(TreeNode root)
	{
	     if(root == null)
	     {
	          return;
	     }

	     Stack<TreeNode> stack = new Stack<TreeNode>();
	     
	     TreeNode node = root;

	     while(!stack.isEmpty() || node != null)
	     {
	          if(node == null)
	          {
	               node = stack.pop();
	               visitNode(node);
	               node = node.right;
	          }
	          else
	          {
	               stack.push(node);
	               node = node.left;
	          }
	     }
	     
	}

	public void traversePreOrder(TreeNode root)
	{
	     if(root == null)
	     {
	          return;
	     }

	     Stack<TreeNode> stack = new Stack<TreeNode>();

	     TreeNode node = root;

	     while(!stack.isEmpty() || node != null)
	     {
	          if(node == null)
	          {
	               node = stack.pop();
	          }
	          
	          visitNode(node);
	          if(node.right != null)
	          {
	               stack.push(node.right);
	          }
	          node = node.left;          
	     }
	}

	String reverseString (String s) {
	    int len=s.length();
	    char[] c= new char[len];
	    int i;
	    for (i=0;i<len; i++){
	        c[i]=s.charAt(len - 1 - i);
	    }

	    return new String(c);
	}
	
	public static void main(String[] args)
	{
		TreeTest z = new TreeTest();
		
		TreeNode root = z.getTestTree();
		System.out.println("In Order");

		z.traverseInOrder(root);
		System.out.println("Pre Order");
		z.traversePreOrder(root);
		
		System.out.println(z.reverseString("Hello dd"));
	
	}
	
}
