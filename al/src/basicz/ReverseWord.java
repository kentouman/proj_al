package basicz;

public class ReverseWord {
	public void reverse(char[] input)
	{
		boolean fhead, ftail;
		fhead=false;
		ftail=false;
		
		int head, tail;
		head = 0;
		tail = 0;
		
		for(int i = 0; i < input.length; i++)
		{
			if(!fhead)
			{
				if(input[i] == ' ')
				{
					continue;
				}
				else
				{
					fhead = true;
					head = i;
				}
			}
			
			else if(!ftail)
			{
				if(input[i] == ' ')
				{
					ftail = true;
					tail = i - 1;
				}
				else
				{
					continue;
				}
			}
			
			if(ftail)
			{
				int len = (tail - head) / 2;
				for(int j = 0; j < len; j++)
				{
					char temp = input[head + j];
					input[head + j] = input[tail - j];
					input[tail - j] = temp;
				}
				fhead = false;
				ftail= false;
			}
			
		}
		
		if(fhead)
		{
			tail = input.length - 1;
			int len = (tail - head) / 2;
			for(int j = 0; j < len; j++)
			{
				char temp = input[head + j];
				input[head + j] = input[tail - j];
				input[tail - j] = temp;
			}
		}
		
	}
	
	public static void main(String[] args)
	{
		ReverseWord a = new ReverseWord();
		String b = "   Hello World     happy birthday   ";
		char[] input = b.toCharArray();
		System.out.println(input);
		a.reverse(input);
		System.out.println();
		System.out.println(input);
	}
}
