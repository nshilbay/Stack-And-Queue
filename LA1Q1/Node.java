package LA1Q1;

public class Node <T>{
    private T element;
    private Node<T> next;

    //constructor method without parameter
    public Node() {}

    //constructor method with parameters
    public Node(T e, Node<T> n)
    {
        element = e;
        next = n;
    }

    //getter method for the node's element
    public T getElement()
    {
        return element;
    }

    //getter method for the node's pointer
    public Node <T> getNext()
    {
        return next;
    }

    //setter method for the node's pointer
    public void setNext(Node<T> n)
    {
        next = n;
    }

}


