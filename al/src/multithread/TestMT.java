package multithread;

public class TestMT {
	public static void main(String[] args)
	{
		School s1 = new School("Object 1");
		//School s2 = new School("Object 2");
		
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s1);
		Thread t3 = new Thread(s1);
		Thread t4 = new Thread(s1);
		Thread t5 = new Thread(s1);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
