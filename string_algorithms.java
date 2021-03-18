public class string_algorithms {
    int expand(String str,int l,int r)
    {
        while(l>=0&&r<str.length()&&str.charAt(l)==str.charAt(r))
        {
         l--;
         r++;
        }
        return (r-l)-1;
    }
    public String longestPalindrome(String str) {
        int start=0;
        int end=0;
        for(int i=0;i<str.length();i++)
        {
            int len1=expand(str,i,i);
            int len2=expand(str,i,i+1);
            int curlength=Integer.max(len1,len2);
            if(curlength>end-start)
            {
             start=i-(curlength-1)/2;
             end=i+(curlength)/2;
                
            }
            
        }
        return str.substring(start,end+1);
    }
}
