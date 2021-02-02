import java.util.Scanner;

public class Distinct_Pair_Sums {
    static int nCr(int n, int r) 
{ 
    return fact(n) / (fact(r) * 
                  fact(n - r)); 
} 
  

static int fact(int n) 
{ 
    int res = 1; 
    for (int i = 2; i <= n; i++) 
        res = res * i; 
    return res; 
} 
  
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int q=0;q<t;q++)
        {
            int L=in.nextInt();
            int R=in.nextInt();
            
        int length=(R-L)+1;
        System.out.println(length);
        int count=0;
        if(L==R)
        {
            count=1;
           
        }
        else{
            count=length;
            count+=nCr(length, 2);
        }
        System.out.println(count);
       
       
   
            

        }
    }
}