package multithread;

public class TransferRunnable implements Runnable{

	public TransferRunnable(Bank b, int from, double max)
	{
		bank = b;
		fromAccount = from;
		maxAmount = max;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try
		{
			while(true)
			{
				int toAccount = (int)(bank.size() * Math.random());
				double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((int)(DELAY * Math.random()));
			}
		}
		catch(InterruptedException e)
		{
			
		}
		
	}
	
	Bank bank;
	int fromAccount;
	double maxAmount;
	private int DELAY = 10;
}
