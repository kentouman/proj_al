package multithread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintSequence {

	public static void main(String[] args)
	{
		int[] input = {1,2,3,4,5,6,7};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < input.length; i++)
		{
			list.add(input[i]);
		}
		Iterator<Integer> iter = list.iterator();
		
		IntPrinter printer = new IntPrinter(iter);
		PrinterRunnalbe a = new PrinterRunnalbe(printer);
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(a);
		Thread t3 = new Thread(a);
		t1.start();
		t2.start();
		t3.start();
	}
}



class IntPrinter
{
	public Iterator<Integer> iter;
	
	public IntPrinter(Iterator<Integer> iter)
	{
		this.iter = iter;
	}
	
	public synchronized Integer print()
	{
		Integer result = null;
		if(iter.hasNext())
		{
			result = iter.next();
		}
		return result;
	}
}

class PrinterRunnalbe implements Runnable
{
	public IntPrinter printer;
	
	public PrinterRunnalbe(IntPrinter printer)
	{
		this.printer = printer;
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
				
	}
	
	public synchronized void printing() throws InterruptedException
	{
		while(true)
		{
			Integer n = printer.print();
			if(n == null)
			{
				System.out.println("Thread #" + Thread.currentThread().getId() + "Exiting...");
				notify();
				break;
			}
			else
			{
				int m = n;
				System.out.println("Thread #" + Thread.currentThread().getId() + m);
				notify();
			}
			wait();
		}
	}
}