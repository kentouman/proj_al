package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
	
	public boolean bfs(int v)
	{
		QueueLL<GraphVertix> q = new QueueLL<GraphVertix>();
		HashMap<GraphVertix, Integer> color = new HashMap<GraphVertix, Integer>();
		boolean isFound = false;
		
		for(int i = 0; i < vertices.size(); i++)
		{
			color.put(vertices.get(i), 0); // white
		}
		
		GraphVertix s = getVertix(0);
		color.put(s, 1);
		q.enqueue(s);
		
		while(!q.isEmpty())
		{
			GraphVertix temp = q.dequeue().getVal();
			if (temp.getV() == v)
			{
				System.out.printf("Found %d at Node %d\n", v, temp.getV());
				isFound = true;
				break;
			}
			else
			{
				System.out.printf("Not found %d at Node %d\n", v, temp.getV());
				color.put(temp, 2);
				Iterator<GraphVertix> iter = temp.getNeighbours().iterator();
				while(iter.hasNext())
				{
					GraphVertix n = iter.next();
					if(color.get(n) == 0)
					{
						q.enqueue(n);
						color.put(n, 1);
					}
				}
			}
		}
		
		if(!isFound)
		{
			System.out.printf("Could not find %d\n", v);
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
