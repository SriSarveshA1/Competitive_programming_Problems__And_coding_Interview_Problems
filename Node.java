public class Node<T> {//we create a generic class where <T> is the type of data that we need to pass <T> is where we pass the type of the data
    T data;//By using this generic type of class we can implement any type of stack 
    Node<T> next;
    Node(T data)
    {
        this.data=data;
        this.next=null;//we give the next pointer to point the null
    }
    
}
