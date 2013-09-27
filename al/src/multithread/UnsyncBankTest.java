package multithread;

public class UnsyncBankTest {

	public final static int NACCOUNTS = 50;
	public final static double INITIAL_BALANCE = 100;
	
	public static void main(String[] args)
	{
		Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
		
		for(int i = 0; i < NACCOUNTS; i++)
		{
			TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
		
	}
}
