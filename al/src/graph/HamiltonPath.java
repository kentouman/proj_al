package graph;


public class HamiltonPath {
	final static int WHITE = 0;
	final static int GREY = 1;
	int triedPath = 0;
	int visitednum = 0;
	//final static int BLACK = 2;
	
	boolean solvePinLock(int digit) //max = 10000
	{
		
		// prepare the graph
		int max = 1;
		while(digit > 0)
		{
			max *= 10;
			digit--;
		}
		int[] color = new int[max];
		
		for(int i = 0; i < max; i++)
		{
			color[i] = WHITE; // untouched
		}
		
		// DFS 
		return DFS(0,color,max,0);
		
		
	}
	
	boolean DFS(int visited, int[] color, int size, int node)
	{
		if(visited == size)
		{
			return true;
		}
		
		if(color[node] == GREY)
		{
			triedPath++;
			return false;
		}
		else
		{
			color[node] = GREY;
			visited++;
			
			//find neighbours
			for(int i = 0; i < 10; i++)
			{
				int neighbour = (node * 10 + i) % size;
				
				boolean result = DFS(visited, color, size, neighbour);
				if(result == true)
				{
					visitednum++;
					System.out.printf("%05d : %04d\n", visitednum, neighbour);	
					return true;
				}
			}
			
			visited--;
			color[node] = WHITE;
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		HamiltonPath a = new HamiltonPath();
		boolean flag = a.solvePinLock(4);
		System.out.println(flag);
		System.out.printf("Tried path = %d\n", a.triedPath);
	}
}
