import java.util.ArrayList;
import java.util.Scanner;

public class z_algorithm {


   public static int[] z_create(char[] input)
   {
       int[] z=new int[input.length];
       int left=0;
       int right=0;
       z[0]=0;
       for(int k=1;k<input.length;k++)
       {
           if(k>right)//if k is outside the z-box
           {
               left=right=k;
               while((right<input.length)&&(input[right]==input[right-left]))
               {
                   right++;
                   
               }
               z[k]=right-left;
               right--;
           }
           else{//if k is inside the z-box
               int k1=k-left;
               if(z[k1]<right-k+1)
               {
                   z[k]=z[k1];
               }
               else{
                left=k;
                while((right<input.length)&&(input[right]==input[right-left]))
                {
                    right++;
                }
                z[k]=right-left;
                right--;
               }

           }
       }
       return z;
   }

   public static int ans(char[] pat,char[] txt)
   {
    char[] input=new char[pat.length+txt.length+1];
    int i=0;
    for (char c : pat) {
        input[i]=c; 
        i++;
    }
    input[i]='$';
    i++;
    for (char c : txt) {
        input[i]=c; 
        i++;
    }
    
    ArrayList<Integer> result=new ArrayList<>();
    int[] ansq=z_create(input);
    //System.out.println("ans le"+ ansq.length);
    for(int y=0;y<ansq.length;y++)
    {
        if(ansq[y]==pat.length)
        {
            result.add(y);
        }
    }
    return result.size();
   }
    public static void main(String[] args)
    {
        String s1="abc";
        String s2="abcabdabc";
        System.out.println(ans(s1.toCharArray(),s2.toCharArray()));

    }
} 
