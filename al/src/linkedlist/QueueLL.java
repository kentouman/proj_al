package linkedlist;

public class QueueLL<T> extends LinkedList<T>{
	public ListNode<T> tail;
	
	public QueueLL()
	{
		super();
		tail = head;
	}
	
	public void enqueue(T val)
	{
		ListNode<T> temp = new ListNode<T>(val);
		
		if(isEmpty())
		{
			head = tail = temp;
			return;
		}
		
		tail.next = temp;
		tail = tail.next;
	}
	
	public ListNode<T> dequeue()
	{
		if(isEmpty())
		{
			return null;
		}
			
		ListNode<T> result = head;
		head = head.next;
		
		if(head == null)
		{
			tail = null;
		}
		return result;
	}
}
