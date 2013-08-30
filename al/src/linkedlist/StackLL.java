package linkedlist;

public class StackLL<T> extends LinkedList<T>{

	
	public void push(T val)
	{
		ListNode<T> temp = new ListNode<T>(val);
		temp.next = head;
		head = temp;
	}
	
	public ListNode<T> pop()
	{
		if(isEmpty())
		{
			return null;
		}
		
		ListNode<T> result = head;
		head = head.next;
		
		return result;
	}
	
	public ListNode<T> top()
	{
		return head;
	}

}
