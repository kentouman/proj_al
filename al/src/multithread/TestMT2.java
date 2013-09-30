package multithread;

import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

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

		Semaphore binary = new Semaphore(2);
		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
		HashSet<Integer> s = new HashSet<Integer>();
			 
		/*
		for(int i = 0; i < 10; i++)
		{
			Thread r1 = new Thread(new Producer(sharedQueue));
			Thread r2 = new Thread(new Consumer(sharedQueue));
			
			r1.start();
			r2.start();
		}
		*/
		
		DeadLockTest dlt = new DeadLockTest();

		/*
		for(int i = 0; i < 2; i ++)
		{
			Thread r = new Thread(dlt);
			r.start();
		}
		*/

	

	}
}

class Task implements Runnable
{
	@Override
	public void run()
	{
		System.out.println("Thread - " + Thread.currentThread().getId());
	}
}

class Producer implements Runnable
{
    private final BlockingQueue<Integer> sharedQueue;

    public Producer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

	@Override
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			try
			{
				System.out.println("Thread - " + Thread.currentThread().getId() + " now producing " + i);
				sharedQueue.put(i);
			}
			catch(InterruptedException ex)
			{
			}
		}
	}
}

class Consumer implements Runnable
{
    private final BlockingQueue<Integer> sharedQueue;

    public Consumer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

	@Override
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			try
			{
				System.out.println("Thread - " + Thread.currentThread().getId() + " now taking " + i);
				sharedQueue.take();
			}
			catch(InterruptedException ex)
			{
			}
		}
	}
}

class SemaphoreTest implements Runnable
{
	Semaphore sem;
	
	SemaphoreTest(Semaphore s)
	{
		this.sem = s;
		
	}
	
	@Override
	public void run()
	{
		System.out.println("Thread - " + Thread.currentThread().getId() + "Started now");
		try
		{
			Thread.sleep(1000);
			sem.acquire();
			System.out.println("Thread - " + Thread.currentThread().getId() + " entering critical region");
			Thread.sleep(1000);
			System.out.println("Thread - " + Thread.currentThread().getId() + " leaving critical region");
		}
		catch(InterruptedException ex)
		{
		}
		finally
		{
			sem.release();
		}
	}
}

class DeadLockTest implements Executor
{
	ReentrantLock lock1;
	ReentrantLock lock2;
	
	
	public DeadLockTest()
	{
		 lock1 = new ReentrantLock();
		 lock2 = new ReentrantLock();
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			Random rand = new Random();

			if(rand.nextFloat() > 0.5)
			{
				method1();
			}
			else
			{
				method2();
			}
		}
	}
	
	public void method1()
	{
		lock1.lock();

		System.out.println("Thread - " + Thread.currentThread().getId() +" get lock1 in method1" );
		lock2.lock();
		System.out.println("Thread - " + Thread.currentThread().getId() +" get lock2 in method1" );

		lock2.unlock();
		System.out.println("Thread - " + Thread.currentThread().getId() +" release lock2 in method1" );

		lock1.unlock();
		System.out.println("Thread - " + Thread.currentThread().getId() +" release lock1 in method1" );

	}
	
	public void method2()
	{
		lock2.lock();

		System.out.println("Thread - " + Thread.currentThread().getId() +" get lock2 in method2" );
		lock1.lock();
		System.out.println("Thread - " + Thread.currentThread().getId() +" get lock1 in method2" );

		lock1.unlock();
		System.out.println("Thread - " + Thread.currentThread().getId() +" release lock1 in method2" );

		lock2.unlock();
		System.out.println("Thread - " + Thread.currentThread().getId() +" release lock2 in method2" );
		
	}
	@Override
	public void execute(Runnable command) {
		// TODO Auto-generated method stub
		
	}
	
}
