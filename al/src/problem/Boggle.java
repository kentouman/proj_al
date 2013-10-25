package problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Boggle {
	Trie trieDict;
	ArrayList<String> result;
	boolean[][] visited;
	
	public List<String> solveBoggle(char[][] array, Set<String> dict)
	{
		trieDict = new Trie(dict);
		int m = array.length;
		int n = array[0].length;
		visited = new boolean[m][n];
		result = new ArrayList<String>();
		
		for(int i = 0; i < m ; i++)
		{
			for(int j = 0 ; j < n; j++)
			{
				String sb = new String();
				solveBoggleTrie(array, i, j, sb);
			}
		}
		
		return result;
	}
	
	public void solveBoggleTrie(char[][] array, int x, int y, String sb)
	{
		int m = array.length;
		int n = array[0].length;
		String sc = sb + array[x][y];
		
		if (trieDict.checkPrefix(sc))
		{	
			if(trieDict.checkWord(sc))
			{
				result.add(sc);
			}
			
			visited[x][y] = true;
			
			
			if(x < m - 1 && !visited[x+1][y])	solveBoggleTrie(array, x+1, y, sc);
			if(x > 0 && !visited[x-1][y]) 		solveBoggleTrie(array, x-1, y, sc);
			if(y < n - 1 && !visited[x][y+1])	solveBoggleTrie(array, x, y+1, sc);
			if(y > 0 && !visited[x][y-1])		solveBoggleTrie(array, x, y-1, sc);
			
			visited[x][y] = false;
		}
	}
	
	public static void main(String[] args)
	{
		Boggle z = new Boggle();
		
		z.testBoggle();
	}
	
	public void testBoggle()
	{
		Set<String> dict = new HashSet<String>();
		dict.add("hello");
		dict.add("world");
		dict.add("apple");
		dict.add("new");
		dict.add("aob");
		
		char[][] array = {{'a','h','e'}, {'o','l','l'}, {'b','c','c'}};
		
		List<String> result = solveBoggle(array, dict);
		for(String s : result)
		{
			System.out.println(s);
		}
	}
}

class Trie
{
	TrieNode root;
	
	public Trie()
	{
		root = new TrieNode('\0', "");
	}
	
	public Trie(Set<String> set)
	{
		this();
		for(String s : set)
		{
			addWord(s);
		}
	}
	
	public boolean checkPrefix(String s)
	{
		return getPrefix(s, root) != null;
	}
	
	public TrieNode getPrefix(String s, TrieNode node)
	{
		
		if(node.hasChild(s.charAt(0)))
		{
			if(s.length() == 1)
			{
				return node.getChild(s.charAt(0));
			}
			else
			{
				return getPrefix(s.substring(1, s.length()), node.getChild(s.charAt(0)));
			}
		}
		else
		{
			return null;
		}
	}
	
	public boolean checkWord(String s)
	{
		TrieNode temp = getPrefix(s, root);
		
		return (temp != null && temp.isWord());
	}
	
	public void addWord(String s)
	{
		addWord(s, root);
	}
	
	public void addWord(String s, TrieNode node)
	{
		TrieNode next = node.addChild(s.charAt(0));
		
		if(s.length() == 1)
		{
			next.setWord();
		}
		else
		{
			addWord(s.substring(1, s.length()), next);
		}
	}
}

class TrieNode
{
	char c;
	String s;
	boolean isWord;
	HashMap<Character, TrieNode> children;
	
	public TrieNode(char c, String s)
	{
		this.c = c;
		this.s = s;
		isWord = false;
		children = new HashMap<Character, TrieNode>();
	}
	
	public boolean hasChild(char c)
	{
		return children.containsKey(c);
	}
	
	public TrieNode getChild(char c)
	{
		if(hasChild(c))
		{
			return children.get(c);
		}
		else
		{
			return null;
		}
	}
	
	
	public TrieNode addChild(char c)
	{
		if(!hasChild(c))
		{
			TrieNode newNode = new TrieNode(c, s + c);
			children.put(c, newNode);
			return newNode;
		}
		else
		{
			return children.get(c);
		}
	}
	
	public void setWord()
	{
		isWord = true;
	}
	
	public boolean isWord()
	{
		return isWord;
	}
}