import java.util.HashSet;
import java.util.Scanner;

public class Pair_Me {
    static boolean fucn(int a,int b,int c)
    {
        if(a==(b+c))
        {
            return true;
        }
        if(b==(a+c))
        {
            return true;
        }
        if(c==(a+b))
        {
            return true;
        }
         return false;
    }
    public static void main(String[] args)
    {
      Scanner in=new Scanner(System.in);
      int t=in.nextInt();
      for(int qe=0;qe<t;qe++)
      {
          int x=in.nextInt();
          int y=in.nextInt();
          int z=in.nextInt();
          if(fucn(x, y, z)==true)
          {
              System.out.println("YES");
          }
          else{
            System.out.println("NO");
          }
         
        
        
        
        }
          
      }
    }
