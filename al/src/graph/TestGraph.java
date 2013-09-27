package graph;

import java.util.Random;

public class TestGraph {
	public static void main(String[] args)
	{
		Graph g = new Graph();
		Random r = new Random();
		
		int graphSize = 10;
		
		for(int i = 0; i < graphSize; i++)
		{
			g.addVertix(i);
		}
		
		// randomly make edges
		
		for(int i = 0; i < graphSize; i++)
		{
			for(int j = 0; j < graphSize; j++)
			{
				if(r.nextInt(3) == 0)
				{
					g.getVertix(i).addNeighbour(g.getVertix(j));
					g.getVertix(j).addNeighbour(g.getVertix(i));
				}
			}
		}
		
		g.displayAll();
		
		g.dfs(5);
		//g.bfs(11);
	}
}
