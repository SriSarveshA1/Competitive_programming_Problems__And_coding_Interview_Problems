import java.util.Scanner;

public class Even_Differences {
    static boolean isEven(int num)
    {
        if(num<0)
        {
            num=num*-1;
            if(num%2==0)
            {
                return true;
            }
        }
        if(num%2==0)
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
           int n=in.nextInt();
           int[] a=new int[n];
           for(int i=0;i<a.length;i++)
           {
               a[i]=in.nextInt();
           }
           if(a.length==1)
           {
               if(a[0]%2==0)
               {
               System.out.println(0);
               }
               else{
               System.out.println(1);
               }
           }
           else
           {
               if(a.length==2)
               {
                   if(((a[0]%2==0)&&(a[1]%2==0))||((a[0]%2!=0)&&(a[1]%2!=0)))
                   {
                    System.out.println(0);
                   }
                   else{
                   System.out.println(1);
                   }
               }
               else
               {
                int i=0;
           
                int j=i+1;
                int count=0;
                
                while(i<n&&j<n)
                {
                    if(((a[i]%2==0)&&(a[j]%2==0))||((a[i]%2!=0)&&a[j]%2!=0))
                    {
                        i++;
                        j++;
                    }
                    else{
                        a[j]=a[j]+1;
                        count++;
                        
                            i++;
                            j++;
                        }
                    
     
                }
                System.out.println(count);
               }
           }
       }
 
    }

}