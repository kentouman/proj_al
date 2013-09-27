package basicz;

import java.util.Arrays;

public class Permutation {
	public static void permute(String s)
	{
		int len = s.length();
		char[] buffer = new char[len];
		boolean[] used = new boolean[len];
		int bufferLen = 0;
		
		doPermuteRecursively(s.toCharArray(), used, buffer, bufferLen);
	}
	
	public static void doPermuteRecursively(char[] c, boolean[] used, char[] buffer, int bufferLen)
	{
		if(bufferLen == buffer.length)
		{
			// do print
			System.out.println(Arrays.toString(buffer));
			return;
		}
		
		int len = c.length;
		
		for(int i = 0; i < len; i++)
		{
			if(used[i])
			{
				continue;
			}
			else
			{
				buffer[bufferLen] = c[i];
				used[i] = true;
				doPermuteRecursively(c, used, buffer, bufferLen+1);
				used[i] = false;
			}
		}
	}
	
	public static void doPermuteIteratively(char[] c, boolean[] used, char[] buffer, int bufferLen)
	{
		
	}
	
	public static void main(String[] args)
	{
		permute("Hello");
	}
}
