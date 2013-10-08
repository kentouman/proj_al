package multithread;

import java.util.HashMap;

public class LRU {
	int size;
	int index;
	CacheNode head;
	CacheNode tail;
	HashMap<Integer, CacheNode> map;
	
	public LRU(int size)
	{
		this.size = size;
		index = 0;
		head = null;
		tail = null;
		map = new HashMap<Integer, CacheNode>();
	}
	
	public synchronized String get(int ref)
	{
		if(map.containsKey(ref))
		{
			CacheNode node = map.get(ref);
			promoteNode(node);
			print();
			return node.msg;
			
		}
		else
		{
			if(index < size)
			{
				index++;
			}
			else
			{
				deleteTail();
			}
			CacheNode node = new CacheNode(ref, deepGet(ref));
			addNode(node);
			print();
			return node.msg;
		}
	}
	
	public synchronized void print()
	{
		CacheNode node = head;
		int cnt = 0;
		System.out.println("====== Thread #" + Thread.currentThread().getId() + " Cache Status=====");
		while(node != null)
		{
			System.out.println("Cache entry #" + cnt + " : " + node.msg);
			node = node.next;
			cnt++;
		}
	}
	
	private void promoteNode(CacheNode node)
	{
		if(node == head)
		{
			return;
		}
		
		node.prev.next = node.next;
		if(node == tail)
		{
			tail = tail.prev;
		}
		else
		{
			node.next.prev = node.prev;
		}
		
		node.next = head;
		node.prev = null;
		head.prev = node;
		head = node;
	}
	
	private void addNode(CacheNode node)
	{
		if(head == null)
		{
			head = node;
			tail = node;
		}
		else
		{
			node.next = head;
			head.prev = node;
			head = node;
		}
		
		map.put(node.ref, node);
	}
	
	private void deleteTail()
	{
		CacheNode temp = tail;
		
		tail = tail.prev;
		tail.next = null;
		
		temp.prev = null;
		temp.next = null;
		
		map.remove(temp.ref);
	}
	
	private String deepGet(int ref)
	{
		return Integer.toString(ref);
	}
}


class CacheNode
{
	int ref;
	String msg;
	CacheNode next;
	CacheNode prev;
	
	public CacheNode(int ref, String msg)
	{
		this.ref = ref;
		this.msg = msg;
		next = null;
		prev = null;
	}
	
}