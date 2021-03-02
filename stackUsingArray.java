 
public class stackUsingArray {
    private int[] data;//we declare the data array that we use as stack as private cause we dont want any other person to manupulate these contents
    private int topindex;//Even we do the same ..for topindex
    
    public stackUsingArray()
    {
        data=new int[10];
        topindex=-1;
    }
    public void push(int element)
    {
        if(topindex==data.length-1)
        {
            doublecapacity();
        }
        data[++topindex]=element;
    }
    private void doublecapacity()//we want this doublecapacity function to be in private access modifier so no one else can access it 
    {
       int[] temp=data;
       data=new int[2*temp.length];
       for(int i=0;i<temp.length;i++)
       {
           data[i]=temp[i];
       }
    }
    public int size(){
        return topindex+1;
    }
    public int pop() throws StackEmptyException
    {
        if(topindex==-1)
        {
           throw new StackEmptyException();
        }
        int e=data[topindex];
        topindex--;
        return e;
    }
    public int top() throws StackEmptyException
    {
        if(topindex==-1)
        {
           throw new StackEmptyException();
        }
        int e=data[topindex];
        return e;
    }
    public boolean isEmpty()
    {
        return topindex==-1;
    }
    
    public static void main(String[] args)
    {

    }
}
