package dpz;

public class DpEggDrop {

	public int eggDrop(int n, int h)
	{
		int[][] s = new int[n+1][h+1];
		int i,j,k, temp;
		
		//System.out.println("Entry DP");
		
		for(i = 0; i <= h; i++)
		{
			s[0][i]=0;
			s[1][i]=i;
		}
		
		for(i = 1; i <= n; i++)
		{
			s[i][0]=0;
			s[i][1]=1;
		}


		for(i = 2; i <=n; i++)
		{
			for(j = 2; j <=h; j++)
			{
				for(k = 1; k <= j; k++)
				{
					temp = s[i][j-k] > s[i-1][k-1] ? s[i][j-k] : s[i-1][k-1];
					if ((s[i][j] > (temp+1))||(s[i][j]==0))
					{
						s[i][j] = temp + 1;
					}
				}
			}
		}
		
		for(i=0;i<=n;i++)
		{
			for(j=0;j<=h;j++)
			{
				System.out.print(s[i][j]+" ");
			}
			System.out.println();
		}
		
		return s[n][h];
		
	}
}
