import java.sql.Date;
import java.util.Scanner;
public class qw {
    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
       int T=sc.nextInt();
       for(int i=0;i<T;i++)
       {
           int N=sc.nextInt();
           int[] m=new int[N];
           for(int j=0;j<N;j++)
           {
             m[j]=sc.nextInt();
           }
           if(m.length==1)
           {
               System.out.println(m[0]);
           }
           else{
               System.out.print(m[0]+" "+m[N-1]);
           }
       }
       
    }
}
