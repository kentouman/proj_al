package multithread;

public class H2O {
	public static void main(String[] args)
	{
		H2OObject in = new H2OObject();
		HProducer htest = new HProducer(in);
		OProducer otest = new OProducer(in);
		
		Thread t1 = new Thread(htest);
		Thread t2 = new Thread(otest);
		Thread t3 = new Thread(otest);
		Thread t4 = new Thread(htest);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}

class H2OObject
{
	private int h;
	private int o;
	private int h2o;
	
	public H2OObject()
	{
		h = 0;
		o = 0;
		h2o = 0;
	}
	
	public synchronized void create(boolean isH) throws InterruptedException
	{
		if(isH)
		{
			createH();
		}
		else
		{
			createO();
		}
	}
	
	public synchronized void  createH() throws InterruptedException
	{
		while(h2o > 0)
		{
			wait();
		}
		
		h++;
		System.out.println("Thread #" + Thread.currentThread().getId() + " Producing H... h:" + h + " o:" + o);

		while(!(h >= 2 && o >= 1))
		{
			wait();
			if(h2o == 2 || h2o == 3 || h2o == 6)
			{
				break;
			}
		}
		System.out.println("Thread #" + Thread.currentThread().getId() + "Get out!");
		if(h2o == 0)
		{
			h2o = 3;
			System.out.println("Thread #" + Thread.currentThread().getId() + " Finished H2O.. h:" + h + " o:" + o + " h2o:"+h2o);
			System.out.println("Thread #" + Thread.currentThread().getId() + " Exiting....");
			notifyAll();
		}
		
		else
		{
			if(h2o == 6)
			{
				h2o = 2;
			}
			else if(h2o == 3)
			{
				h2o = 1;
			}
			else if(h2o == 2)
			{
				h2o = 0;
				h = h - 2;
				o = o - 1;
			}
			else
			{
				throw new NullPointerException("Wtf?" + Thread.currentThread().getId());
			}
			System.out.println("Thread #" + Thread.currentThread().getId() + " Finished H2O next.. h:" + h + " o:" + o + " h2o:"+h2o);
			System.out.println("Thread #" + Thread.currentThread().getId() + " Exiting....");
			notifyAll();
		}
	}
	
	public synchronized void createO() throws InterruptedException
	{
		while(h2o > 0)
		{
			wait();
		}
		o++;
		System.out.println("Thread #" + Thread.currentThread().getId() + " Producing O... h:" + h + " o:" + o);		

		while(!(h >= 2 && o >= 1))
		{
			wait();
			if(h2o == 3 || h2o == 1)
			{
				break;
			}
		}
		System.out.println("Thread #" + Thread.currentThread().getId() + "Get out!");
				
		if(h2o == 0)
		{
			h2o = 6;
			System.out.println("Thread #" + Thread.currentThread().getId() + " Finished H2O.. h:" + h + " o:" + o + " h2o:"+h2o);
			System.out.println("Thread #" + Thread.currentThread().getId() + " Exiting....");
			notifyAll();
		}
		
		else
		{
			if(h2o == 3)
			{
				h2o = 2;
			}
			else if(h2o == 1)
			{
				h2o = 0;
			}
			else
			{
				throw new NullPointerException("Wtf?" + Thread.currentThread().getId());
			}
			System.out.println("Thread #" + Thread.currentThread().getId() + " Finished H2O next.. h:" + h + " o:" + o + " h2o:"+h2o);
			System.out.println("Thread #" + Thread.currentThread().getId() + " Exiting....");

			notifyAll();
		}
	}
}

class HProducer implements Runnable
{
	H2OObject hP;
	
	public HProducer(H2OObject instance)
	{
		hP = instance;
	}
	
	@Override
	public void run()
	{
		try {
			hP.create(true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class OProducer implements Runnable
{
	H2OObject oP;
	
	public OProducer(H2OObject instance)
	{
		oP = instance;
	}
	
	@Override
	public void run()
	{
		try {
			oP.create(false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}