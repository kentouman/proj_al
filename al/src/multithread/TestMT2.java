package multithread;

public class TestMT2 implements Runnable{

	String myString = "Yes ";
	
	public void run()
	{
		for(int i = 0; i < 100; i++)
		{
			for(int j = 0; j < 100000; j++) for(int k = 0; k < 1000; k++);
			System.out.println(Thread.currentThread().getName() + "  :" + i );
		}
	    //System.out.print(this.myString);
	}
	
	public static void main(String[] args)
	{
		TestMT2 t1 = new TestMT2();
		TestMT2 t2 = new TestMT2();
		
		Thread r1 = new Thread(t1);
		Thread r2 = new Thread(t2);
		r1.setPriority(Thread.MAX_PRIORITY);
		r2.setPriority(Thread.MIN_PRIORITY);
		
		r1.start();
		r2.start();
	

	}
}
