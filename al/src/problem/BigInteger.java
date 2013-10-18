package problem;

import java.util.Arrays;

public class BigInteger
{

    private int[] atoi(String s)
    {
        int len = s.length();
        int[] result = new int[len];
        for(int i = 0; i < s.length(); i++)
        {
            result[i] = (int)(s.charAt(len - 1 -i) - '0');
        }
        return result;
    }

    private String itoa(int[] a)
    {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < a.length; i++)
        {
            sb.append((char)('0' + a[i]));
        }
        int start = 0;
        if(sb.charAt(sb.length() - 1) == '0')
        {
            start = 1;
        }
        return sb.reverse().substring(start, sb.length());
    }

    public String add(String a, String b)
    {
        return itoa(add(atoi(a), atoi(b)));
    }

    public int[] add(int[] a, int[] b)
    {
        if(a.length < b.length)
        {
            return add(b, a);
        }

        int len = a.length + 1;
        int[] result = new int[len];

        for(int i = 0; i < b.length; i++)
        {
            result[i] = a[i] + b[i];
        }
        for(int i = b.length; i < a.length; i++)
        {
            result[i] = a[i];
        }

        for(int i = 0; i < len - 1; i++)
        {
            if(result[i] >= 10)
            {
                result[i] -= 10;
                result[i+1] += 1;
            }
        }

        return result;
    }

    public String multiply(String a, String b)
    {
        return itoa(multiply(atoi(a), atoi(b)));
    }

    public int[] multiply(int[] a, int[] b)
    {
        int lenA = a.length;
        int lenB = b.length;
        int len = lenA + lenB;
        int[] result = new int[len];

        for(int i = 0; i < lenA; i++)
        {
            for(int j = 0; j < lenB; j++)
            {
                result[i+j] += a[i] * b[j];
            }
        }


        for(int i = 0; i < len - 1; i++)
        {
            result[i+1] += result[i] / 10;
            result[i] %= 10;
        }

        return result;

    }

    public static void main(String[] args)
    {
        BigInteger z = new BigInteger();
        if(args.length < 2) 
        {
            System.out.println("need two numbers");
            return;
        }
        String a = args[0]; 
        String b = args[1];
        String r = z.multiply(a, b);
        System.out.println(a + " + " + b + " = " + r);
    }

}
