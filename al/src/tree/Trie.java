package tree;

import java.util.HashMap;


public class Trie {
	private TrieNode root;
	
	public Trie()
	{
		root = new TrieNode('\0', "");
	}
	
	public TrieNode getNode(String s)
	{
		TrieNode r = root;
		
		for(int i = 0; i < s.length() && r != null; i++)
		{
			if(r.containsChar(s.charAt(i)))
			{
				r = r.getChild(s.charAt(i));
			}
			else
			{
				return null;
			}
		}
		
		return r;
	}
	
	public boolean containsPrefix(String prefix)
	{
		if(null != getNode(prefix))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean containsWord(String word)
	{
		TrieNode n = getNode(word);
		if(null != n)
		{
			return n.isWord;
		}
		else
		{
			return false;
		}		
	}
	
	public void addWord(String word)
	{
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++)
		{
			char c = word.charAt(i);
			if(!node.containsChar(c))
			{
				node.addChild(new TrieNode(c, node.getString() + c));
			}
			node = node.getChild(c);
		}
		
		node.isWord = true;
	}
	
	public static void main(String[] args)
	{
		Trie t = new Trie();
		
		t.addWord("Hello");
		t.addWord("Jllo");
		t.addWord("He");
		System.out.println(t.containsPrefix("He"));
		System.out.println(t.containsPrefix("Hf"));
		System.out.println(t.containsWord("Hello"));
		System.out.println(t.containsWord("He"));
		
		System.out.println(t.containsWord("Yello"));
	}
}

class TrieNode
{
	char c;
	String s;
	boolean isWord;
	HashMap<Character, TrieNode> map;
	
	public TrieNode(char c, String s)
	{
		this.c = c;
		this.s = s;
		isWord = false;
		map = new HashMap<Character, TrieNode>();
	}
	
	public String getString()
	{
		return s;
	}
	
	public char getChar()
	{
		return c;
	}
	public void addChild(TrieNode n)
	{
		if(!map.containsKey(n.c))
		{
			map.put(n.c, n);
		}
	}
	
	public boolean containsChar(char c)
	{
		return map.containsKey(c);
	}
	
	public TrieNode getChild(char c)
	{
		return map.get(c);
	}
	
	public void setWord()
	{
		isWord = true;
	}
}