package multithread;

public class School implements Runnable{
	public String name;
	int count;
	final static int TESTROUND = 50;
	final static int DELAY = 100;
	
	public School(String name)
	{
		this.name = name;
	}
	
	synchronized private void increase()
	{
		int temp = count;
		int temp2 = temp+1;
		count = temp2;
	}
	
	private void print()
	{
		System.out.println(Thread.currentThread().getName() + ':' + count);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < TESTROUND; i++)
		{
			increase();
			print();
		}	
		/*
		try
		{
			for(int i = 0; i < TESTROUND; i++)
			{
				increase();
				print();
				Thread.sleep(1);
			}		
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}
	

}
