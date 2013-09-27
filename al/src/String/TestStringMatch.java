package String;

public class TestStringMatch {
	public static void main(String[] args)
	{
		KMP a = new KMP();
		RabinKarp b = new RabinKarp();
		
		String s = "ABABXABCDABABCD";
		String w = "ABABCD";
		int result = b.match(s, w);
		System.out.println(result);
		
		String d = w.substring(6,6);
		System.out.println(d.length());
	}
}
