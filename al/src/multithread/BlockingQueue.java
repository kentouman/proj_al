package multithread;

import java.util.ArrayDeque;

public class BlockingQueue<T> {
	ArrayDeque<T> queue = new ArrayDeque<T>();
	
	public synchronized void enqueue(T t)
	{
		queue.add(t);
		notifyAll();
	}
	
	public T dequeue() throws InterruptedException
	{
		if(queue.isEmpty())
		{
			wait();
		}
		
		return queue.remove();
	}
}
