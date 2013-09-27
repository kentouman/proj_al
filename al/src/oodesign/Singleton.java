package oodesign;

public class Singleton {
	
	private static Singleton instance;

	public Singleton()
	{
		
	}
	
	public static Singleton getInstance()
	{
		if(instance == null)
		{
			synchronized(Singleton.class)
			{
				if(instance == null)
				{
					instance = new Singleton();
				}
			}
		}
		
		return instance;
	}
	
	public void print()
	{
		System.out.println("Hello yoho!");
	}
	
	public static void main(String[] args)
	{
		Singleton.getInstance().print();
	}
}
