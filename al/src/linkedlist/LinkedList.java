package linkedlist;



public class LinkedList<T> {
	public ListNode<T> head;
	
	public LinkedList ()
	{
		this.head = null;
	}
	
	public boolean isEmpty ()
	{
		return (head == null);
	}
	
	public void addNode(T val)
	{
		if(isEmpty())
		{
			head = new ListNode<T>(val);
			return;
		}
		
		ListNode<T> temp = head;
		
		while(temp.next != null)
		{
			temp = temp.next;
		}
		
		temp.next = new ListNode<T>(val);
	}
	
	public void traversal()
	{
		ListNode<T> temp = head;
		while(temp != null)
		{
			temp.display();
			temp = temp.next;
		}
		System.out.println();
	}
	
	public ListNode<T> find(T val)
	{
		ListNode<T> temp = head;
		
		while((temp != null) && (temp.getVal() != val))
		{
			temp = temp.next;
		}
		
		return temp;
	}
	
	public void delete(T val)
	{
		
		if(isEmpty())
		{
			return;
		}
		
		if(head.getVal() == val)
		{
			head = head.next;
			return;
		}
		
		ListNode<T> temp = head;

		
		while(temp.next != null)
		{
			if(temp.next.getVal() != val)
			{
				temp = temp.next;
			}
			else
			{
				temp.next = temp.next.next;
				break;
			}
		}
	}
	
	public boolean checkLoop()
	{
		ListNode<T> slowWalker = head;
		ListNode<T> fastWalker = head;
		boolean flag = false;
		
		while((fastWalker != null) && (fastWalker.next != null))
		{
			
			fastWalker = fastWalker.next.next;
			slowWalker = slowWalker.next;
			
			if(fastWalker == slowWalker)
			{
				flag = true;
				break;
			}
		}
		
		return flag;
	}
	
	public void reverse()
	{
		if((head==null) || (head.next == null))
		{
			return;
		}
		
		ListNode<T> temp = head;
		ListNode<T> tempNext = temp.next;
		ListNode<T> templl;
		
		temp.next = null;
		
		while(tempNext != null)
		{
			templl = tempNext;
			tempNext = tempNext.next;
			templl.next = temp;
			temp = templl;
		}
		
		head = temp;
		
				
	}
}

