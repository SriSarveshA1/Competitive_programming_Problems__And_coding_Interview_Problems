import java.util.Scanner;

public class A_Add_and_Divide
{
    static int fu(int a,int b,int count)
    {
           if(b==1)
           {
               if(a%2!=0)
               {
                   count++;
                   b=b+1;

               }
               if(a<b)
               {
                   count++;
                   b=b+1;
                   return count;
               }
               count++;
               b=b+1;
               count++;
               a=Math.floorDiv(a, b);
               System.out.println("a= "+a+" b= "+b+" count= "+count);
               count=fu(a,b,count);
           }
           else{
               if(a>b&&b!=1)
               {
                   
                   count++;
                   a=Math.floorDiv(a, b);
                   System.out.println("a= "+a+" b= "+b+" count= "+count);
                   count=fu(a, b, count);
               }
               else{
                   if(a==b)
                   {
                     count++;
                     b=b+1;
                     System.out.println("a= "+a+" b= "+b+" count= "+count);
                    
                   }
                   else{
                       if(a<b)
                       {
                           count++;
                           System.out.println("a= "+a+" b= "+b+" count= "+count);
                           
                       }
                   }
               }
           }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int q=0;q<t;q++)
        {
            int a=in.nextInt();
            int b=in.nextInt();
            int count=0;
            System.out.println(fu(a,b,count));
            
            
          
        }

        
    }
}