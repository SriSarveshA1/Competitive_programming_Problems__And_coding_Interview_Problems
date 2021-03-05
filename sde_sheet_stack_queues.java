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

    public static void main(String[] args)
    {
        ArrayList<Integer> r=new ArrayList<>();
        r.ge
        

    }
}
