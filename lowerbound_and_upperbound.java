import java.util.ArrayList;

public class lowerbound_and_upperbound {
    
    public static int lower_bound(int[] ar,int k)
  {
     int low=0;
     int high=ar.length-1;
     int mid;
     while(low<high)
     {
         mid=(low+high)/2;
        if(ar[mid]>=k)
        {
            high=mid;
        }
        else{
            if(ar[mid]<k)
            {
                low=mid+1;
            }
        }
     }
      if(low==ar.length-1&&ar[low]!=k)
      {
        return low+1;
      }
     return low;
  }
  public static int upper_bound(int[] ar,int k)
{
    int low=0;
    int high=ar.length-1;
    int mid;
    while(low<high)
    {
       mid=(low+high)/2;
       
           if(ar[mid]>k)
           {
               high=mid;
           }
           else{
               if(ar[mid]<=k)
               {
                   low=mid+1;
               }
           }

    }
    if(low==ar.length-1&&ar[low]<=k)
      {
        return low+1;
      }
   
   return low;
}
public static void main(String[] args) {
    int[] a={10,20,30,40,50};
    System.out.println(upper_bound(a, 30));
}
}
