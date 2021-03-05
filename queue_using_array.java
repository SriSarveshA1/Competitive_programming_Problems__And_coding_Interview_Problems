public class queue_using_array {
    private int[] data;
    private int size;
    private int front;
    private int rear;
    public queue_using_array()//we can create a queue even without passing the capacity
    {
     data=new int[5];
     front=-1;
     rear=-1;
     size=0;
    }
    public queue_using_array(int capacity)//we can create a queue by passing the capacity that gives the size of a queue by the user
    {
     data=new int[capacity];
     front=-1;
     rear=-1;
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
    public void enqueue(int ele)
    {
        if(size==data.length)
        {
            doublecapacity();
        }
        if(size==0)
        {
            front=0;
            rear=0;
        }
        else
        {
            rear++;
        }
        if(rear>=data.length)//if the rear index gone out of the length of the array but still we are having the room for the the elements in the queue as the size does not exceed
        {
          rear=0;//so we need to enter the data into the queue again from the starting index   
        }
        data[rear]=ele;
        size++;
    }
    private void doublecapacity()
    {
        int[] temp=data;
        data=new int[2*(data.length)];
        int index=0;
        for(int i=front;i<temp.length;i++)
        {
            data[index++]=temp[i];
        }
        for(int i=0;i<=front-1;i++)
        {
            data[index++]=temp[i];   
        }
        front=0;
        rear=temp.length-1;

    }
    public int front() throws queueEmptyException
    {
        if(size==0)
        {
            throw new queueEmptyException();
        }
        return data[front];
    }
    public int dequeue() throws queueEmptyException
    {
        if(size==0)
        {
            throw new queueEmptyException();
        }
        int temp=data[front];
        front++;
        if(front>=data.length)//by keep on deleting the elements from the queue when the front value becomes greater than the data.length that is if we still have some elements in the queue but if we exceed the queue size 
        {
            front=0;//then we again want the front to point to the 0th index
        }
        size--;
        if(size==0)//if size is 0 both front and rear should have 0 as itss value which shows no value in the queue
        {
            front=-1;
            rear=-1;
        }        
        return temp;
    }

}
