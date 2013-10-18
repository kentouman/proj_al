package sort;

import java.io.*;
import java.util.*;

public class SortBig
{
    public void generateRandomToFile(String filePath) throws IOException
    {
        PrintWriter outputStream = null;

        try
        {
            outputStream = new PrintWriter(new FileWriter(filePath));
            Random rand = new Random();

            for(int i = 0; i < 2000000; i++)
            {
                outputStream.println(rand.nextInt());   
            }
        }
        finally
        {
            if(outputStream != null)
            {
                outputStream.close();
            }
        }

    }


    public void splitFile(String filePath, int line) throws IOException
    {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try
        {
            inputStream = new BufferedReader(new FileReader(filePath));
            int cnt = 0;
            boolean isEOF = false;

            while(!isEOF)
            {
                
                String curFile = filePath + "_" + cnt;
                String cur = null;
                outputStream = new PrintWriter(new FileWriter(curFile));
                
                for(int i = 0; i < line; i++)
                {
                    if((cur = inputStream.readLine()) != null)
                    {
                        outputStream.println(cur);
                    }
                    else
                    {
                        isEOF = true;
                    }
                }
                
                outputStream.close(); 
                cnt++;

            }

        }
        finally
        {
            if(inputStream != null)
            {
                inputStream.close();
            }
            
            if(outputStream != null)
            {
                outputStream.close();
            }
        }
    }


    public void feedBuffer(BufferedReader br, int line, int[] array) throws IOException
    {
        for(int i = 0; i < line; i++)
        {
            array[i] = Integer.parseInt(br.readLine());
        }
    }
   
    public void mergeSortedFiles(ArrayList<String> filePathList, int line) throws IOException
    {
        PrintWriter outputStream = null;
        int k = filePathList.size();
        boolean isEnd = false;

        ArrayList<BufferedReader> inputStreamList = new ArrayList<BufferedReader>();
        
        try
        {
            for(String s : filePathList)
            {
            }

            while(!isEnd)
            {
            }


        }
        finally
        {
            for(BufferedReader br : inputStreamList)
            {
                if(br != null)
                {
                    br.close();
                }
            }
            if(outputStream != null)
            {
                outputStream.close();
            }
        }

    }

    public String sortFile(String filePath) throws IOException
    {
        int lines = 0;

        String outputFilePath = "sorted_" + filePath;
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try
        {
            inputStream = new BufferedReader(new FileReader(filePath));
            String s = null;
            while((s = inputStream.readLine()) != null)
            {
                lines++;
            }

            int[] array = new int[lines];
            inputStream = new BufferedReader(new FileReader(filePath));
            for(int i = 0; i < lines; i++)
            {
                array[i] = Integer.parseInt(inputStream.readLine());
            }

            Arrays.sort(array);

            outputStream = new PrintWriter(new FileWriter(outputFilePath));
            for(int i = 0; i < lines; i++)
            {
                outputStream.println(array[i]);
            }

        }
        finally
        {
            if(inputStream != null)
            {
                inputStream.close();
            }
            if(outputStream != null)
            {
                outputStream.close();
            }
        }

        return outputFilePath;
    }



    public static void main(String[] args)
    {
        SortBig z = new SortBig();

        String filePath = "testfile";
        try
        {
           z.generateRandomToFile(filePath);
           z.splitFile(filePath, 200000);
        }
        catch(IOException e)
        {
            System.out.println("exception :(");
        }
    }
}
