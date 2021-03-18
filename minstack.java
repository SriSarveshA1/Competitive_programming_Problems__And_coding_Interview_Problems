public class minstack {
      /** initialize your data structure here. */
      Stack<Integer> st;
      Stack<Integer> minst;
      public MinStack() {
       st=new Stack<Integer>();
       minst=new Stack<Integer>();       
      }
      
      public void push(int x) {
          st.push(x);
          if(minst.isEmpty()==false)
          {
              if(minst.peek()<x)
              {
                minst.push(minst.peek());
              }
          else
          {   
              minst.push(x);
          }
              
          }
          else{
               minst.push(x);
          }
          
      }
      
      public void pop() {
          st.pop();
          minst.pop();
      }
      
      public int top() {
          
         // minst.peek();
          return st.peek();
      }
      
      public int getMin() {
          return minst.peek();
      }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
