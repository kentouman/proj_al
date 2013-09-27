package String;

public class RabinKarp extends StringMatch{

	@Override
	public int match(String s, String w) {
		// TODO Auto-generated method stub

		assert(s.length() >= w.length());
		int q = 13;
		int qq = 1;
		for(int i = 0; i < w.length(); i++)
		{
			qq = qq * q;
		}
		
		
		// calculate the hash of w
		int hashw = 0;
		int hashs = 0;
		for(int i = 0; i < w.length(); i++)
		{
			hashw = (hashw * q + w.charAt(i)) % qq;
			hashs = (hashs * q + s.charAt(i)) % qq;
		}
		
		
		for(int i = 0; i <= s.length() - w.length(); i++)
		{
			if(hashs == hashw)
			{
				if(s.substring(i, i + w.length()).equals(w))
				{
					System.out.println("Found it ! hash and string match");
					return i;
				}
				else
				{
					System.out.println("hash match, but false positive");
				}
			}
			
			// update the hash of s
			if(i + w.length() < s.length())
			{
				hashs = (hashs * q + s.charAt(i+ w.length())) % qq;
			}
		}
		
		return s.length();
		
	}
	
	

}
