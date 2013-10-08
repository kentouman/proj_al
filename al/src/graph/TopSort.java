package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TopSort {

	
	public boolean topSort(GraphToSort graph, LinkedList<GraphNode> list)
	{
		while(!graph.nodes.isEmpty())
		{
			GraphNode n = graph.nodes.get(0);
			if(!visit(graph, n, list))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public boolean visit(GraphToSort graph, GraphNode n, LinkedList<GraphNode> list)
	{
		if(n.mark == Mark.TEMP)
		{
			return false;
		}
		
		if(n.mark == Mark.CLEAN)
		{
			n.mark = Mark.TEMP;
			for(GraphNode m : n.neighbours)
			{
				visit(graph, m, list);
			}
			n.mark = Mark.PERMENANT;
			graph.nodes.remove(n);
			list.push(n);
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		GraphToSort g = new GraphToSort();
		GraphNode a = new GraphNode('a');
		GraphNode b = new GraphNode('b');
		GraphNode c = new GraphNode('c');
		GraphNode d = new GraphNode('d');
		GraphNode e = new GraphNode('e');
		
		// ace, ad, bc,
		a.add(c);
		a.add(e);
		a.add(d);
		c.add(e);
		b.add(c);
		
		a.add(b);
		c.add(d);
		
		g.add(a);
		g.add(b);
		g.add(c);
		g.add(d);
		g.add(e);
		
		TopSort sortEngine = new TopSort();
		LinkedList<GraphNode> list = new LinkedList<GraphNode>();
		sortEngine.topSort(g, list);
		
		for(GraphNode m : list)
		{
			System.out.print(m.c + " -- ");
		}
	}
}


enum Mark
{
	CLEAN,
	TEMP,
	PERMENANT,
}


class GraphToSort
{
	ArrayList<GraphNode> nodes;
	HashMap<Character, Boolean> map;
	
	public GraphToSort()
	{
		nodes = new ArrayList<GraphNode>();
		map = new HashMap<Character, Boolean>();
	}
	
	public void add(GraphNode node)
	{
		if(!map.containsKey(node.c))
		{
			map.put(node.c, true);
			nodes.add(node);
		}
	}
}
class GraphNode
{
	char c;
	Mark mark;
	
	ArrayList<GraphNode> neighbours;
	
	GraphNode(char c)
	{
		this.c = c;
		mark = Mark.CLEAN;
		neighbours = new ArrayList<GraphNode>();
	}
	
	public void add(GraphNode m)
	{
		neighbours.add(m);
	}
}