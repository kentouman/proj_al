package leetcode;

import java.util.Stack;

public class TestRun {
	

	public static void main(String[] args)
	{
		TestRun a = new TestRun();
		
		String c = a.simplifyPath("/.hidden");
		System.out.println(c);
	}
	
	public String simplifyPath(String path) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        String[] list = path.split("/+");
        for(int i = 1; i < list.length; i++)
        {
        	System.out.println(list[i]);
        }
        Stack<String> result = new Stack<String>();
        
        for(int i = 1; i < list.length; i++)
        {
            if(list[i].equals(".."))
            {
            	if(!result.isEmpty())
            		result.pop();
            }
            else if(list[i].equals("."))
            {
            
            }
            else
            {
                result.push(list[i]);
            }
        }
        
        Stack<String> reverseList = new Stack<String>();
        while(!result.isEmpty())
        {
            reverseList.push(result.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!reverseList.isEmpty())
        {
            sb.append("/");
            sb.append(reverseList.pop());
        }
        
        if(sb.length() == 0)
        {
            return "/";
        }
        return sb.toString();
    }
    
}