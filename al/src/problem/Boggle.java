package problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Boggle {
	public List<String> solveBoggle(char[][] array, HashSet<String> dict)
	{
		int m = array.length;
		int n = array[0].length;
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				// starting for i, j
				boolean[][] visited = new boolean[m][n];
				
				findWord(array, visited, dict, result);
			}
		}
		
		return result;
	}
	
	private void findWord(char[][] array, boolean[][] visited, HashSet<String> dict, List<String> result)
	{
		
	}
}
