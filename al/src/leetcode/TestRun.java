package leetcode;

public class TestRun {
	

	public static void main(String[] args)
	{
		TestRun a = new TestRun();
		ListNode b = new ListNode(1);
		b.next = new ListNode(2);
		b.next.next = new ListNode(3);
		
		a.reverseKGroup(b, 2);
	}
	
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(k < 2)
        {
        	return head;
        }
    	
        ListNode temp = new ListNode(0);
        temp.next = head;
        head = temp;
        
        while(temp.next != null)
        {
            //check if the rest has at least k nodes
            boolean lessThanK = false;
            ListNode temp2 = temp.next;
            for(int i = 0; i < k; i++)
            {
                if (temp2 == null)
                {
                    lessThanK = true;
                    break;
                }
                temp2 = temp2.next;
            }
            if(lessThanK)
            {
                break;
            }
            
            // now that it has at least k nodes, do the reverse
            
            temp2 = temp.next;
            ListNode temp3 = temp2.next;
            ListNode temp4 = temp3.next;
            
            for(int i = 0; i < k - 1; i++)
            {
                temp4 = temp3.next;
                temp3.next = temp2;
                temp2 = temp3;
                temp3 = temp4;
            }
            
            temp = temp.next;
            temp.next = temp4;

        }
        
        return head.next;
    }
    
}