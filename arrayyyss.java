
import java.security.KeyStore.Entry;
import java.sql.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;


import jdk.javadoc.internal.doclets.formats.html.markup.Head;

public class arrayyyss {
    static int kadanes_algo(int[] a)//this algorithm is used to find what is the maximum subarray sum that can be possible out from the array
     {
        //we are going to find what is the maximum subarray sum that can be possible at the current index i of the array 
        //and we will finally return the maximum subarray sum that can be possible from the overall array
        int cur_sum=0;
        int max_sub_array=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++)
        {
            ArrayList<Integer> l=new ArrayList<>();
            

           cur_sum=cur_sum+a[i];
           if(cur_sum<a[i])
           {
               cur_sum=a[i];
           }
           
           if(cur_sum>max_sub_array)
           {
               max_sub_array=cur_sum;
           }
        }
        return max_sub_array;
        
     }
     static int find_the_duplicate_in_the_array_that_contains_range_of_Numbers_from_1_to_N__SDE_ARRAY_Q1(int[] array)
     {
            int slow=array[0];
            int fast=array[0];
            do{
                slow=array[slow];
                fast=array[array[fast]];
            }while(slow!=fast);
            slow=array[0];
            while(slow!=fast)
            {
                slow=array[slow];
                fast=array[fast];
            }
        return slow;//contains the point where the loop starts and that is the duplicate element
     }
      static void Sort_an_array_of_0s_1s_2s_without_using_extra_space_or_sorting_algo_dutch_flag_algo__SDE_ARRAY_Q2(int[] array)
    {
           int low=0;
           int mid=0;
           int high=array.length-1;
           while(mid<=high)
           {
               int v=array[mid];
               switch(v)
               {
                   case 0:
                   int temp=array[low];
                   array[low]=array[mid];
                   array[mid]=temp;
                   low++;
                   mid++;
                   break;

                   case 1:
                   mid++;
                   break;

                   case 2:
                   temp=array[high];
                   array[high]=array[mid];
                   array[mid]=temp;
                   high--;
                   break;
 
               }
           }
           for(int i=0;i<array.length;i++)
           {
               System.out.print(array[i]+" ");
           }
           System.out.println();
    }
    static void  repeating_and_the_missing_METHOD1_SDE_ARRAY3(int[] arr)
    {
       int n=arr.length;
       int sumN=(n*(n+1))/2;
       int sum=0;
       for(int i=0;i<arr.length;i++)
       {
           sum+=arr[i];
       }
   
       int sumsqN=(n*(n+1)*(2*n+1))/6;
       int sumsq=0;
       for(int i=0;i<arr.length;i++)
       {
           sumsq+=arr[i]*arr[i];
       }
     
       int b=(((sumsq-sumsqN)/(sum-sumN))-(sum-sumN))/2;
       int a=sum-sumN+b;
       
      

       System.out.print("Missing = "+b+", "+"Repeating = "+a);

    }
    static void repeating_and_the_missing_Method_2_xor_SDE_ARRAY3(int[] arr)
    {
      int n=arr.length;
      int[] nums=new int[n];
      for(int i=0;i<n;i++)
      {
          nums[i]=i+1;
      }
      int xor1=0,xor2=0;
      for(int i=0;i<n;i++)
      {
          xor1^=arr[i];
      }
      for(int i=0;i<n;i++)
      {
          xor2^=nums[i];
      }
      int xor3=xor1^xor2;
      int temp=xor3;
      int index=0;
      while(temp>0)
      {
         if((temp&1)==1)
         {
            break;
         }
         index++;
         temp=temp>>1;
      }
      int mask=1<<index;
      ArrayList<Integer> buck1=new ArrayList<>();
      ArrayList<Integer> buck2=new ArrayList<>();
      for(int i=0;i<n;i++)
      {
          if((mask&arr[i])==1)
          {
              buck1.add(arr[i]);
          }
          else{
              buck2.add(arr[i]);
          }
      }
      for(int i=0;i<n;i++)
      {
          if((mask&nums[i])==1)
          {
              buck1.add(nums[i]);
          }
          else{
              buck2.add(nums[i]);
          }
      }
      int b=0;
      int a=0;
      for(int i=0;i<buck1.size();i++)
      {
          b^=buck1.get(i);
      }
      for(int i=0;i<buck2.size();i++)
      {
          a^=buck2.get(i);
      }
      System.out.println(b+" "+a);

    }
   static int nextGap(int gap)
   {
    if (gap <= 1)
    {
        return 0;
    }
    return (gap / 2) + (gap % 2);
   }
    static void Merge_two_sorted_Arrays_without_extra_space_SDE_ARRAY_4(int[] arr1,int[] arr2,int n,int m)
    {
 
        int i,j;
        int gap=(n+m);  
        for(gap=nextGap(gap);gap>0;gap=nextGap(gap))
        {
            //comparing elements within the  array1..so when i+gap crosses the array1 size means one pointer i is there in the first array and i+gap pointer goes out of the first array
            for(i=0;i+gap<n;i++)
            {
                if(arr1[i]>arr1[i+gap])
                {
                    int temp=arr1[i];
                    arr1[i]=arr1[i+gap];
                    arr1[i+gap]=temp;
                }
            }
            //comparing elements from both the array1 and array2 as i will be within the array_1 and i+gap will be pointing outwards the indexes of array1
            for(j=gap>n?gap-n:0;i<n&&j<m;i++,j++)
            {
                if (arr1[i] > arr2[j])
                {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
            //comparing all the elements within array_2 since both the pointers will point to the second array since in the above loop any one of the pointer goes out of the length
            if(j<m)
            {
                for(j=0;j+gap<m;j++)
                {
                    if (arr2[j] > arr2[j + gap]) 
                    {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }

                }
            }
        }
    }
    static int[][] merge_Overlapping_Subintervals_SDE_ARRAY_6(int[][] intervals)
    {
        ArrayList<int[]> res=new ArrayList<>();//the res variable will hold the integer arrays like [],[],[] and at last it will have [[],[],[]]
        if(intervals.length==0||intervals==null)
        {
            return res.toArray(new int[0][]);//when the length of the intervals array that is passed or if the intervals is null ..we need to return the resultant list which contains one empty array...[] as of now .
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);//This is the syntax to sort an array that has various arrays inside it like [[a1,b1],[a2,b2],[a3,b3]]..they all will be sorted
        int start=intervals[0][0];
        int end=intervals[0][1];
        for (int[] i : intervals) {
            if(i[0]<=end)//if the next pairs starting interval is less than are equal to out temps end then they are in the same interval and we need to merge them
            {// we are merging the intervals
                start=Integer.min(start, i[0]);//Now our temp will currently have starting interval as the minimum value of starting interval value out of the two pairs [tempsstart,tempsend],[a2,b2]
                end=Integer.max(end,i[1]);//same as above temp will be having the maximum ending interval out of current temps ending value and from the pair [tempsstart,tempsend],[a2,b2]
            }
            else{//If we cant merge the current tempsstart,tempssend with the next pair we add the current tempsstart,tempsend to the result and update the tempsstart and tempsend
                res.add(new int[]{start,end}); 
                start=i[0];
                end=i[1];
            }
        }
        res.add(new int[]{start,end}); //when we iterate over the last pair there will be tempstart,tempsend values that wont be added to the result and we need to add that.

        return res.toArray(new int[0][]);//we are returning the resultant in the form array.
    }

    static void setZeroes_SDE_ARRAY_7(int[][] matrix)
    {
        boolean col0=false;
        int rowsize=matrix.length;// we will find the row size by seeing this
        int colsize=matrix[0].length;// we need to find the no of columns by finding the length of each array inside the other array
        for(int i=0;i<rowsize;i++)
        {
            if(matrix[i][0]==0)//when ever there is a 0 at the 0th column we need to make the col0 as true
            {
                col0=true;
            }
            for(int j=1;j<colsize;j++)
            {
              if(matrix[i][j]==0) //when ever ther is a 0 at a (i,j) position
              {
                  matrix[i][0]=matrix[0][j]=0;//we need to make 0th column and ith row of matrix as 0 ...and 0th row and jth column as 0.
              }
            }
        }
        for(int i=rowsize-1;i>=0;i--)
        {
            for(int j=colsize-1;j>=1;j--)
            {
                if(matrix[i][0]==0||matrix[0][j]==0)//if the left most matrix value or the top most row index value of matrix as 0
                {
                    matrix[i][j]=0;
                }
               
               
            }
             if(col0==true)//when ever a col 0 is true means the leftt most column is true at that time we need to make the entire left most column as 0
                {
                        matrix[i][0]=0;
                }
        }

    }
    static List<List<Integer>> generate_pascal_triangle_SDE_ARRAY_8_part1(int numRows)
    {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> row,prev=null;
        for(int i=0;i<numRows;i++)
        {
            row=new ArrayList<Integer>();
            for(int j=0;j<=i;j++)
            {
               if(j==0||j==i)
               {
                   row.add(1);
               }
               else{
                   row.add(prev.get(j-1)+prev.get(j));
               }

            }
            prev=row;
            res.add(row);
        }
        return res;
    }
    static List<Integer> getRow(int rowIndex) {
        
        rowIndex+=1;
        List<Integer> ans=new ArrayList<>();
        int n=rowIndex-1;
        int res=1;
        
        System.out.println("res= "+res);
        for(int i=0;i<rowIndex-1;i++)
        {    ans.add(res);
            System.out.println("res= "+res);
            res*=(n-i);
            res/=(i+1);
            
        }
        ans.add(res);
    
        return ans;
    }
    static void swap(int[] A,int i,int j)
    {
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
    static void reverse(int[] A,int i,int j)
    {
        while(i<j)
        {
            swap(A, i++, j--);
        }
    }
    static void find_the_next_permutation_SDE_ARRAY_9(int[] A)
    {
        if(A==null||A.length==0)//If the array is empty or the length of the array is 0 then there is no change in the array so we return the array.
        {
            return; 
        }
        int index1=A.length-2;// we need to traverse from the second last position of the array ..so that we can easily perform A[i]>A[i+1] condition and find the index1 value or the breaking point of the sequence
        while((index1>=0)&&(A[index1]>=A[index1+1]))
        {
            index1--; 
        }
        //At now we would have found the breaking point of the sequence that is index1.....if we were not able to find the breaking point of the sequence then  the index1 will be -1 and at that time we will reverse the entire list of numbers
        if((index1>=0))//if the index1 is less that 0 we wont go into this if block
        {
            int index2=A.length-1;// we need to traverse again from the last position of the array and find A[index2]<A[index1]
            while((A[index2]<=A[index1]))
            {
                index2--;//we keep on reducing the value of index2 until we match the condition (A[index2]<A[index1])
            }
            swap(A,index1,index2);

        }
        reverse(A,index1+1,A.length-1);
    }
    static int merge_count_inversions_SDE_ARRAY_10(int[] arr,int[] temp,int left,int mid,int right) //left--(mid-1) is one array and (mid)--right is another array
    {
        int i,j,k;
        int count_inversions=0;
        i=left; //from i to mid-1 it will be one array 
        j=mid;  //from j to right it will be on another array
        k=left; //we keep a pointer of left so we all be adding values accordingly to the temp array and againg put it on the main array;
        while((i<=mid-1)&&(j<=right))
        {
            if(arr[i]<=arr[j])//if the first arrays ith element is lesser than the second arrays jth element ..we need to add ith element of the first array into the temp
            {
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
                count_inversions+=(mid-i);//we add the count by finding how many elements are there from i to mid-1
            } 
        }
        while(i<=mid-1)
        {
            temp[k++]=arr[i++];
        }
        while(j<=right)
        {
            temp[k++]=arr[j++];     
        }
        for(int rt=left;rt<=right;rt++)
        {
            arr[rt]=temp[rt];
        }
        return count_inversions;
    }
    static int merger_sort_count_inversions_SDE_ARRAY_10(int[] arr,int[] temp,int left,int right)
    {
        int count_inversions=0;
        int mid;
         if(left<right)
        {
            mid=(left+right)/2;
          count_inversions+=merger_sort_count_inversions_SDE_ARRAY_10(arr, temp, left, mid);
          count_inversions+=merger_sort_count_inversions_SDE_ARRAY_10(arr, temp, mid+1, right);
          count_inversions+=merge_count_inversions_SDE_ARRAY_10(arr, temp, left, mid+1, right);//from left--(mid) of arr  is one array (mid+1)to right is one array

        }
        return count_inversions;

    }
    public int maxProfit_Best_Time_to_Buy_and_Sell_Stock_1_SDE_ARRAY_11(int[] prices) {
        int minval=Integer.MAX_VALUE;
        int profit=0;
        for(int i=0;i<prices.length;i++)
        {
            minval=Integer.min(prices[i], minval);
            profit=Integer.max(profit,prices[i]-minval);
        }
        return profit;
    }
    public int maxProfit_Best_Time_to_Buy_and_Sell_Stock_2_SDE_ARRAY_11(int[] prices)
    {
        int profit=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i-1]<prices[i])
            {
              int v=prices[i]-prices[i-1];
              profit+=v;
            }
            else{
                continue;
            }
        }
        return profit;
    }
    static int[][] Rotate_Matrix_SDE_ARRAY_12(int[][] matrix)
    {
        //transpose the array
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=i;j<matrix[0].length;j++)
            {
                int temp=0;
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //rotatee the matrix by reversing each row
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length/2;j++)
            {
               
                
                    int temp=matrix[i][j];
                    
                    matrix[i][j]=matrix[i][matrix[0].length-1-j];
                    matrix[i][matrix[0].length-1-j]=temp;
                    
               
            }
        }
        return matrix;
        

    }
    static boolean searchMatrix_1_SDE_ARRAY_13(int[][] matrix, int target) {
        int low=0;
        int high=matrix[0].length-1;
        int m=matrix[0].length;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int i=mid/m;//to calculate the row index
            int j=mid%m;//to calculate  the column index
            if(matrix[i][j]==target)
            {
                return true;

            }
            else{
                if(matrix[i][j]>target)
                {
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
        }
        return false;
        
    }
    static boolean searchMatrix_2_SDE_ARRAY_13(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int i=0;
        int j=m-1;//we are initially at the left most of the matrix
        while(i<n && j>=0)//we should not go  out of the row or column
        {
            if(matrix[i][j]==target)
            {
                return true;
            }
            else{
                if(matrix[i][j]>target)
                {
                   j--;//if the element is greaterr than target
                }
                else{
                    i++;
                }
            }
        }
        return false;
    }

    static double p_SDE_ARRAY_14(double x, int n) {
        if(n==0)
        {
            return 1;
        }
        if(n==1)
        {
            return x;
        }
        //double ans=1;
        double ans=x*x;
        if(n%2==0)
        { 
            
            return p_SDE_ARRAY_14(ans, n/2);
        }
        else{
            
            return x*p_SDE_ARRAY_14(ans, n/2);
        }
    }
    
    static double myPow_SDE_ARRAY_14(double x, int n) {
        if(n<0)
         {
             /*
            DecimalFormat df = new DecimalFormat("#.#####");
           Double dk=df.format(p(x, n));
           */
             return 1/ p_SDE_ARRAY_14(x,n);
         }
         return p_SDE_ARRAY_14(x, n);
     }
     public int majorityElement_SDE_ARRAY_15(int[] nums) {
         int count=0;
         int element=0;
         for(int i=0;i<nums.length;i++)
         {
             if(count==0)
             {
                 element=nums[i];
             }
             if(nums[i]==element)
             {
                 count++;
             }
             else{
                 count--;
             }
         }
         return element;
        
    }
    public List<Integer> majorityElement_2_SDE_ARRAY_16(int[] nums) {
        int count1=0;
        int count2=0;
        int num1=-1;//Numbers that are not in the range of given nums
        int num2=-1;//Numbers that are not in the range of given nums
        for(int i=0;i<nums.length;i++)
        {
            if(num1==nums[i])
            {
                count1++;
            }
            else{
                if(num2==nums[i])
                {
                    count2++;
                }
                else{
                    if(count1==0)
                    {
                        num1=nums[i];
                        count1=1;
                    }
                    else{
                        if(count2==0)
                        {
                            num2=nums[i];
                            count2=1;
                        }
                        else{//if the nums[i] is not num1 or num2 then that particular nums[i] will eliminate the count1,count2 value of the two majority elments (num1,num2) that we took.
                            count1--;
                            count2--;
                        }
                    }
                }
            }
        }
        count1=0;//we make both the count1 and count2 of num1 andd num2 as 0 so we can count their occurances again by doing another traversal
        count2=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==num1)
            {
              count1++;
            }
            if(nums[i]==num2)
            {
                count2++;
            }
        }
        List<Integer> ok=new ArrayList<>();
        if(count1>(nums.length/3))
        {
          ok.add(num1);
        }
        if(count2>(nums.length/3))
        {
            ok.add(num2);
        }
        return ok;
    }
    public int uniquePaths_SDE_ARRAY_17(int m, int n) {
        int N=m+n-2;
        int r=m-1;
        double res=1;
        for(int i=1;i<=r;i++)
        {
            res=res*((N-r+i)/i);
        }
        return (int)res;//since the no of paths will be in integer only
    }
    public int merge__reverse_pairs_SDE_ARRAY_18(int[] nums,int[] temp,int low,int mid,int high)
    {
        int count=0;
        int j=mid+1;//starting point of the second array
        for(int i=low;i<=mid;i++)
        {
            while((j<=high)&&(nums[i]>2*(long)nums[j]))
            {
                j++;
            }
            count+=(j-(mid+1));
        }
        int k=low;//starting index of the temp array
        int left=low;//left array starting point 
        int right=mid+1;//Right arrays starting point 
        while(left<=mid &&right<=high)
        {
            if(nums[left]<=nums[right])
            {
                temp[k++]=nums[left++];
            }
            else{
                temp[k++]=nums[right++];
            }
        }
        while(left<=mid)
        {
            temp[k++]=nums[left++];
        }
        while(right<=high)
        {
            temp[k++]=nums[right++];
        }
        for(int i=low;i<=high;i++)
        {
            nums[i]=temp[i];//we are storing the array values at the correct positions from the temp[] to the nums[]
        }
        return count;

    }
    public int mergesort_reverse_pairs__SDE_ARRAY_18(int[] nums,int[] temp,int low,int high)
    {
        if(low>=high)
        {
            return 0;
        }
    
     
         int mid=(low+high)/2;
         int count_reverse_pairs= mergesort_reverse_pairs__SDE_ARRAY_18(nums, temp, low, mid);;
       
         count_reverse_pairs+=mergesort_reverse_pairs__SDE_ARRAY_18(nums, temp, mid+1, high);
         count_reverse_pairs+=merge__reverse_pairs_SDE_ARRAY_18(nums,temp,low,mid,high);
     
     return count_reverse_pairs;
    }
    public int reversePairs_SDE_ARRAY_18(int[] nums) {
        int[] temp=new int[nums.length];
        int low=0;
        int high=nums.length-1;
        return mergesort_reverse_pairs__SDE_ARRAY_18(nums, temp, low, high);
    }
     
    public int[] twoSum_SDE_ARRAY_19(int[] nums, int target) {
        HashMap<Integer,Integer> ht=new HashMap<>();
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            if(ht.containsKey(target-nums[i]))
            {
              ans[0]=ht.get(target-nums[i]);
              ans[1]=i;
            }
            ht.put(nums[i], i);
        }
        return ans;
    }
    public List<List<Integer>> fourSum_SDE_ARRAY_20(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int target2=target-(nums[j]+nums[i]);
                int left=j+1;
                int back=n-1;
                while(left<back)
                {
                    int cursum=nums[left]+nums[back];
                    if(cursum<target2)
                    {
                      left++;
                    }
                    else{
                        if(cursum>target2)
                        {
                            back--;
                        }
                        else{//if the nums[left] and nums[right]'s  sum becomes equal to target2 then they are the other two numbers to form quadripltes
                            List<Integer> quad=new ArrayList<>();
                            quad.add(nums[i]);// index 0  --first number
                            quad.add(nums[j]);// index 1  --second number
                            quad.add(nums[left]);//index 2 --third number
                            quad.add(nums[back]);//index 3 --fourth number
                            res.add(quad);
                            //we need to skip the duplicates while moving the left pointer towards left wards
                            while(left<back && nums[left]==quad.get(2))//while left is behind the right and we keep on getting left pointer pointing to the dupplicate elments we keep on moving the left pointer
                            {
                                left++;
                            }
                            while(back<n && nums[back]==quad.get(3))//while right is not crossing the n ..and back is keep on pointing the duplicate element we keep moving back
                            {
                                back--;
                            }
                        }
                    }
                    
                }
                while(j+1<n&&nums[j+1]==nums[j])//here we check whether j+1 points to duplicate if it pointing to duplicate we increase its j's value and also we atlast point j to one of the duplicate value ..cause when we go back and start the loop j value will also be increased by it.
                {
                   j++;
                }

            }
            while(i+1<n&&nums[i+1]==nums[i])//here we check whether i+1 points to duplicate if it pointing to duplicate we increase its i's value and also we atlast point i to one of the duplicate value ..cause when we go back and start the loop i value will also be increased by it.
                {
                   i++;
                }
        }
        return res;
    }
    public int longestConsecutive_algorithm_SDE_ARRAY_21(int[] nums) {
        HashSet<Integer> ht=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            ht.add(nums[i]);//we are adding each element into the hashtable
        }
        int maxlength=0;
        for(int i=0;i<nums.length;i++)
        {
            if(ht.contains(nums[i]-1))//we are checking whehter the previous elements are there are not 
            {
                continue;
            }
            else{
              int length=0;
              int v=nums[i];
              while(ht.contains(v))//we are checking the next..next..consequtive numbers are there
              {
                  length++;
                  v++;
              }
              maxlength=Integer.max(length, maxlength);
            }

        }
        return maxlength;

    }
    int maxLen_Largest_Subarray_with_0_sum_SDE_ARRAY_22(int arr[], int n)
    {
        // Your code here
        int maxlength=0;
        int cursum=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            cursum+=arr[i];
            if(cursum==0)
            {
                maxlength=i+1;
            }
            else{
                if(hm.containsKey(cursum))//if the particualar prefix sum is already present we just do i-(that already stored sums index)
                {
                   maxlength=Integer.max(maxlength, i-hm.get(cursum));
                }
                else{
                    hm.put(cursum, i);
                }
            }
            
        }
        return maxlength;
        
    }

    public int solve_Count_number_of_subarrays_with_given_XOR_SDE_ARRAY_23(int[] A, int B) {
        int count=0;
        int xor=0;
        int n=A.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            xor=xor^A[i];
            int y=xor^B;
            if(hm.containsKey(y))
            {
                count+=hm.get(y);
            }
            if(xor==B)
            {
                count++;
            }
            if(hm.containsKey(xor))
            {
                hm.put(xor, hm.get(xor)+1);//we increase its allready occured occurance value
            }
            else{
                hm.put(xor, 1);
            }

        }
        return count;
    }
    public int lengthOfLongestSubstring_SDE_ARRAY_24(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        char[] a=s.toCharArray();
        int maxlength=0;
        int curlength=0;
        int l=0;
        int r=0;
        int n=s.length();
        while(r<n)
        {
           if(hm.containsKey(a[r])==false)
           {
               curlength=(r-l)+1;
               hm.put(a[r], r);//we stroring the character along with its last seen index
           }
           else{
               //if the character a[r] is already present in the hashmap then we need to check whether it the last seen of a[r] is in the range of l ... r
               int ri=hm.get(a[r]);
               if(l<=ri&&ri<=r)
               {
                  l=l+ri;//if ri is in the range of l...r then we make the l to take a direct a jump from l position to last seen index of a[r]
               }
               curlength=(r-l)+1;
               hm.put(a[r], r);
           }
           maxlength=Integer.max(curlength, maxlength);
        }
        return maxlength;


    }
    static int lengthOfLongestSubstringTwoDistinct__SDE_ARRAY_24_variant(String s) {
        char[] a=s.toCharArray();
         int maxlength=0;
         int curlength=0;
         int l=0;
         int r=0;
         int n=s.length();
         if(n==0)
         {
             return 0;
         }
         int countd=0;
         HashMap<Character,Integer> hs=new HashMap<>();
         while(r<n)
         {
            if(hs.size()<=2)
            {
                hs.put(a[r], r);
                
            }
            if(hs.size()>2)
            {
                int low=Integer.MAX_VALUE;
                for (int i : hs.values()) {
                    low=Math.min(i, low);
                    
                }
                char f=s.charAt(low);
                hs.remove(f);
                l=low+1;
            }
                maxlength=Integer.max(maxlength, r-l+1);
                //System.out.println("l= "+l+" r= "+r+" str= "+s.substring(l,r+1)+" countd = "+hs.size());
                
               r++; 
            
           
         }
         return maxlength;
    }
    static int calculate_sum(int[] nums,int l,int r)
    {
        int sum=0;  
      for(int i=l;i<=r;i++)
      {
         sum+=nums[i];
      }
      System.out.println("l= "+l+" r ="+r+" sum= "+sum);
      return sum;
    }
    static int maximumUniqueSubarray_SDE_ARRAY_24_variant(int[] nums) {
            int l=0;
            int r=0;
            int n=nums.length;
            int curlength=0;
            int maxlength=0;
            HashMap<Integer,Integer> hm=new HashMap<>();
            while(r<n)
            {
               if(hm.containsKey(nums[r])==false)
               {
                   hm.put(nums[r],r);
                   curlength=calculate_sum(nums, l, r);
               }
               else{
               if(hm.containsKey(nums[r])==true)
               {
                   int ri=hm.get(nums[r]);
                   if(l<=ri&&ri<=n)
                   {
                       l=ri+1;
                   }
                   hm.put(nums[r],r);
                   curlength=calculate_sum(nums, l, r);
               }
            }

               maxlength=Integer.max(curlength, maxlength);
               System.out.println(maxlength);
               r++;
            }
            return maxlength;

    }   
    static int firstMissingPositive_SDE_ARRAY_IMPOOO(int[] a) {
        int n=a.length;

       for(int i=0;i<n;i++)
       {
           int curr=a[i]-1;
           while(a[i]>=1&&a[i]<n&&a[i]!=a[curr])
           {
               int temp=a[i];
               a[i]=a[curr];
               a[curr]=temp;
               curr=a[i]-1;//we are again going to the same a[i] to check whether index i is placed at a[i] ..if not we again do swapping
               
               //a[i]=a[i]-1;
           }
       }
       for(int i=0;i<n;i++)
       {
           if(a[i]!=i+1)
           {
               return i+1;
           }
       }
       return n+1;
       
    }
    public int findKthPositive_SDE_ARRAY_IMPOOO(int[] arr, int k) {
        HashSet<Integer> hs=new HashSet<Integer>();
        for(int i=0;i<arr.length;i++)
        {
            hs.add(arr[i]);
        }
        ArrayList<Integer> rt=new ArrayList<>();
        int start=1;
        while(rt.size()!=k)
        {
            if(hs.contains(start))
            {
                start++;
                continue;
            }
            rt.add(start);
            start++;
            
        }
        return rt.get(k-1);
    }
    static class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
         ListNode d=null;
        ListNode aduthu=null;
    public ListNode reverseList_SDE_LINKED_LIST_1(ListNode head) {
        if(head==null)
       {
           return d;
       }
       
       aduthu=head.next;
       head.next=d;
       d=head;
       head=aduthu;
       return reverseList_SDE_LINKED_LIST_1(head);
   }
   public ListNode middleNode_SDE_LINKED_LIST_2(ListNode head) {
     
       ListNode first=head;
       ListNode second=head;
       while((second!=null)&&(second.next!=null))
       {
          first=first.next;
          second=second.next.next;
       }
       return second;


   }
   public ListNode mergeTwoLists_SDE_LINKED_LIST_3(ListNode l1, ListNode l2) {
       ListNode dummy=new ListNode();
       ListNode dd=dummy;
       dd.next=null;
       while(l1!=null&&l2!=null)
       {
           if(l1.val<l2.val)
           {
               ListNode node=new ListNode(l1.val);
               dd.next=node;
               dd=node;
               dd.next=null;
               l1=l1.next;
           }
           else{
            ListNode node=new ListNode(l2.val);
            dd.next=node;
            dd=node;
            dd.next=null;
            l2=l2.next;
           }
       }
       while(l1!=null)
       {
        ListNode node=new ListNode(l1.val);
        dd.next=node;
        dd=node;
        dd.next=null;
        l1=l1.next;
       }
       while(l2!=null)
       {
        ListNode node=new ListNode(l2.val);
        dd.next=node;
        dd=node;
        dd.next=null;
        l2=l2.next;
       }
       return dummy.next;
   }
   public ListNode mergeTwoLists_SDE_LINKED_LIST_3_in_constant_space(ListNode l1, ListNode l2) {
       if(l1==null)
       {
           return l2;//when l1 is null then we have only one list .and that is l2 and we need to returnn the head of the l2
       }
       if(l2==null)
       {
           return l2;//when l2 is null then we have only one list .and that is l1 and we need to returnn the head of the l1
       }
       if(l1.val>l2.val)
       {
           ListNode temp=l1;
           l1=l2;
           l2=temp;
       }
       ListNode res=l1;//we need to have a pointer that returns the head of the entirer list and that is res.
       while((l1!=null)&&(l2!=null))//both l1 and l2 should not point to null ..so we loop upto that
       {
         ListNode temp=null;
         while((l1!=null)&&(l1.val<l2.val))//we need to iterate until l1's data is less that l2's data
         {
            temp=l1;
            l1=l1.next;
         }
         temp.next=l2;
         //swap
         ListNode t=l1;
           l1=l2;
           l2=t;

       }
       return res;
   }
   public ListNode removeNthFromEnd__SDE_LINKED_LIST_4(ListNode head, int n) {
        ListNode Dummy=new ListNode();
        ListNode first=Dummy;
        ListNode second=Dummy;
        int firstCounter=0;//we will have this variable to keep track of how many steps we took to reach n
        while(firstCounter!=2)
        {
            first=first.next;
            firstCounter++;
        }
        while(first.next!=null)
        {
            second=second.next;
            first=first.next;
        }
        second.next=second.next.next;
        return Dummy.next;


   }
   public void deleteNode__SDE_LINKED_LIST_5(ListNode node) {
    node.val=node.next.val;
    node.next=node.next.next;
   }
   public ListNode addTwoNumbers_SDE_LINKED_LIST_6(ListNode l1, ListNode l2) {
        if(l1==null)
        {
            return l2;

        }
        if(l2==null)
        {
            return l1;
        }
        ListNode dummy=new ListNode();
       
        ListNode temp=dummy;
        int sum=0;
        int carry=0;
        while(l1!=null||l2!=null||carry!=0)
        {
            int v1,v2,v3;
            v3=carry;
            if(l1==null)
            {
                v1=0;
            }
            else{
                v1=l1.val;
                l1=l1.next;
            }
            if(l2==null)
            {
                v2=0;
            }
            else{
                v2=l2.val;
                l2=l2.next;
            }
            sum=v1+v2+v3;
            carry=sum/10;
            sum=sum%10;
            ListNode newnode=new ListNode(sum);
            temp.next=newnode;
            temp=temp.next;
            
        
        }
        return dummy.next;
  } 
  public ListNode getIntersectionNode_SDE_LINKED_LIST_7(ListNode headA, ListNode headB) {
    if(headA==null)//when there is no A list there wont be intersection of list A and List B
    {
        return null;
    }
    if(headB==null)//when there is no B list there wont be intersection of list A and List B
    {
       return null;   
    }
    ListNode d1=headA;
    ListNode d2=headB;
    while(d1!=d2)
    {
        d1=(d1==null)?headB:d1.next;
        d2=(d2==null)?headA:d2.next;
    }
    return d1;
}
public ListNode reverseKGroup_SDE_LINKED_LIST_8(ListNode head, int k) {
        if(head==null)
        {
            return null;
        }
        int count=0;//to count the number of nodes
        ListNode cur=head;
        while(cur.next!=null)
        {
          count++;
          cur=cur.next;
        }
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode prev=dummy;
        ListNode nex=dummy;
        int noofgroups=(int)count/k;
        for(int j=1;j<=noofgroups;j++)
        {
            cur=prev.next;
            nex=cur.next;
            for(int i=1;i<k-1;i++)//for each group we need to perform the k-1 operations
            {
               cur.next=nex.next;
               nex.next=prev.next;
               prev.next=nex;
               nex=cur.next;
            }
            prev=cur;
            
        }
        return dummy.next;
}
public ListNode reverseList_s(ListNode head)
{
    ListNode prev=null;
    //ListNode d=null;
    ListNode next=head;
    while(head!=null)
    {
        next=head.next;
        head.next=prev;
        prev=head;
        head=next;
    }
    return prev;
}
public boolean isPalindrome_SDE_LINKED_LIST_9(ListNode head) {
        ListNode cur=head;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=reverseList_s(slow.next);
        slow=slow.next;
        while(slow!=null)
        {
            if(cur.val!=slow.val)
            {
               return false;
            }
            cur=cur.next;
            slow=slow.next;
        }
        return true;
}
public ListNode detectCycle_SDE_LINKED_LIST_10(ListNode head) {
        if(head==null||head.next==null)
        {
            return null;
        }
        ListNode first=head;
        ListNode second=head;
        while(first!=second)
        {
            first=first.next.next;
            second=second.next;
        }
        second=head;
        while(first!=second)
        {
            first=first.next;
            second=second.next;
        }
        return second;
}
   class Node
  {
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
  }
  Node Merge(Node l1,Node l2)
  {
      Node temp=new Node(0);
      Node res=temp;
      while(l1!=null&&l2!=null)
      {
      if(l1.data>l2.data)
      {
          int v=l2.data;
          Node newNode=new Node(v);
          temp.bottom=newNode;
          temp=temp.bottom;
          l2=l2.bottom;
      }
      else{
        int v=l1.data;
        Node newNode=new Node(v);
        temp.bottom=newNode;
        temp=temp.bottom;
        l1=l1.bottom;

      }
    }
    while(l1!=null)
    {
        int v=l1.data;
        Node newNode=new Node(v);
        temp.bottom=newNode;
        temp=temp.bottom;
        l1=l1.bottom;
    }
    while(l2!=null)
    {
        int v=l2.data;
        Node newNode=new Node(v);
        temp.bottom=newNode;
        temp=temp.bottom;
        l2=l2.bottom;
    }
    return res.bottom;
  }

    Node flatten_SDE_LINKED_LIST_11(Node root)
    {
    // Your code here
    Node l1=root;
    Node l2;
    if(root.next!=null)
    {
        l2=flatten_SDE_LINKED_LIST_11(root.next);
    }
    else{
        return l1;
    }
    Node res=Merge(l1,l2);
    return res;

    }
    public ListNode rotateRight_SDE_LINKED_LIST_12(ListNode head, int k) {
        if(head==null||head.next==null||k==0)
        {
            return head;
        }
        int count=1;
        ListNode cur=head;
        while(cur.next!=null)
        {
            count++;
            cur=cur.next;
        }
        k=k%count;
        cur.next=head;//make it as a circular linked list 
        int stoppoint=count-k;
        int scount=1;
        ListNode temp=head;
        while(scount!=stoppoint)
        {
            scount++;
            temp=temp.next;
        }
        head=temp.next;
        temp.next=null;
        return head;


    }
     static void findDisappearedNumbers(int[] nums) {
         int n=nums.length;
         int curpos;
         int[] a=new int[nums.length];
         a=nums;
        for(int i=0;i<n;i++)
        {  
            curpos=a[i]-1;
            while(a[i]>0&&a[i]<=n&&a[i]!=a[curpos])
            {
                int temp=a[i];
                a[i]=a[curpos];
                a[curpos]=temp;
                curpos=a[i]-1;
            }
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();


    }
    /*
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    /*
    public Node copyRandomList_Clonea_Linked_List_with_random_and_next_pointer_SDE_LINKED_LIST_13(Node head) {
        //step 1
        Node iter=head;
        Node front=head;
        while(iter!=null)
        {
            front=iter.next;
            Node copy=new Node(iter.val);
            iter.next=copy;
            copy.next=front;
            iter=front;
        }
        //step2
        iter=head;
        while(iter!=null)
        {
            if(iter.random!=null)
            {
            iter.next.random=iter.random.next;
            }
            iter=iter.next.next;
        }
        //step3
        Node dummy=new Node(0);
        Node psedo=dummy;
        iter=head;
        front=head;
        while(iter!=null)
        {
            front=iter.next.next;
            psedo.next=iter.next;
            psedo=psedo.next;
            iter.next=front;
            iter=iter.next;
        }
        return dummy.next;
    }
    */
    public List<List<Integer>> threeSum_SDE_LINKED_LIST_14(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new LinkedList<>();
        int n=nums.length;
        for(int i=0;i<n-2;i++)
        {
            int low=i+1;
            int high=n-1;
            int sum=0-nums[i];
            while(low<high)
            {
              if(nums[low]+nums[high]==sum)
             {
                  List<Integer> ans=new ArrayList<Integer>();
                  ans.add(nums[i]);
                  ans.add(nums[low]);
                  ans.add(nums[high]);
                  res.add(ans);
                  while(low<high&&nums[low]==nums[low+1])
                  {
                      low++;
                  }
                   while(low<high&&nums[high]==nums[high-1])
                   {
                       high--;
                   }
                  low++;
                  high--;
                  
             }
             else{
                 if(nums[low]+nums[high]>sum)
                 {
                     high--;
                 }
                 else
                 {
                     low++;
                 }
             }
                
            }
            while((i+1<n-2)&&(nums[i+1]==nums[i]))
            {
                i++;
            }
        }
        return res;
    }
    public int trap_Trapping_rainwaterthree_Sum_SDE_LINKED_LIST_15(int[] height) {
        int l=0;
        int r=height.length-1;
        int leftmost=0;
        int rightmost=0;
        int res=0;
        while(l<r)
        {
            if(height[l]<=height[r])
            {
                if(height[l]>=leftmost)
                {
                    leftmost=height[l];
                }
                else{
                    res+=leftmost-height[l];
                }
                l++;
            }
            else{
                if(height[l]>=height[r])
                {
                  if(height[r]>=rightmost)
                  {
                      rightmost=height[r];
                  }
                  else{
                      res+=rightmost-height[r];
                  }
                  r--;
                }
            }
        }
        return res;
    }
    public int removeDuplicates_Sum_SDE_LINKED_LIST_16(int[] nums) {
        int i=0;
        int j=i+1;
        int n=nums.length;
        while(j<n)
        {
            if(nums[i]!=nums[j])
            {
                i++;
                nums[i]=nums[j];
                
            }
            j++;
        }
        return i+1;
    }
    static class nodek{
        int si;
        int fi;
        int pi;
        nodek(int si,int fi,int pi)
        {
            this.si=si;
            this.fi=fi;
            this.pi=pi;
        }
    }
    static class ok implements Comparator<nodek>
    {
      @Override
      public int compare(nodek p1, nodek p2) {
        // TOD
         if(p1.fi<p2.fi)
         {
             return -1;
         }
         else{
             if(p1.fi>p2.fi)
             {
                 return 1;
             }
             else{
                 if(p1.pi<p2.pi)
                 {
                     return -1;
                 }
             }
         }
         return 1;
       }
    }
    int maxMeetings_N_meeting_in_one_room_SDE_LINKED_LIST_16(int start[], int end[], int n) {
        PriorityQueue<Integer> k=new PriorityQueue<>();
            
        // Your code here
        List<nodek> m=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            m.add(new nodek(start[i], end[i], i+1));
        }
        Collections.sort(m,new ok());
        int count=1;
        int last=m.get(0).fi;
        for(int i=0;i<m.size();i++)
        {
            if(m.get(i).si>last)
            {
                count++;
                last=m.get(i).fi;
            }
        }
        return count;
    }
    public int Greedy_algorithm_to_find_minimum_number_of_Coins_SDE_LINKED_LIST_17(int[] coins, int amount) {
        int n=coins.length;
        int v=amount;
        Arrays.sort(coins);
        int count=0;
        for(int i=n-1;i>=0;i--)
        {
            while(v>=coins[i])
            {
                v-=coins[i];
                count++;
            }
        }
        if(v==0)
        {
          return count;  
        }
            
        return -1;
    }
    static class Job{
    int id,profit,deadline;
    Job(int x,int y,int z)
    {
        this.id=x;
        this.deadline=y;
        
        this.profit=z;
    }
    }
    static int[] JobScheduling_SDE_LINKED_LIST_18(Job arr[], int n){
        // Your code here
        Arrays.sort(arr,(a,b)->b.profit-a.profit);//sorting the jobs in descending order
        int max=arr[0].deadline;
        for(int i=1;i<n;i++)
        {
            if(arr[i].deadline>max)
            {
                max=arr[i].deadline;
            }
        }
       // System.out.println("Max= "+max);
        int[] dd=new int[max];
        Arrays.fill(dd,-1);
        for(int i=0;i<n;i++)
        {
           int index_in_d=arr[i].deadline-1;
           int ori_in=index_in_d;
           while(index_in_d!=-1&&dd[index_in_d]!=-1)
           {
              index_in_d--;   
           }
           if(index_in_d!=-1)
           {
           dd[index_in_d]=arr[i].profit;
           }
          
            
        }
        int count=0;
        int sum=0;
        for(int i=0;i<max;i++)
        {
            if(dd[i]!=-1)
            {
                count++;
                sum+=dd[i];
            }
        }
       // System.out.println(count+" "+sum);
        int[] ans=new int[2];
        ans[0]=count;
        ans[1]=sum;
        return ans;
        
    }
    static int one_by_Nth_root_of_an_integer_use_binary_search_square_root_cube_root_Binary_search_Divide_and_conquer_1(int num,int n)
    {
      int low=1,high=num;//what ever the root value it will be inbetween the low and high numbers
      while(low<=high)
      {
          int mid=(low+high)/2;
          int res=1;
          for(int i=1;i<=n;i++)
          {
              res*=mid;
          }
          if(res==num)
          {
              return mid;
          }
          else{
              if(res>num)
              {
                  high=mid-1;
              }
              else{
                  low=mid+1;
              }
          }
      }
      
      return -1;
    }
    static int find_Matrix_Median_Median_Divide_and_conquer_2(int[][] A) {
    
        int min,max;
        int noOfr=A.length;
        int noOfc=A[0].length;
        min=Integer.MAX_VALUE;
        for(int i=0;i<noOfr;i++)
        {
            min=Integer.min(min, A[i][0]);
        
        }
        max=Integer.MIN_VALUE;
        for(int i=0;i<noOfr;i++)
        {
            System.out.println(A[i][noOfc-1]);
            max=Integer.max(max, A[i][noOfc-1]);
        }
        int mid;
        int count=0;
        int desired=(noOfc*noOfr+1)/2;
        while(min<max)
        {
           mid=(min+max)/2;
           count=0;
           for(int i=0;i<noOfr;i++)
           {
            ArrayList<Integer> aa= new ArrayList<Integer>(A[i].length);
            for (int ele : A[i])
            {
                aa.add(ele);
            }
            System.out.println("count of nos less than or equal to --mid"+"mid= "+mid+" count ="+lowerbound_and_upperbound.upper_bound(aa, mid) +" row ="+i);
               count+=lowerbound_and_upperbound.upper_bound(aa, mid);
           }
           if(count<desired)
           {
               min=mid+1;
           }
           else{
               max=mid;
           }
        }
        return min;

    }   
    public int singleNonDuplicate_Find_the_element_that_appears_once_in_sorted_array_and_rest_element_appears_twice_Divide_and_conquer_3(int[] arr) {
        int n=arr.length;
          if(n<=0)
        {
            return -1;
        }
       int low=0;
       int high=n-1;
       int mid=0;
       while(low<high)
       {
           mid=(low+high)/2;
           if(mid%2==0)
           {
               if(arr[mid]!=arr[mid+1])
               {
                   high=mid;
               }
               else{
                   low=mid+2;
               }
           }
           else{
               if(arr[mid]==arr[mid+1])
               {
                   high=mid-1;
               }
               else{
                   low=mid+1;
               }
           }
       }
       return arr[low];
    }
    
    public int search_Search_element_in_a_sorted_and_rotated_array_find_pivot_where_it_is_rotatedDivide_and_conquer4_varian_1(int[] nums, int target) {
        int k=target;
        int low=0;
        int high=nums.length-1;
        int mid=0;
        if(nums.length==1)
        {
            if(nums[0]==k)
            {
                return 0;
            }
            else{
                return -1;
            }
        }
        while(low<=high)
        {
            mid=(low+high)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            if(nums[0]<=nums[mid])
            {
              if(nums[0]<=k&&k<=nums[mid])
              {
                  high=mid-1;
              }
                else{
                    low=mid+1;
                }
              
            }
            else
            {
                if(nums[mid]<=k&&k<=nums[nums.length-1])
                {
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            
        }
        if(low>=nums.length||nums[low]!=k)
        {
            return -1;
        }
        return low;
    }
    static int search_Search_element_in_a_sorted_and_rotated_array_find_pivot_where_it_is_rotatedDivide_and_conquer4_varian_2(int[] nums, int target) {
        int k=target;
        int low=0;
        int high=nums.length-1;
        int mid=0;
        if(nums.length==1)
        {
            if(nums[0]==k)
            {
                return 0;
            }
            else{
                return -1;
            }
        }
        while(low<=high)
        {
           
            mid=(low+high)/2;
            System.out.println("low= "+low+" high="+high+" mid= "+mid);
            
            if(nums[mid]==target)
            {
                return mid;
            }
            
           if(nums[low]==nums[mid])
            {
                System.out.println("vva");
                low++;
                continue;
            }
            
            if(nums[0]<nums[mid])
            {
              if(nums[0]<=k&&k<=nums[mid])
              {
                  System.out.println("j high ="+high);
                  high=mid-1;
              }
                else{
                    System.out.println("j low= "+low);
                    low=mid+1;
                }
              
            }
            else
            {
                if(nums[mid]<=k&&k<=nums[nums.length-1])
                {
                    System.out.println("t low="+low);
                    low=mid+1;
                }
                else{
                    System.out.println("t high="+high);
                    high=mid-1;
                }
            }
            
        }
        if(low>=nums.length||nums[low]!=k)
        {
            System.out.println("low= "+low+" high= "+high);
            return -1;
        }
        return low;
    }
    static int countNegatives(int[][] grid) {
        int count=0;
        int N=grid.length;
        int M=grid[0].length;
        for(int i=0;i<N;i++)
        {
            int low=0;
            int high=M-1;
            int mid=0;
            while(low<=high)
            {
                
                    mid=(low+high)/2;
                
                    if(grid[i][mid]<0)
                    {
                        high=mid-1;
                    }
                    else{
                        low=mid+1;
                    }
                
            }
            System.out.println("i= "+i+" low= "+low);
            count+=M-low;
        }
        return count;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res=new ArrayList<>();
        if(intervals.length==0||intervals==null)
        {
            res.add(new int[]{newInterval[0],newInterval[1]});
            return res.toArray(new int[0][res.size()]);
        }
      //  boolean flag=false;
        int[] temp=new int[2];
        temp[0]=newInterval[0];
        temp[1]=newInterval[1];
        for(int i=0;i<intervals.length;i++)
        {
           if(intervals[i][1]<temp[0])
           {
               res.add(new int[]{intervals[i][0],intervals[i][1]});
           }
           else{
               if(temp[1]<intervals[i][0])  
               {
                   res.add(new int[]{temp[0],temp[1]});
               temp[0]=intervals[i][0];
               temp[1]=intervals[i][1];
               }
               else{
                   temp[0]=Integer.min(temp[0], intervals[i][0]);
                   temp[1]=Integer.max(temp[1], intervals[i][1]);     
            }
           }
            
        }
      // System.out.println("temp[0]= "+temp[0]+" temp[1]= "+temp[1]);
        
        res.add(new int[]{temp[0],temp[1]});
        //Collections.sort(res,(a,b)->a[0]-b[0]);
      
       
        return res.toArray(new int[0][res.size()]);
    }
    public double findMedian_of_two_SortedArrays_Divide_and_Conquer_Median_of_two_sorted(int[] nums1, int[] nums2) {
        // time - O(log(min(nums1,nums2)))
        if(nums1.length > nums2.length) {//we are doing this to get the binary search time complexity to be on the smaller array thus we get O(log(min(nums1,nums2)))
            return findMedian_of_two_SortedArrays_Divide_and_Conquer_Median_of_two_sorted(nums2,nums1);
        }
        int l=0,r=nums1.length;
        int combinedelementslength=(nums1.length+nums2.length+1)/2;
        while(l<=r) {
            int partx = (l+r)/2;//the both partx and party values after their calculations give an index(but that is actually the count of no of ele)
            int party= combinedelementslength-partx;//we calculate party value using partx value

            int firstleft = partx != 0 ? nums1[partx-1] : Integer.MIN_VALUE; //if the partx==0 means we are not gona take any elemnts from the partion as consideration and that time the firstleft will be right and the firstright will be nums1[partx](1 position next) ..we come across this situation when we take the party(patiosion y will be having all the elemnts that is to be presented left (n/2) size of the resultant array)
            int firstright = partx != nums1.length ? nums1[partx] : Integer.MAX_VALUE;//if the partx==nums1.length we took the entire array as a partion and that time the first right will point to the Integer.MAX_VALUE as our firstleft points to nums1[partx]

            int secondleft = party != 0 ? nums2[party-1] : Integer.MIN_VALUE;//same as first array it happens here also
            int secondright = party != nums2.length ? nums2[party] : Integer.MAX_VALUE;
            
            if(firstleft <= secondright && secondleft <= firstright) {//we are checking the partion that we made is right
                // we found the right partition
                if((nums1.length + nums2.length) % 2 == 0) {
                    return (double) (Math.max(firstleft,secondleft)+Math.min(firstright,secondright))/2;
                }
                else
                    return (double) Math.max(firstleft,secondleft);
            }
            else 
            {//if the partion we made using the low and high values is wrong we again compute the partion(partx value for the array with less size ) and use that value to compute the party value
                if(firstleft > secondright)
               { r=partx-1;}
            else
               { l=partx+1;}

            }
        }
        return -1;
    }
    
    static int solvey(int[] A) {
        int count=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=A.length;
        if(n==1)
        {
            return 1;
        }
        int l=0,r=1;
        hm.put(A[l],l);
        while(l<n&&r<n)
        {
            if(hm.containsKey(A[r])==false)
            {
              hm.put(A[r],r);
              if(r==n-1)
              {
                  System.out.println("index in Array A"+A[r]);
                  count++;
              }
              
            }
            else{
                int ri=hm.get(A[r]);
               
                if(l<=ri&&ri<=r)
                {
                    System.out.println("A[ri] = "+A[ri]+ " ri = "+ri);
                    System.out.println("gr "+" r = "+r);
                    count++;
                }
                l=r;
                hm.put(A[r],r);
                if(r==n-1)
                {
                    System.out.println("mk "+" r = "+r);
                    count++;
                }
               // hm.put(A[r],r);
            }
            r++;
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
             System.out.println(entry.getKey()+" : "+entry.getValue());
       }
        
       return count;
        
    }

    static 

    public static void main(String[] args)
    {
      
      int[] A={4,3,4,3,1,4};
      
    
    
     // int B=2;
      System.out.println(solvey(A));
     
   }
}
