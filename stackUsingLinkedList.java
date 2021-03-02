

public class stackUsingLinkedList<T> {//we need to have LinkedList of generic type{
    private Node<T> head;//we create a head to maintain a pointer that says what is the top most element that we are handling
    private int size;//we maintain a variable called size that holds the size of the stack 
    public stackUsingLinkedList()
    {
       this.head=null;
       this.size=0;
    }
    public int size()
    {
        return size;//we return the size
    }
    public void push(T element)
    {
      Node<T> newnode=new Node<T>(element);//we are creating a new node and making the head point to the newnode
      if(size==0)
      {
          head=newnode;
      }
      newnode.next=head;//each time we want the newnode's next pointer to point the head pointers
      size++;
      head=newnode;//then we are again updating the head value to the newnode
    }
    public T pop() throws StackEmptyException
    {
       if(size==0||head==null)
       {
         throw new StackEmptyException();   
       }   
       T d=head.data;
       head=head.next;//we need to move the head pointer to its next node
       size--;
       return d;
    }
    public T top() throws StackEmptyException
    {
        if(size==0||head==null)
        {
          throw new StackEmptyException();   
        }   
        T d=head.data;
        return d;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
}
