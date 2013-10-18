package problem;

import java.util.Random;
import java.util.HashMap;

class ListNode
{
    int ref;
    String msg;

    ListNode next;
    ListNode prev;

    public ListNode(int ref, String msg)
    {
        this.ref = ref;
        this.msg = msg;
        next = null;
        prev = null;
    }
}

public class LRU
{
    private int size;
    private int index;
    private ListNode head;
    private ListNode tail;
    HashMap<Integer, ListNode> map;

    public LRU(int size)
    {
        this.size = size;
        index = 0;
        head = null;
        tail = null;
        map = new HashMap<Integer, ListNode>();
    }

    public void print()
    {
        ListNode node = head;
        int cnt = 0;
        while(node != null)
        {
            System.out.println("CacheEntry #" + cnt + " : " + node.msg);
            node = node.next;
            cnt++;
        }
    }

    public String get(int ref)
    {
        if(map.containsKey(ref))
        {
            System.out.println("Cache hit");
            ListNode node = map.get(ref);
            promoteNode(node);
            return node.msg;
        }
        else
        {
            System.out.println("Cache miss...");
            ListNode node = new ListNode(ref, deepGet(ref));
            if(index < size)
            {
                index++;
            }
            else
            {
                deleteTail();
            }
            addNode(node);
            return node.msg;
        }
    }

    private void promoteNode(ListNode node)
    {
        if(node == head)
        {
            return;
        }

        node.prev.next = node.next;

        if(node.next != null)
        {
            node.next.prev = node.prev;
        }
        else
        {
            tail = node.prev;
            tail.next = null;
        }

        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
    }

    private void deleteTail()
    {
        ListNode node = tail;
        tail = tail.prev;
        tail.next = null;

        node.prev = null;
        node.next = null;

        map.remove(node.ref);
    }

    private void addNode(ListNode node)
    {
        if(head == null)
        {
            head = node;
            tail = node;
        }
        else
        {
            node.next = head;
            node.prev = null;

            head.prev = node;
            head = node;
        }
        map.put(node.ref, node);
    }

    private String deepGet(int ref)
    {
        // cache miss, get the thing from the source
        // example deepGet for debug
        return Integer.toString(100000 + ref);
    }

    public static void main(String[] args)
    {
        int cacheSize = 5;
        int testRound = 20;
        int testRange = 20;

        LRU lru = new LRU(cacheSize);

        for(int i = 0; i < testRound; i++)
        {
            Random rand = new Random();
            int ref = rand.nextInt(testRange);
            System.out.println("Retrieving : " + ref);
            String output = lru.get(ref);
            lru.print();
        }
    }

}
