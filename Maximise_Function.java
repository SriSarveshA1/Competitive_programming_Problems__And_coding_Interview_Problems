import java.util.Arrays;
import java.util.Scanner;

public class Maximise_Function {
    public static void main(String[] args)
    {	Scanner in=new Scanner(System.in);
        int N=in.nextInt();
		    int[] arr=new int[N];
		    for(int i=0;i<N;i++)
		    {
		        arr[i]=in.nextInt();
		    }
		   // Arrays.sort(arr);
		    Arrays.sort(arr);
		    int x1=arr[0];
		    int y1=arr[N-1];
		    int z1=arr[N-2];
		    int x2=arr[0];
		    int y2=arr[1];
		    int z2=arr[N-1];
		    int ans1=0,ans2=0;
            ans1+=Math.abs(x1-y1)+Math.abs(y1-z1)+Math.abs(z1-x1);
            ans2+=Math.abs(x2-y2)+Math.abs(y2-z2)+Math.abs(z2-x2);
           System.out.println(Math.max(ans1, ans2));
    }
}