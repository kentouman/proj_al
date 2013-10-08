package multithread;

public class ReadWriteLock {
	public int readers;
	public int writers;
	public int writeRequest;
	
	
	
	public synchronized void readLock() throws InterruptedException
	{
		
		while(writeRequest > 0 || writers > 0)
		{
			wait();
		}
		readers++;
	}
	
	public synchronized void readUnlock()
	{
		readers--;
		notifyAll();
	}	
	
	public synchronized void writeLock() throws InterruptedException
	{
		
		writeRequest++;
		
		while(writers > 0 || readers > 0)
		{
			wait();
		}
		
		writeRequest--;
		writers++;
	}	
	
	public synchronized void writeUnlock()
	{
		writers--;
		notifyAll();
	}
}
