package multithread;

public class TestMT {
	public static void main(String[] args)
	{
		//School s2 = new School("Object 2");
		
		for(int i = 0; i < 50; i++)
		{
			School s1 = new School("Object 1");

			Thread t= new Thread(s1);
			t.start();
		}
		
	}
}
