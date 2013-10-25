package basicz;

import java.util.Arrays;

public class NQueen {
	public boolean solveNQueen(int[][] grid, int row)
	{
		
		int n = grid.length;
		if(row == n)
		{
			return true;
		}

		for(int i = 0; i < n; i++)
		{
			if(isValid(grid, row, i))
			{
				
				grid[row][i] = 1;
				if(solveNQueen(grid, row + 1))
				{
					return true;
				}
				grid[row][i] = 0;
			}
		}
		return false;
	}
	
	private boolean isValid(int[][] grid, int row, int col)
	{
		for(int i = 0; i < row; i++)
		{
			if(grid[i][col] == 1)
			{
				return false;
			}
			
			if(col - row + i >=0 && grid[i][col - row + i] == 1)
			{
				return false;
			}
			
			if(col + row - i < grid.length && grid[i][col + row - i] == 1)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		NQueen z = new NQueen();
		
		int testSize = 22;
		int[][] result = new int[testSize][testSize];
		if(z.solveNQueen(result, 0))
		{
			
			for(int i = 0; i < testSize; i++)
			{
				System.out.println(Arrays.toString(result[i]));
			}
		}
	}
}
