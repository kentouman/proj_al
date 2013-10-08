package oodesign;

import java.util.ArrayList;

public class FactoryMethod {

	public static void main(String[] args)
	{
		ArrayList<Product> list = new ArrayList<Product>();
		Creator c1 = new ConcreteCreator1();
		Creator c2 = new ConcreteCreator2();
		
		Product p1 = c1.create();
		Product p2 = c2.create();
		
		list.add(p1);
		list.add(p2);
		p1.print();
		p2.print();
		
		for(Product p : list)
		{
			System.out.println(p.getClass().getName());
		}
	}
}


abstract class Creator
{
	protected abstract Product create();
}

class ConcreteCreator1 extends Creator
{
	protected Product create()
	{
		return new ConcreteProduct1();
	}
}

class ConcreteCreator2 extends Creator
{
	protected Product create()
	{
		return new ConcreteProduct2();
	}
}


interface Product
{
	public void print();
}

class ConcreteProduct1 implements Product
{
	int val;
	
	public ConcreteProduct1()
	{
		val = 1;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("I am product #1");
	}
}

class ConcreteProduct2 implements Product
{
	int val;
	
	public ConcreteProduct2()
	{
		val = 2;
	}
	
	@Override
	public void print()
	{
		System.out.println("I am product #2");
	}
}