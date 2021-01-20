import java.util.HashMap;

import org.graalvm.compiler.word.Word;

public class prefix_trie {
   
        class prefix_node{
            char data;//Each node will consist of data
            HashMap<Character,prefix_node> children;//map that holds pairs each of the character will point to a node .
            boolean terminal;//This value says whether a particular node is terminal or not
            int frequency;
            prefix_node(char data)
            {
                this.data=data;
                this.terminal=false;
                this.children = new HashMap<Character, prefix_node>();
                this.frequency=0;
             
            }
        }
        prefix_node root_p;
        prefix_trie()
        {
            this.root_p=new prefix_node('\u0000');
        }
        void insert(String w)
       {
           prefix_node temp_p=root_p;//from the top most node we are going to traverse and move to next nodes and insert the words we want
           for(int i=0;i<w.length();i++)//we are going to traverse through the characters of the word w that we are going to insert into the trie
           {
                char ch=w.charAt(i);
                
              
                if(temp_p.children.get(ch)!=null)//here we are checking whether the hashmap that we have in our node has a key (that is a character) that points to a node 
                {
                      //temp_p.frequency++;
                      temp_p=temp_p.children.get(ch); //if the ith character is already there in the trie we are making the temp to the node that has that particular character
                      temp_p.frequency++;
                }
                else{//when the particular character is not there inside the trie we create a new node that will hold the ch and we will make our current temp's map (ch,(points to the new node))
                prefix_node nnode=new prefix_node(ch);//creating a new node
                
                temp_p.children.put(ch, nnode);//we are making the ch key in the  hashmap points to the new node
                temp_p.frequency++;
                temp_p=nnode;//then we change our temp 
                //temp_p.frequency++;

                }
            }
            
          
           temp_p.terminal=true;//After traversing over all the characters in the above word we are in the last character of the word as the terminal node
        
            
        }   
        int search_unique_prefix_ending_index(String w)
       {
         prefix_node temp=root_p;
  
         for(int i=0;i<w.length();i++)//we are going to each character present in the word
         {
             char ch=w.charAt(i);//we are going to save each character into the ch
            if(temp.children.get(ch)==null)//if the particular character in the hash map points to null then the word is not present in the trie
            {
               // System.out.println("gopi");
              return -1;
            }
            if(temp.frequency<2)
            {
                return w.indexOf(temp.data);
            }
            temp=temp.children.get(ch);//if it is present we keep on moving to next node until the last character in the word
         }
        // System.out.print(w+"="+temp.data+" "+"freq="+temp.frequency+" ");
         if(temp.frequency<2)
         {
            return w.indexOf(temp.data);
         }
       return -1;

       }

       public static void main(String[] args)
       {
      prefix_trie t=new prefix_trie();
        String[] words={"cobra","dog","dove","duck","cobras"};
       for(int i=0;i<words.length;i++)
      {
         t.insert(words[i]);
       }    
       for(int i=0;i<words.length;i++)
       {
           System.out.println(t.search_unique_prefix_ending_index(words[i]));
       }



    }
}
