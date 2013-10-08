package multithread;

import java.util.Random;

public class TestLRU {
	public static void main(String[] args)
	{
		int numOfThread = 5;
		int lruSize = 5;
		
		Thread[] t = new Thread[numOfThread];
		LRU lru = new LRU(lruSize);
		LRUTest lruTest = new LRUTest(lru);
		
		for(int i = 0; i < numOfThread; i++)
		{
			t[i] = new Thread(lruTest);
		}
		
		for(int i = 0; i < numOfThread; i++)
		{
			t[i].start();
		}
		
	}
}


class LRUTest implements Runnable
{
	LRU lru;
	
	public LRUTest(LRU l)
	{
		lru = l;
	}
	@Override
	public void run()
	{
		for(int i = 0; i < 1000000; i++)
		{
			Random rand = new Random();
			int n = rand.nextInt(10);
			lru.get(n);
			//lru.print();
		}
	}
}