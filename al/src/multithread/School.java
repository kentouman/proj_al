package multithread;

import java.util.ArrayList;

public class School implements Runnable{
	public String name;
	int count;
	final static int TESTROUND = 500;
	final static int DELAY = 100;
	
	public School(String name)
	{
		this.name = name;
	}
	
	synchronized private void increase()
	{
		int temp = count;
		int temp2 = temp+3;
		count = temp2;
	}
	
	private void print()
	{
		System.out.println(Thread.currentThread().getName() + ':' + count);
	}
	
	private void doRun()
	{
		int max = 1000000;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for(int i = 0; i < max; i++)
		{
			for(int j = 0; j < max; j++)
			{
				for(int k = 0; k < max; k++)
				{
					for(int l = 0; l < max; l++)
					{
						//temp.add(i+j+k+l);
					}
				}
			}
		}
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < TESTROUND; i++)
		{
			increase();
			print();
			//doRun();
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
