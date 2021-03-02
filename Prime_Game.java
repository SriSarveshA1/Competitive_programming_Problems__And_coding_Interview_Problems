import java.util.Arrays;
import java.util.Scanner;

public class Prime_Game
{
    static boolean[] prime_sieve(boolean[] prime)
    {
       //Initially all the elements will be marked as 0 which is not prime
       for (int p = 2; p * p <= 1000001; p++) { 
		if (prime[p] == true) { 
			for (int i = p * 2; i <= 1000001; i += p) 
            {
				prime[i] = false; 
            }
		} 
	   } 
       return prime;
    }
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        boolean[] p=new boolean[1000005];
        Arrays.fill(p, true);
        p=prime_sieve(p);
       
        int[] c=new int[1000001];
        c[0]=0;
        c[1]=0;
        int count=0;
        for(int i=2;i<=1000000;i++)
        {
            if(p[i]==true)
            {
              count++;
            }
            c[i]=count;
        }
        int t=in.nextInt();
        for(int q=0;q<t;q++)
        {
          int x=in.nextInt();
          int y=in.nextInt();
          if(c[x]<=y){
            System.out.println("Chef");
          
            }
        else{
            System.out.println("Divyam");
           }
         
        }
    }   
}