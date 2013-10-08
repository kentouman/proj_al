package String;

public class KMP2 {
	public int isMatch(String s, String p)
	{
		
		int lenS = s.length();
		int lenP = p.length();
		
		if(lenS < lenP)
		{
			return lenS;
		}
		
		//build the table
		int[] table = new int[lenP];
		table[0] = -1;
		table[1] = 0;
		int cnt = 0;
		int pos = 2;
		while(pos < lenP)
		{
			if(p.charAt(pos - 1) == p.charAt(cnt))
			{
				cnt++;
				table[pos] = cnt;
				pos++;
			}
			else if(cnt > 0)
			{
				cnt = table[cnt];
			}
			else
			{
				cnt = 0;
				pos++;
			}
		}
		
		int m = 0;
		int i = 0;
		
		while(m + i < lenS)
		{
			if(s.charAt(m + i) == p.charAt(i))
			{
				i++;
				if(i == lenP)
				{
					return m;
				}
			}
			else
			{
				m = m + i - table[i];
				i = Math.max(0 , table[i]);
			}
		}
		return lenS;
	}
	
	public static void main(String[] args)
	{
		KMP2 k = new KMP2();
		String s = "1Hello world";
		String p = "ello";
		System.out.println(k.isMatch(s, p));
	}
}
