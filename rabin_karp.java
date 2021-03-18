import java.util.*;
import java.lang.*;
 
class Main
{
    public static boolean fuc(String t,String pat,int s,int M)
    {
        for(int j=0;j<M;j++)
        {
            if(pat.charAt(j)!=t.charAt(j+s))
            {
                return false;
            }
        }
        return true;
    }
	static ArrayList<Integer>  search(String txt,String pat,int q)
	{
        ArrayList<Integer> ans=new ArrayList<>();
		int N=txt.length();
		int M=pat.length();
		int p=0;//pattern hash value
        int[] t=new int[N-M+1];
		int d=26;//total no of characters
		int h=(int)Math.pow(d,M-1)%q;

		for(int i=0;i<M;i++)//calculating the hash value of pattern and the hash value of  first window of the string txt
		{
		  p=((d*p)+pat.charAt(i)-'a')%q;
		  t[0]=((d*t[0])+txt.charAt(i)-'a')%q;
		}
		int j;
		//boolean flag=false;
        int count=0;
		for(int s=0;s<=N-M;s++)
		{
			if(p==t[s])
			{
				if(fuc(txt,pat,s,M))
				{
                    
					ans.add(s+1);
				}
			}
			if(s<N-M)
			{
				t[s+1]=(d*(t[s]-(txt.charAt(s)-'a')*h)+(txt.charAt(s+M)-'a'))%q;
				
			}
		}
        return ans;
	}
   
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
			String txt=sc.next();
            System.out.println("txt= "+txt);
			String pat=sc.next();
            System.out.println("pat= "+pat);
			int q=1000000007;
			ArrayList<Integer> f=search(txt,pat,q);
			if(f.size()==0)
			{
				System.out.println("Not Found");
			}
            else{
                System.out.println(f.size());
                for(int y=0;y<f.size();y++)
                {
                    System.out.print(f.get(y)+" ");
                }
            }
			System.out.println();
		}
	}
} 