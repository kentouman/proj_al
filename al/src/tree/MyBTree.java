package tree;

import java.util.ArrayList;

public class MyBTree<K extends Comparable<K>,V> {
	private BTreeNode<K,V> root;
	private int height;
	private int num;
	private int maxNum;
	
	private final class BTreeNode<K extends Comparable<K>,V>
	{
		int count;
		ArrayList<K> keys;
		ArrayList<V> values;
		ArrayList<BTreeNode> children;
		
		public BTreeNode()
		{
			count = 0;
			keys = new ArrayList<K>();
			values = new ArrayList<V>();
			children = new ArrayList<BTreeNode>();
		}	
	}	
	
	public MyBTree(int max)
	{
		root = new BTreeNode<K,V>();
		height = 0;
		num = 0;
		maxNum = max;
	}
	
	public V get(K key)
	{
		return getKey(key, root);
	}
	
	private V getKey(K key, BTreeNode<K,V> node)
	{
		if(height == 0)
		{
			for(int i = 0; i < node.keys.size(); i++)
			{
				if(key.equals(node.keys.get(i)))
				{
					return node.values.get(i);
				}
			}
			return null;
		}
		else
		{
			for(int i = 0; i < node.keys.size(); i++)
			{
				K cur = node.keys.get(i);
				if(key.compareTo(cur) == 0)
				{
					return node.values.get(i);
				}
				else if(key.compareTo(cur) < 0)
				{
					return getKey(key, node.children.get(i));
				}
			}
			
			return getKey(key, node.children.get(node.children.size() - 1));
		}
	}
	
	public boolean put(K key, V value)
	{
		return putKeyValue(key, value, root);
	}
	
	private boolean putKeyValue(K key, V value, BTreeNode<K,V> node)
	{
		
	}
}
