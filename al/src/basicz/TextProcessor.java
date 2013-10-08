package basicz;

//You have a text file, read it, and return the most frequent word. 
//for example a textfile like this
//"hello world how are you I am fine and you"
//the returned item should be "you" since it appeared twice

//you can assume that the text file has all words (no 标点符号) and are separated by 1 or more spaces
//you can assume that all the characters are non-captital.

//hint : you may want to check FileReader and FileWriter class from java library
import java.io.*;
import java.util.*;

public class TextProcessor{ 

 public String findWord(String fileName){
     FileReader r = null;
     String maxString =null;
     try{
         r=new FileReader(fileName);
         int n;
         StringBuffer sb=new StringBuffer();
         boolean start=false;
         
         char c;
         HashMap<String,Integer> map= new HashMap<String, Integer>();
         
         int count;
         while ((n=r.read())!= -1){
             c= (char)n;
             if (c!=' '){
                 if ( start==false){
                     start =true;
                 }
                 sb.append(c);
             }
             else if (c==' '){
                 if (start==true ){
                 
                     String s=sb.toString();
                     sb=new StringBuffer();
                     if (map.containsKey(s)){
                         count =map.get(s)+1;
                         map.put(s, count);
                     }
                     else {
                         count=1;
                         map.put(s,count);
                     }
                     start=false;
                 }
             }
             
                  
         }
         
         String s=sb.toString();
         if (s.length()>0){
             if (map.containsKey(s)){
                 count =map.get(s) + 1;
                 map.put(s, count);
             }
             else {
                 count=1;
                 map.put(s,count);
             }
         }
         int max=0;
         for (String s2: map.keySet()){
             if (max<map.get(s2)){
                 max= map.get(s2);
                 maxString = s2;
             }
         }
         
     }
     catch(IOException e)
     {
         System.out.println("exception happened");
     }


     return maxString;
     
 }
 
 public static void main(String[] args){
 
     TextProcessor t = new TextProcessor();
     System.out.println(t.findWord("c:\\sisi.txt"));
 }
}
