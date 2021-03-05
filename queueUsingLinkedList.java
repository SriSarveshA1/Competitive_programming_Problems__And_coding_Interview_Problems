import java.util.ArrayDeque;
import java.util.Queue;

public class queueUsingLinkedList <T>{
  private Node<T> front;
  private Node<T> rear;
  private int size;
  public queueUsingLinkedList()
  {
     this.front=null;
     this.rear=null;
     size=0;
  }
  public int size()
  {
      return size;
  }
  public boolean isEmpty()
  {
      return size==0;
  }
  public void enqueue(T elem)
  {
      Queue<Integer> r=new ArrayDeque<>();
      if(front==null&&rear==null)
      {
          Node<T> newnode=new Node<T>(elem);
          front=newnode;
          rear=newnode;
      }
      else{
        Node<T> newnode=new Node<T>(elem);
        rear.next=newnode;
        rear=newnode;
      }
   size++;
  }
  public T dequeue() throws queueEmptyException
  {
      if(front==null)
      {
          throw new queueEmptyException();
      }
      T temp=rear.data;
      front=front.next;
      size--;
      if(size==0)
      {
          front=null;
          rear=null;
      }
      return temp;
  }
  public T front()
  {
      return front.data;
  }
}
