import java.util.Arrays;
import java.util.Scanner;

public class Number_theory {
    static boolean[] prime_sieve(boolean[] prime) {
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
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        boolean[] p=new boolean[1000001];
        Arrays.fill(p, false);
        p= prime_sieve(p);
        int n;
        n=20;
        for(int i=0;i<=n;i++)
        {
            if(p[i])
            {
                System.out.print(i+" ");
            }
        }
        System.out.println();
        
    }   
}
