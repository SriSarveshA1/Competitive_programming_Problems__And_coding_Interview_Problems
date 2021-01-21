public class subarray_with_maximum_xor {
    public class node{
        node left;  //to represent whether we have 0 as value
        node right;// to represent we have 1 as value
        node()
        {
            left=null;
            right=null;
        }
    }
    node root;
    subarray_with_maximum_xor()
    {
        root=new node();
    }
    void insert(int n)
    {
        node temp=root;
       
        for(int i=31;i>=0;i--)
        {
            int bit=(n>>i)&1;
            if(bit==0)
            {
                if(temp.left==null)
                {
                    temp.left=new node();
                }
                temp=temp.left;
            }
            else{
                if(temp.right==null)
                {
                    temp.right=new node();
                }
                temp=temp.right;
            }

        }
    }
     int  max_xor(int value)
    {
        node temp=root;
        int cur_max_xor=0;
        for(int j=31;j>=0;j--)
        {
            int bit=(value>>j)&1;
            if(bit==0)
            {
                if(temp.right!=null)//if the complement of 0 is present 
                {
                 cur_max_xor+=(1<<j);// to find the bit value at that particular bit
                 temp=temp.right;
                }
                else{
                    temp=temp.left;
                }
            }
            else{
                if(temp.left!=null)
                {
                    cur_max_xor+=(1<<j);
                    temp=temp.left;
                }
                else{
                    temp=temp.right;
                }
            }
        }
        return cur_max_xor;//at last we return the maximum xor that can be formed by value 
    }
     int max_xor_helper(int[] a)
     {
         int maxx_xor=0;
         int xor=0;
         for(int i=0;i<a.length;i++)
         {
            xor=xor^a[i];
            insert(xor);
            int cur_max=max_xor(xor);
           // System.out.println("cur="+cur_max);
            maxx_xor=Integer.max(cur_max, maxx_xor);
            
         }
         return maxx_xor;

     }
    public static void main(String[] args)
    {
        subarray_with_maximum_xor t=new subarray_with_maximum_xor();
        int[] a={12, 15, 5, 7, 1, 9, 8, 6, 10, 13};
        //int[] cum=new int[a.length];
        /*
        int xor=a[0];
        for(int i=1;i<a.length;i++)
        {
          xor^=a[i];
          a[i]=xor;
        }
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+ " ");
        }
        */
      //  System.out.println();
        
        System.out.println(t.max_xor_helper(a));
       
       /*
        int act=10^4^25;
        System.out.println("actual="+act);
        System.out.println(3);
        System.out.println(3^10);
        System.out.println(3^10^4);
        System.out.println(3^10^4^25);
        System.out.println(3^10^4^25^2);
        System.out.println(3^10^4^25^2^8);
       */

    }
    
}
