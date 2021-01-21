import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.lang.System;
import java.lang.*;
public class trie {
     class node{
        char data;//Each node will consist of data
        HashMap<Character,node> children;//map that holds pairs each of the character will point to a node .
        boolean terminal;//This value says whether a particular node is terminal or not
        int frequency_or_no_of_child_nodes;
        node(char data)
        {
            this.data=data;
            this.terminal=false;
            this.children = new HashMap<Character, node>();
            this.frequency_or_no_of_child_nodes=0;//we need to keep track of how many child nodes //or we are keeping track of how many nodes that are dependent on the current node
         
        }


    }
        node root;//This will hold  the root node value of the TREE which will be \0
         int cnt;// Holds the number of words that is been entered into the trie
        public trie()
        {
            this.root=new node('\u0000');
            this.cnt=0;
        }
        public int numwords(){
            return this.cnt;
        }
       void insert(String w)
       {
           node temp=root;//from the top most node we are going to traverse and move to next nodes and insert the words we want
           for(int i=0;i<w.length();i++)//we are going to traverse through the characters of the word w that we are going to insert into the trie
           {
                char ch=w.charAt(i);
                if(temp.children.get(ch)!=null)//here we are checking whether the hashmap that we have in our node has a key (that is a character) that points to a node 
                {
                      temp.frequency_or_no_of_child_nodes++; // we increment the frequency of the no of nodes depend on the current node
                      temp=temp.children.get(ch); //if the ith character is already there in the trie we are making the temp to the node that has that particular character
                     
                }
                else{//when the particular character is not there inside the trie we create a new node that will hold the ch and we will make our current temp's map (ch,(points to the new node))
                    node nnode=new node(ch);//creating a new node
                    temp.children.put(ch, nnode);//we are making the ch key in the  hashmap points to the new node
                    temp.frequency_or_no_of_child_nodes++;
                    temp=nnode;//then we change our temp 
                    
                }
            
            

           }
           temp.terminal=true;//After traversing over all the characters in the above word we are in the last character of the word as the terminal node
           cnt++;
            
        }
     boolean search(String w)
       {
         node temp=root;
         boolean flag=false;
         for(int i=0;i<w.length();i++)//we are going to each character present in the word
         {
             char ch=w.charAt(i);//we are going to save each character into the ch
            if(temp.children.get(ch)==null)//if the particular character in the hash map points to null then the word is not present in the trie
            {
              return false;
            }
            temp=temp.children.get(ch);//if it is present we keep on moving to next node until the last character in the word
            System.out.println("data = "+temp.data+" no_of_child_nodes_depe = "+temp.frequency_or_no_of_child_nodes);
         }
            if(temp.terminal==false)//if the last character(of the node )  is not terminal node we return fale 
            {
                flag=false;
                
            }
            else{// else true
                flag=true;
            }
         
         return flag;

       }
       void del(String word)
       {
           this.delete(root,word);
       }
       void delete(node root,String w)
       {
           if(w.length()==0) //while we recursively call this delete function again again some part of time it will become 0 lenght as we keep on reducing the lengt of the string
           {
               root.terminal=false;// so the root will be holding the last character node and we are making the terminal value as false
               return;
           }
           node child=root.children.get(w.charAt(0));//we are getting the child node from the given character that is represented in hashmap
           if(child==null)
           { 
            return;//when the child is null then from root no node is pointing to that character so we return
           }
           delete(child,w.substring(1)); // we are keep on reducing the string size and changing the child to point to the next node
          
           if(!child.terminal && child.frequency_or_no_of_child_nodes==0)//we remove a node if and only it doesnt have any child nodes
           {
            //root.children.put(w.charAt(0), null); // from the parent node that is root ..we are making the reference node for that character as null
            root.children.remove(w.charAt(0));
            child=null; //when the particular node is pointing to null it will be removed
            root.frequency_or_no_of_child_nodes--;//as we removed the one of the child of the root.we reduce the number which says for how many children it is dependent
          }
       }

    void ppre(String pre,ArrayList<Character> sw)
    {
        System.out.print(pre+"");
        for(int i=0;i<sw.size();i++)
        {
             System.out.print(sw.get(i));
        }
        System.out.println();
    }
   node prefixsearch_get_the_last_character_node(String pre)
    {
        node start=root;
        for(int i=0;i<pre.length();i++)
        {
            char ch=pre.charAt(i);
            if(start.children.get(ch)==null)
            {
                return null;
            }
            start=start.children.get(ch);
        }

            return start;
    }
    
   void prefix_pprint(node temp,ArrayList<Character> s,int j,String pree)
    {
        if(temp==null)
        {
            
           // System.out.println(s.get(s.size()-1));
            return;
        }
        if(temp.terminal==true)
        {
            ppre(pree,s);
        }
        for (Map.Entry<Character,node> e :temp.children.entrySet())
        {
            if(e.getValue()!=null)
            {
          s.add(e.getValue().data);
        
          temp=e.getValue();
        
          prefix_pprint(temp, s,j+1,pree);
          s.remove(s.size()-1);

            }
            else{
                return;
            }
          
        }
       
        
    }
    void display()
    {
        this.display_1(this.root,"");
    }
    void display_1(node temp,String d)
    {
        //if(temp==null)
        //{
           // return;
       // }
        if(temp.terminal==true)
        {
            String k=d+temp.data;
            System.out.println(k);
        }
        Set<Map.Entry<Character,node>> entrries=temp.children.entrySet(); // Here we are creating an iterable object of the HashMap.
        for(Map.Entry<Character,node> entry:entrries)
        {
            this.display_1(entry.getValue(), d+temp.data);
        }

        
    }
   
    
     public static void main(String[] args) {
  
     trie t=new trie();
     String[] words={"ape","apple","gasu","not","news","gapk"};
     for(int i=0;i<words.length;i++)
     {
         t.insert(words[i]);
     }    
     t.display();
     t.del("news");
     System.out.println();
     t.display();


    
     
 
    }
    
}
