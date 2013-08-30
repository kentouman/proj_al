package linkedlist;

public class ListNode<T> {
	private T val;
	ListNode<T> next;
	
	public ListNode(T val2)
	{
		this.setVal(val2);
		next = null;
	}

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
	
	public void display(){
		System.out.print(getVal());
		System.out.print(" ");
	}
}
