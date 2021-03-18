import java.util.HashMap;

public class Solution {
    
    class node{
        
      char data;//Each node will consist of data
      HashMap<Character,node> children;//map that holds pairs each of the character will point to a node .
      boolean terminal;//This value says whether a particular node is terminal or not
      int frequency;
      node(char data)
      {
          this.data=data;
          this.terminal=false;
          this.children = new HashMap<Character, node>();
          this.frequency=0;
      }
     }
      node root;
      public Solution()
      {
          this.root=new node('\u0000');
      }
       void insert(String w)
      {
         node temp=root;//from the top most node we are going to traverse and move to next nodes and insert the words we want
         for(int i=0;i<w.length();i++)//we are going to traverse through the characters of the word w that we are going to insert into the trie
         {
              char ch=w.charAt(i);
              if(temp.children.get(ch)!=null)//here we are checking whether the hashmap that we have in our node has a key (that is a character) that points to a node 
              {
                     // we increment the frequency of the no of nodes depend on the current node
                     //temp.frequency++;
                    temp=temp.children.get(ch); //if the ith character is already there in the trie we are making the temp to the node that has that particular character
                    temp.frequency++;
              }
              else{//when the particular character is not there inside the trie we create a new node that will hold the ch and we will make our current temp's map (ch,(points to the new node))
                  node nnode=new node(ch);//creating a new node
                 
                  temp.children.put(ch, nnode);//we are making the ch key in the  hashmap points to the new node
                  temp=nnode;//then we change our temp 
                  temp.frequency=1;
                 
              }
         }
         temp.terminal=true;//After traversing over all the characters in the above word we are in the last character of the word as the terminal node
      }
  
  public  String[] prefix(String[] A) {
      String[] ans=new String[A.length];
      int index=0;
      for(int i=0;i<A.length;i++)
      {
          insert(A[i]);
         
      }
      for(int i=0;i<A.length;i++)
      {
        ans[index++]=p(this.root,A[i]);
      }
      
      return ans;
  }
  public String p(node root,String w)
  {
      node temp=root;
      String emp="";
      temp=temp.children.get(w.charAt(0));
      emp=emp+w.charAt(0);
      if(temp.frequency>1)
      {
      for(int i=1;i<w.length();i++)
      {
        temp=temp.children.get(w.charAt(i));
        if(temp.frequency==1)
        {
            emp+=w.charAt(i);
           // System.out.println("word = "+w+"   "+"emp ="+emp+" temp data= "+temp.data);
            return emp;
        }
        emp+=temp.data; 
      }

      }
    
        //return emp;
   
      return emp;
  }
  public static void main(String[] args)
  { 
      Solution r=new Solution();
      String[] word={ "zebra", "dog", "duck", "dot","zec","apple","ape"};
    
      String[] re=  r.prefix(word);
      for(int i=0;i<re.length;i++)
      {
          System.out.println(re[i]);
      }
      

  }
}
