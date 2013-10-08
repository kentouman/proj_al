package basicz;

import java.io.*;
import java.util.*;

enum WordState 
{
	WORD, 
	SPACE,
}

public class WordStat
{    
    public ArrayList<String> getWordList(FileInputStream fin) throws IOException
    {
        ArrayList<String> result = new ArrayList<String>();
        InputStream in = fin;
        StringBuffer word = new StringBuffer();
        
        WordState state = WordState.SPACE;
        
        while(in.available() > 0)
        {
            char c = (char)in.read();
            
            if(state == WordState.WORD)
            {
                if(c != ' ')
                {
                    word.append(c);
                }
                else
                {
                    result.add(word.toString());
                    state = WordState.SPACE;
                    word = new StringBuffer();
                }
            }
            else if(state == WordState.SPACE)
            {
                if(c != ' ')
                {
                    state = WordState.WORD;
                    word.append(c);
                }
            }
        }
        
        if(word.length() > 0)
        {
            result.add(word.toString());
        }
        
        return result;
    }

    public HashMap<String, Integer> getWordCount(ArrayList<String> wordList)
    {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
    
        for(String s: wordList)
        {
            if(map.containsKey(s))
            {
                map.put(s, map.get(s) + 1);
            }
            else
            {
                map.put(s, 1);
            }
        }
        
        return map;
    }
    
    public ArrayList<String> getTopList(HashMap<String,Integer> wordCount, int k)
    {
        ArrayList<String> result = new ArrayList<String>();
        WordMinHeap heap = new WordMinHeap(k);
        
        for(String s : wordCount.keySet())
        {
            heap.add(new Word(s, wordCount.get(s)));
        }
        
        for(int i = 0; i < k; i++)
        {
            result.add(heap.poll().word);
        }
        
        return result;
    }

    public static void main(String[] args)
    {
        WordStat ws = new WordStat();
    
        FileInputStream file;
		try {
			file = new FileInputStream("c:\\example.txt");
			
	        ArrayList<String> wordList = ws.getWordList(file);
	        HashMap<String, Integer> wordCount = ws.getWordCount(wordList);
	        ArrayList<String> topWordList = ws.getTopList(wordCount, 10);
	        
	        int rank = 10;
	        for(String s: topWordList)
	        {
	            System.out.println("#" + rank + ": " + s);
	            rank--;
	        }
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        
    }
}



class Word
{
    String word;
    int cnt;
    
    public Word(String s, int k)
    {
        word = s;
        cnt = k;
    }
    
    public Word()
    {
        this("dummy", 0);
    }
    
    public boolean compare(Word w)
    {
        return (cnt > w.cnt);
    }
}

class WordMinHeap
{
    Word[] heap;
    int size;
    
    public WordMinHeap(int k)
    {
    	size = k;
        heap = new Word[size];
        for(int i = 0; i < size; i++)
        {
        	heap[i] = new Word("dummy", 0);
        }
    }
    
    public void update()
    {
        //sift down
        int index = 0;
        
        while(index * 2 + 1 < size)
        {
            if(index * 2 + 2 < size)
            {
                int tempIndex = heap[2 * index + 1].compare(heap[2 * index + 2]) ? index * 2 + 2 : index * 2 + 1;
                if(heap[index].compare(heap[tempIndex]))
                {
                    Word temp1 = heap[index];
                    heap[index] = heap[tempIndex];
                    heap[tempIndex] = temp1;
                    index = tempIndex;
                }
                else
                {
                	break;
                }
            }
            else
            {
                if(heap[index].compare(heap[2 * index + 1]))
                {
                    Word temp1 = heap[index];
                    heap[index] = heap[2 * index + 1];
                    heap[2 * index + 1] = temp1;
                    index = 2 * index + 1;
                }
                else
                {
                	break;
                }
            }
        }
    }
    
    public void add(Word e)
    {
        if(e.compare(heap[0]))
        {
            heap[0] = e;
            update();
        }
    }
    
    public Word poll()
    {
        Word e = heap[0];
        heap[0] = heap[size - 1];
        size--;
        
        update();
        
        return e;
    }
}
