import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class sde_sheet_stack_queues {

    public boolean isValid(char[][] grid,int i,int j)
    {
        if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&grid[i][j]=='1')
        {
            return true;
        }
        return false;
    }
    public class pair <T,F>
    {
        T first;
        F second;
        pair(T first,F second)
        {
            this.first=first;
            this.second=second;
        }

    }
    public int bfs_no_ishlands(char[][] grid,int i,int j)
    {
      Queue<pair<Integer,Integer>> q=new LinkedList<>();
      q.add(new pair<Integer,Integer>(i, j));
      grid[i][j]='0';
      while(q.isEmpty()==false)
      {
          pair<Integer,Integer> it=q.remove();
          int x=it.first;
          int y=it.second;
          if(isValid(grid, x-1, y))
          {
            grid[x-1][y]='0';
            q.add(new pair<Integer,Integer>(x-1,y));
          }
          if(isValid(grid, x+1, y))
          {
            grid[x+1][y]='0';
            q.add(new pair<Integer,Integer>(x+1,y));
          }
          if(isValid(grid, x, y-1))
          {
            grid[x][y-1]='0';
            q.add(new pair<Integer,Integer>(x,y-1));
          }
          if(isValid(grid, x, y+1))
          {
            grid[x][y+1]='0';
            q.add(new pair<Integer,Integer>(x,y+1));
          }
      }
      return 1;
    }
    public int numIslands(char[][] grid) {
      int n=grid.length;
      int m=grid[0].length;
      int count=0;
      for(int i=0;i<n;i++)
      {
          for(int j=0;j<m;j++)
          {
              if(grid[i][j]=='1')
              {
               count+=bfs_no_ishlands(grid,i,j);
              }
          }
      }
      return count;
    }
    class Implement_queue_using_stack {

        /** Initialize your data structure here. */
        Stack<Integer> s1,s2;
        
        public Implement_queue_using_stack(){
            s1=new Stack<>();
            s2=new Stack<>();
        }
        
        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.add(x);
        }
        
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while(s1.size()!=1)
            {
                s2.add(s1.pop());
            }
            int te=s1.pop();
            while(s2.size()!=0)
            {
                s1.add(s2.pop());
            }
            return te;
        }
        
        /** Get the front element. */
        public int peek() {
            while(s1.size()!=1)
            {
                s2.add(s1.pop());
            }
            int te=s1.peek();
            while(s2.size()!=0)
            {
                s1.add(s2.pop());
            }
            return te;
        }
        
        /** Returns whether the queue is empty. */
        public boolean empty() {
            if(s1.empty()==true)
            {
                return true;
            }
            return false;
        }
    }
    class Implement_stack_using_queue {

        /** Initialize your data structure here. */
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        public Implement_stack_using_queue() {
            q1=new LinkedList<>();
            q2=new LinkedList<>();
        }
        
        /** Push element x onto stack. */
        public void push(int x) {
            q1.add(x);
        }
        
        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while(q1.size()!=1)
            {
            q2.add(q1.remove());
            }
            int tr=q1.remove();
            while(q2.size()!=0)
            {
                q1.add(q2.remove());
            }
            return tr;
        }
        
        /** Get the top element. */
        public int top() {
            while(q1.size()!=1)
            {
            q2.add(q1.remove());
            }
            int tr=q1.remove();
            q2.add(tr);
            while(q2.size()!=0)
            {
                q1.add(q2.remove());
            }
            return tr;
        }
        
        /** Returns whether the stack is empty. */
        public boolean empty() {
            if(q1.size()==0)
            {
                return true;
            }
            else{
                return false;
            }
        }
    }
    public static long[] nextLargerElement(long[] arr, int n) { 
        // Your code here
        Stack<Long> s=new Stack<Long>();
        long[] ans=new long[arr.length];
        for(int i=n-1;i>=0;i--)
        {
            while(s.isEmpty()==false&&s.peek()<=arr[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                ans[i]=-1;
            }
            else{
                ans[i]=s.peek();
            }
            s.push(arr[i]);
        }
        return ans;
    } 
    public class pairs<T,F>
    {
      public T first;
      public F second;
      public pairs(T first,F second)
      {
          this.first=first;
          this.second=second;
      }
    }
    public  int orangesRotting(int[][] grid)
    {
      int n=grid.length;//no of rows
      int m=grid[0].length;//no of columns
      Queue<pairs<Integer,Integer>> q=new ArrayDeque<>();
      for(Integer i=0;i<n;i++)
      {
          for(Integer j=0;j<m;j++)
          {
              if(grid[i][j]==2)
              {
                q.add(new pairs<Integer,Integer>(i,j));
              }
              
          }
      }
      q.add(new pairs<Integer,Integer>(-1,-1));
      int count=0;
      while(q.isEmpty()!=true)
      {
        if(q.size()==1)
        {
            break;
        }
        if((q.peek().first==-1)&&(q.peek().second==-1))
        {
         count++;
         pairs<Integer,Integer> er=q.poll();
         q.add(er); 
        }
         pairs<Integer,Integer> p=q.poll();
         int x=p.first;
         int y=p.second;
         if((x+1<n)&&(grid[x+1][y]==1))
         {
          grid[x+1][y]=2;
          q.add(new pairs<Integer,Integer>(x+1, y));
         }
         if((x-1>=0)&&(grid[x-1][y]==1))
         {
             grid[x-1][y]=2;
             q.add(new pairs<Integer,Integer>(x-1, y));
         }
         if((y+1<m)&&(grid[x][y+1]==1))
         {
             grid[x][y+1]=2;
             q.add(new pairs<Integer,Integer>(x, y+1));

         }
         if((y-1>=0)&&(grid[x][y-1]==1))
         {
             grid[x][y-1]=2;
             q.add(new pairs<Integer,Integer>(x,y-1));
         }
         
      }
      for(Integer i=0;i<n;i++)
      {
          for(Integer j=0;j<m;j++)
          {
              if(grid[i][j]==1)
              {
                return -1;
              }
              
          }
      }
      if(count==0)
      {
          return -1;
      }
      else{

          return count;
      }

    }
    public class Node<T,F>
    {
       T data;
       F index;
       Node(T data,F index)
       {
           this.data=data;
           this.index=index;
       }
    }
    public int[] maxSlidingWindow(int[] arr, int k) {
        //ArrayList<Integer> ans=new ArrayList<>();
       
        Deque<Node<Integer,Integer>> dq=new ArrayDeque<>();
        int n=arr.length;
        int[] ans=new int[n-k+1];
        int index=0;
        for(int i=0;i<n;i++)
        {
         while(dq.size()>0&&dq.getLast().data<arr[i])
         {
             dq.removeLast();
         }   
         while(dq.size()>0&&dq.getFirst().index<=i-k)
         {
             dq.removeFirst();
         }
         dq.addLast(new Node<Integer,Integer>(arr[i], i));
         if(i>=k-1)
         {
            // ans.add(dq.getFirst().data);
            ans[index++]=dq.getFirst().data;
         }
        }
        return ans; 
    }
public class Node<T,F> 
    {
        T data;
        F ind;
        public Node(T data,F ind)
        {
            this.data=data;
            this.ind=ind;
        }
    }
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        Stack<Node<Integer,Integer>> st=new Stack<>();
        int[] left=new int[n];
        int[] right=new int[n];
       // int leftindex=0,rightindex=0;
       for(int i=0;i<n;++i)    //Fill left
        {
            if(st.isEmpty())
            {    left[i] = 0;   st.push(new Node(arr[i],i));    }
            else
            {
                while(!st.empty() &&st.peek().data>=arr[i])
                {
                    st.pop();
                }
                left[i] = st.isEmpty()?0:st.peek().ind+1;
                st.push(new Node(arr[i],i));
            }
        }
        while(st.isEmpty()!=true)
        {
            st.pop();
        }
        for(int i=n-1;i>=0;--i)
        {  
             if(st.isEmpty())
            {    right[i] = n-1;   st.push(new Node(arr[i],i));    }
            else
            {
                while(!st.empty() &&st.peek().data>=arr[i])
                {
                    st.pop();
                }
                right[i] = st.isEmpty()?n-1:st.peek().ind-1;
                st.push(new Node(arr[i],i));
            }
        }
        int mx_area = 0;    //Stores max_area
        for(int i=0;i<n;++i)
            mx_area = Integer.max(mx_area,arr[i]*(right[i]-left[i]+1));
        return mx_area;
        
    }
    public static void main(String[] args)
    {
       
        Deque<Integer> r=new ArrayDeque<>();
        

    }
}
