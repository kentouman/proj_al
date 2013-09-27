package problem;

public class MyInfluencerFinder
{

    /**
     * will check a pair in this group of N people.
     *    if A follows B, A is not an influncer;
     *    otherwise, B is not.
     */
    public int getInfluencer(boolean[][] followingMatrix)
    {

        // check if there no one in this matrix
        if(followingMatrix.length == 0)
        {
            return -1;
        }
        
        int i = 0;
        int j = followingMatrix.length - 1;
        

        
        while(i < j)
        {
            if(followingMatrix[i][j])
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        
        // now get to a possible influencer
        // first check if he knows anyone
        for(int k = 0; k < followingMatrix.length; k++)
        {
            if(followingMatrix[i][k])
            {
                return -1;
            }
        }
        //then check if anyone knows him
        for(int k = 0; k < followingMatrix.length; k++)
        {
            if((!followingMatrix[k][i]) && (k != i))
            {
                return -1;
            }
        }        
        
        return i;
    }
    
    static public void test()
    {
        boolean[][] m1 = {};
        // in m2, there is no influencer
        boolean[][] m2 = {{true,true},{true,true}};
        // in m3, say person #0 is the influencer
        boolean[][] m3 = {{false, false, false}, {true,false,false},{true, false, false}};
        
        MyInfluencerFinder finder = new MyInfluencerFinder();
        
        int result1 = finder.getInfluencer(m1);
        int result2 = finder.getInfluencer(m2);
        int result3 = finder.getInfluencer(m3);
        
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    
    public static void main(String[] args)
    {
    	test();
    }
}