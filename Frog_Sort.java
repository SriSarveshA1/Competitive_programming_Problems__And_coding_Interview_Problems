import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Frog_Sort {
     static boolean is_crct(HashMap<Integer,Integer> m,int x)
     {
         int count=0;
        for (Map.Entry<Integer,Integer> entry : m.entrySet())  
        { 
            if(entry.getKey()<x&&entry.getValue()<m.get(x))
            {
                count++;
            }
          
        }
        return count==x-1;
     }
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int q=0;q<t;q++)
        {
            int N=in.nextInt();
            int[] W=new int[N];
            int[] L=new int[N];
            for(int i=0;i<N;i++)
            {
                W[i]=in.nextInt();
            }
            for(int i=0;i<N;i++)
            {
                L[i]=in.nextInt();
            }
            HashMap<Integer,Integer> m_weight_original_index=new HashMap<>();
            HashMap<Integer,Integer> steps=new HashMap<>();
            for(int i=0;i<N;i++)
            {
                m_weight_original_index.put(W[i], i);
                steps.put(W[i], L[i]);
            }
            Arrays.sort(W);
            int count=0;
            for(int i=1;i<N;i++)
            {
                while(!is_crct(m_weight_original_index,W[i]))
                {
                    count++;
                    m_weight_original_index.put(W[i], m_weight_original_index.get(W[i])+steps.get(W[i]));
                }
            }
            System.out.println(count);
        }
        
    }
}