package multithread;

public class MySemaphore {
	private int counter;
	
	public MySemaphore(int cnt)
	{
		counter = cnt;
	}
	
	public synchronized void aquire() throws InterruptedException
	{
		while(counter <= 0)
		{
			wait();
		}
		
		counter--;
	}
	
	public synchronized void release()
	{
		counter++;
		notifyAll();
	}
	
	public static void main(String[] args)
	{
		MySemaphore s = new MySemaphore(1);
		MySemaphoreTest t= new MySemaphoreTest(s);
		
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start();
		t2.start();
	}
}

class MySemaphoreTest implements Runnable
{
	private int cnt;
	private MySemaphore sem;
	
	public MySemaphoreTest(MySemaphore s)
	{
		sem = s;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			try {
				sem.aquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cnt++;
			System.out.println("Thread #" + Thread.currentThread().getId() + " : " + cnt);
			sem.release();
		}
	}
}