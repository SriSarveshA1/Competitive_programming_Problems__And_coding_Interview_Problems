public class kmp_algorithm {
    public static int[] compute_lps(char[] pattern)
    {
        
        int i=1;
        int j=0;
        int[] lps=new int[pattern.length];
        lps[0]=0;
        while((i<pattern.length)&&(j<pattern.length))
        {
             if(pattern[i]!=pattern[j])
             {
                 lps[i]=j+1;
                 i++;
                 j++;
             }
             else{
                 if(j!=0)
                 {
                    j= lps[j-1];
                 }
                 else{
                     lps[i]=0;
                     i++;
                 }
             }
        }
        return lps;
    }
    public static boolean kmp(char[] txt,char[] pattern)
    {
        int[] lps=compute_lps(pattern);
        int i=0,j=0;
        while(i<txt.length&&j<pattern.length)
        {
            if(txt[i]==pattern[j])
            {
                i++;
                j++;
            }
            else
            {
                if(j!=0)
                {
                    j=lps[j-1];
                }
                else
                {
                    i++;
                }
            }
        }
        if(j==pattern.length)
        {
            return true;
        }
        
            return false;
    

    }
public static void main(String[] args)
{
    String txt= "AAAAABAAABA" ;
    String pat=  "AwAA";
    System.out.println(kmp(txt.toCharArray(),pat.toCharArray()));
}
}
