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


class Singleton2
{
    private static Singleton2 instance;
    
    private Singleton2()
    {
        // initialize
    }
    
    public static synchronized Singleton2 getInstance()
    {
        if(instance == null)
        {
            instance = new Singleton2();
        }
        
        return instance;
    }
}


class Singleton3
{
    private static Singleton3 instance;
    
    private Singleton3()
    {
        // initialize
    }
    
    public static synchronized Singleton3 getInstance()
    {
        if(instance == null)
        {
            synchronized(Singleton3.class)
            {
            	if(instance == null)
            	{
            		instance = new Singleton3();
            	}
            }
        }
        
    return instance;  
    }
}
