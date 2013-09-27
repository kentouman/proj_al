package String;

public class KMP extends StringMatch{

	@Override
	public int match(String s, String w) {
		// TODO Auto-generated method stub
		
		// Prepare
		int[] shift = new int[w.length()];
		int m = 0;
		int i = 0;
		shift[0] = -1;
		if(w.length() > 1)
		{
			shift[1] = 0;
		}
		for(int j = 2; j < w.length(); j++)
		{
			if(w.charAt(j - 1) == w.charAt(shift[j-1]))
			{
				shift[j] = shift[j-1] + 1;
			}
			else
			{
				shift[j] = 0;
			}
		}
	
		while (m + i < s.length())
		{
			if(s.charAt(m + i) == w.charAt(i))
			{
				System.out.printf("%c", s.charAt(m + i));
				i++;
				if(i == w.length())
				{
					System.out.println("<-- Found it!");
					return m;
				}
			}
			else
			{
				System.out.printf("%c", s.charAt(m + i));
				System.out.printf("<-- Wrong, again! m=%d,i=%d,  ", m, i);
				m = m + i - shift[i];
				System.out.printf("new m = %d, ",m);
				if(shift[i] == -1)
				{
					i = 0;
					System.out.printf("new i = %d\n",i);
				}
				else
				{
					i = shift[i];
					System.out.printf("new i = %d\n",i);
					for(int k = 0; k < i; k++)
					{
						System.out.print(" ");
					}
				}
			}
		}
		
		// Cannot find match, return the length of the sought string
		return s.length();
		
	}
}