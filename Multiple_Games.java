import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.*;

public class Multiple_Games {
    static class pair {
        int first;
        int second;

        pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int er=0;er<t;er++)
        {
            int n,q,m;
            n=in.nextInt();
            q=in.nextInt();
            m=in.nextInt();
            int[] a= new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=in.nextInt();
            }
            int[] b=new int[1000001];
            int[] ans=new int[m+1];
            HashMap<pair,Integer> m1=new HashMap<>();
            for(int e=0;e<q;e++)
            {
                int l,r;
                l=in.nextInt();
                r=in.nextInt();
                l--;
                r--;
                if(a[l]>m)
                {
                    continue;
                }
                else{
                    if(a[l]<=m && a[r]>m)
                    {
                        b[a[l]]++;
                        b[m+1]--;
                    }
                    else{
                        if(a[r]<=m)
                        {
                        b[a[l]]++;
                        b[m+1]--;
                        m1.put(new pair(a[l],a[r]),m1.get(new pair(a[l],a[r]))==null?1:m1.get(new pair(a[l],a[r]))+1);
                        }
                        
                    }

                }
            }
              for(Entry<pair, Integer> x:m1.entrySet())
             {

                int k=x.getKey().first,p=x.getKey().second,l=x.getValue();
                b[p+k]-=l;
                b[p+2*k]+=l;
                int c=p+2*k;
                while(c+p<=m)
                {
                c+=p;
                b[c]-=l;
                b[c+k]+=l;
                c+=k;
                 }        
              }
          for(int i=1;i<=m;i++)
          {

            b[i]+=b[i-1];
          }

         int maxx=0;

          for(int i=0;i<=m;i++)
          {
           maxx=Integer.max(b[i],maxx);

          }
          System.out.println(maxx);


        }
    }
}