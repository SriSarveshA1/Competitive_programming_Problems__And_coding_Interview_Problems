import java.util.HashMap;
import java.util.Scanner;

public class A_Nezzar_and_Colorful_Balls
{
    public static void main(String[] args)
    {
       Scanner in=new Scanner(System.in);
       int t=in.nextInt();
       for(int ty=0;ty<t;ty++)
       {
           int cnt=0;
           int element=-1;
           int n=in.nextInt();
           int[] a=new int[n];
           for(int i=0;i<n;i++)
           {
               a[i]=in.nextInt();
           }
           int maxcount=Integer.MIN_VALUE;
           HashMap<Integer,Integer> hm=new HashMap<>();
           for(int i=0;i<n;i++)
           {
               if(hm.get(a[i])==null)
               {
                hm.put(a[i], 1);
               }
               else{
                   hm.put(a[i], hm.get(a[i])+1);
               }
              
               //maxcount=Integer.max(maxcount,cnt);
           }
           
           int max=hm.get(a[0]);
           for(int i=1;i<n;i++)
           {
               int curmax=hm.get(a[i]);
               max=Integer.max(curmax, max);

           }
           System.out.println(max);
       }
       
    }
}