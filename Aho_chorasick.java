import java.util.*;

public class Aho_chorasick {
    public class vertex{
        public  HashMap<Character,Integer> children;
        public boolean leaf;
        public int parent;
        public char parentchar;
        public int suffixlink;
        public int Endofwordlink;
        int wordid;
        public vertex(){
          this.children=new HashMap<>();
          this.leaf=false;
          this.parent=-1;
          this.suffixlink=-1;
          this.Endofwordlink=-1;
          this.wordid=-1;
        }
    }
    ArrayList<vertex> Trie;
    ArrayList<Integer> wordlength;
    int root=0;
    int size=0;
    public Aho_chorasick()
    {
        this.Trie=new ArrayList<>();
        this.wordlength=new ArrayList<>();
        this.Init();
    }
    public void Init()
    {
        //Adding the root node and increasing the size by 1
        Trie.add(new vertex());
        size++;
    }
    public void addString(String string,int wordid)
    {
      int curvertex=root;
      for(int i=0;i<string.length();i++)
      {
        if(!Trie.get(curvertex).children.containsKey(string.charAt(i)))
        {
           Trie.add(new vertex());
           Trie.get(size).suffixlink=-1;
           Trie.get(size).parent=curvertex; 
           Trie.get(size).parentchar=string.charAt(i);
           Trie.get(curvertex).children.put(string.charAt(i),size);//from the curvertex we are storring the index of the new char into the hashmap
           size++;//And then we are incresing its size by 1
        }
        curvertex=Trie.get(curvertex).children.get(string.charAt(i));//and making the curvertex to point to the node/vertex that we entered recently
      }
      Trie.get(curvertex).leaf=true;//After all the characters of the words completely entered  into the trie we need to make the last node/vertex into True
      Trie.get(curvertex).wordid=wordid;//we need to make the wordid of the last node into the wordid that we passed
      wordlength.add(string.length());//we are storeing the word lengths of the pattern in the order in which we entered to the trie
    }
    public void prepare_Aho_tree()
    {
        //here we will traverse the nodes of the array in the bfs fassion to find each nodes suffix/broken links and EndwordLinks/output links
        Queue<Integer> vertexQueue=new LinkedList<>();//we are making new queue where we enter all the nodes/vertexes 
        vertexQueue.add(root);//we initially add the root node and start the traversal from that node
        while(vertexQueue.size()>0)
        {
            int curvertex=vertexQueue.remove();
            calculate_suffix_links_endword_links(curvertex);
            for(char key:Trie.get(curvertex).children.keySet())
            {
                //we iterate over all the child vertexex of each node and add them into the vertexQueue
                vertexQueue.add((int)Trie.get(curvertex).children.get(key));//we are getting the index of each of the char value that we get while itereating
            } 
        }
    }
   public void calculate_suffix_links_endword_links(int vertex)
    {
        if(vertex==root)
        {
            //if the vertex that we are currently in is root then its suffix and endword link will always poinnt to root itself
            Trie.get(vertex).suffixlink=root;
            Trie.get(vertex).Endofwordlink=root;
            return;
        }
        if(Trie.get(vertex).parent==root)
        {
            //if the vertex that we passed whose parent is root then its suffixlink is root
            Trie.get(vertex).suffixlink=root;
            if(Trie.get(vertex).leaf)
            {
                Trie.get(vertex).Endofwordlink=root;
            }
            else{
                Trie.get(vertex).Endofwordlink=Trie.get(Trie.get(vertex).suffixlink).Endofwordlink;
            }
            return;
        }
        //If the all above cases failed then we need to follow the steps by going to the parent node and then go its sufflix link node and check for parent char..we do this process iteratively
        int currentBettervertex=Trie.get(Trie.get(vertex).parent).suffixlink;
        char par_char=Trie.get(vertex).parentchar;
        while(true)
        {
            if(Trie.get(currentBettervertex).children.containsKey(par_char))
            {
                //So if that parrent character exists from that parent nodes sufflix link node then we do this
                Trie.get(vertex).suffixlink=(int)Trie.get(currentBettervertex).children.get(par_char);
                break;
            }
            if(currentBettervertex==root)
            {
                //if we get initially itself root or while iterating if we get root
                Trie.get(vertex).suffixlink=root;
                break;
            }
            currentBettervertex=Trie.get(vertex).suffixlink;//we go to the suffix links and keep on checking until we get that par_char or reach root
        }
        if(Trie.get(vertex).leaf)
        {
            //if the current vertex/node that we passed if it is leaf then we make that endwordlink to point to the vertex itself
            Trie.get(vertex).Endofwordlink=vertex;
        }
        else{
            //if the node that we passed is not an leaf that is node the end of the word then its endword can be found like this
            Trie.get(vertex).Endofwordlink=Trie.get(Trie.get(vertex).suffixlink).Endofwordlink;
        }
    }
    public ArrayList<Integer> process_String(String Text)
    {
       int currentstate=root;
       ArrayList<Integer> result=new ArrayList<>();//here we will add the indexes of the matching of patterns into the text
       for(int j=0;j<Text.length();j++)
       {
           while(true)
           {
            //we do this in a while loop because when a particular character from a node is not present then we move to its suffix links node and keep on repeating the process
            if(Trie.get(currentstate).children.containsKey(Text.charAt(j))==true)
            {
              //if That vertex/node have the index of the character that we are iterating then we change the current state to that character node
              currentstate=Trie.get(currentstate).children.get(Text.charAt(j));
              break;
            }
            if(currentstate==root)
            {
                //if the currentstate that we are in if its a root then we do a break
                break;  
            }
            currentstate=Trie.get(currentstate).suffixlink;//we do this wehen all the above cases failed and that particular character is not present from that node
           }
          int checkstate=currentstate;//when ever we are in a node we check whether the node that its endwordlink points to..if that node is a leaf ..then we increase the result and the number of words that is been matched will also be increased
          while(true)
          {
              checkstate=Trie.get(checkstate).Endofwordlink;
              if(checkstate==root)
              {
                  //if the checkstate is root then means there is no end word from that node
                  break;
              }
              //so if we reach this line which means we are in the node where there is endword /or the complete pattern is present so we add it to result .....we are defenetly in the leaf node
              int index_of_match=j+1-(wordlength.get(Trie.get(checkstate).wordid));//so since we are in the leaf node we will be having the wordid ..using which we can go to the wordlength arraay and find the length of the pattern with that id...using which we generate its matching index
              result.add(index_of_match);
              checkstate=Trie.get(checkstate).suffixlink;//then we again start iterating to find any futher more complete pattern words from this state
          }
       }
       return result;
    }
    public static void main(String[] args)
    {
        String txt="asddfefcdfwefa";
        ArrayList<String> patterns=new ArrayList<>();
        patterns.add("asd");
        patterns.add("fcd");
        patterns.add("few");
        patterns.add("fwe");
        Aho_chorasick aho=new Aho_chorasick();
        for(int i=0;i<patterns.size();i++)
        {
            aho.addString(patterns.get(i),i);
        }
        aho.prepare_Aho_tree();
       ArrayList<Integer> res= aho.process_String(txt);
       for(int i=0;i<res.size();i++)
       {
           System.out.print(res.get(i)+" ");
       }
    }

}
