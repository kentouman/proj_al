package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

import linkedlist.QueueLL;

// directed graph 
public class Graph {
	private ArrayList<GraphVertix> vertices = new ArrayList<GraphVertix>();
	
	public void addVertix(GraphVertix v)
	{
		if(!findVertix(v))
		{
			vertices.add(v);
		}
	}
	
	public void addVertix(int v)
	{
		vertices.add(new GraphVertix(v));
	}
	
	public void clearVisited()
	{
		for(GraphVertix v : vertices)
		{
			v.setVisited(0);
		}
	}
	
	public GraphVertix getVertix(int v)
	{
		return vertices.get(v);
	}
	
	private boolean findVertix(GraphVertix v)
	{
		boolean isFound = false;
		for(int i = 0; i< vertices.size(); i++)
		{
			if(vertices.get(i) == v)
			{
				isFound = true;
				break;
			}
		}
		return isFound;
	}
	
	public void addEdge(int v1, int v2)
	{
		vertices.get(v1).addNeighbour(vertices.get(v2));
	}
	
	public boolean dfs(int target)
	{
		GraphVertix s = getVertix(0);
		clearVisited();
		
		return doDFSInteratively(s, target);
		
	}
	
	
	public boolean doDFS(GraphVertix q, int target)
	{
		q.visited();
		
		if(q.getV() == target)
		{
			System.out.printf("found %d at Node %d\n", target, q.getV());
			return true;
		}
		else
		{
			System.out.printf("Not found %d at Node %d\n", target, q.getV());
			
			for(GraphVertix v : q.getNeighbours())
			{
				if(!v.checkVisited())
				{
					if(doDFS(v,target))
					{
						return true;
					}
				}
			}
			return false;
		}
	}
	
	public boolean doDFSInteratively(GraphVertix q, int target)
	{
		Stack<GraphVertix> stack = new Stack<GraphVertix>();
		
		q.visited();
		stack.push(q);
		GraphVertix n = null;
		
		while(!stack.isEmpty())
		{
			n = stack.pop();
			if(n.getV() == target)
			{
				System.out.printf("found %d at Node %d\n", target, n.getV());
				return true;
			}
			System.out.printf("Not found %d at Node %d\n", target, n.getV());
			for(GraphVertix v : n.getNeighbours())
			{
				if(!v.checkVisited())
				{
					v.visited();
					stack.push(v);
				}
			}
			
		}
		
		return false;
	}
	
	public boolean bfs(int target)
	{
		
		ArrayDeque<GraphVertix> q = new ArrayDeque<GraphVertix>();
		boolean isFound = false;

		clearVisited();

		GraphVertix s = getVertix(0);
		
		s.visited();
		
		q.add(s);
		
		while(!q.isEmpty())
		{
			GraphVertix temp = q.poll();
			if (temp.getV() == target)
			{
				System.out.printf("Found %d at Node %d\n", target, temp.getV());
				isFound = true;
				break;
			}
			else
			{
				System.out.printf("Not found %d at Node %d\n", target, temp.getV());
				for(GraphVertix v : temp.getNeighbours())
				{
					if(!v.checkVisited())
					{
						v.visited();
						q.add(v);
					}
				}
			}
		}
		
		if(!isFound)
		{
			System.out.printf("Could not find %d\n", target);
		}
		
		return isFound;
		
	}
	
	public int getNumOfVertices()
	{
		return vertices.size();
	}

	public void displayAll() {
		// TODO Auto-generated method stub
		Iterator<GraphVertix> iter = vertices.iterator();
		while(iter.hasNext())
		{
			iter.next().displayNeighbour();
		}
		
	}
	
}
