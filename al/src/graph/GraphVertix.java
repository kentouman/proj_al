package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class GraphVertix {
	private int v;
	private ArrayList<GraphVertix> adj = new ArrayList<GraphVertix>();
	
	public GraphVertix(int v)
	{
		this.setV(v);
	}
	
	public void addNeighbour(GraphVertix v2)
	{
		if(!findNeighbour(v2) && (this != v2))
		{
			adj.add(v2);
		}
	}
	
	public boolean findNeighbour(GraphVertix v2)
	{
		boolean isFound = false;
		
		for(int i = 0; i < adj.size(); i++)
		{
			if(adj.get(i) == v2)
			{
				isFound = true;
				break;
			}
		}
		return isFound;
	}
	
	public ArrayList<GraphVertix> getNeighbours()
	{
		return adj;
	}

	public int getV() {
		return v;
	}

	private void setV(int v) {
		this.v = v;
	}
	
	public String toString()
	{
		return ("Node " + Integer.toString(v));
	}

	public void display() {
		// TODO Auto-generated method stub
		System.out.println(this.toString());

	}
	
	public void displayNeighbour()
	{
		System.out.printf("%s has %d neighbours\n", this.toString(), adj.size());
		Iterator<GraphVertix> iter = adj.iterator();
		
		while(iter.hasNext())
		{
			System.out.printf("\t%s\n", iter.next().toString());
		}
	}
	
}
