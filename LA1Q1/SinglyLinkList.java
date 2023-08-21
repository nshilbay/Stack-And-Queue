package LA1Q1;

public class SinglyLinkList <T> {
    private Node <T> head;
    private Node<T> tail;
    private int size ;

    //constructor method without parameter
    public SinglyLinkList() {}

    //constructor method with parameters
    public SinglyLinkList(Node <T> h, Node <T> t, int s)
    {
        head = h;
        tail= t;
        size = s;
    }

    //getter method for the size
    public int getSize()
    {
        return size;
    }

    //method to check if the list is empty
    public boolean isEmpty()
    {
        return size == 0;
    }

    //overriding toString method
    public String toString() {
        String result = "";
        Node <T> temp = head; //create a temporary node
        while(temp != null)//keep the loop going while the temporary node isn't null
        {
            result += temp.getElement() + ", ";
            temp = temp.getNext();//this is so the temporary node moves up the stack
        }

        if(isEmpty())
        {
            return "[ ]";
        }

        return String.format("[%s\b\b]", result);
    }


    //adds a node at the head of the linked list and makes it a new head
    public void addFirst(T e)
    {
        head = new Node<> (e, head);
        if (size == 0)//if the list is empty then the tail is equal to the head
        {
            tail = head;
        }
        size++;//increments the size by one
    }

    //adds a node at the tail of the linked list, and makes it a new tail
    public void addLast(T e)
    {
        Node<T> last = new Node<>(e,null);//create a new node to put at the tail
        if(isEmpty())
        {
            head = last;//if the list is empty, the head is equal to the node being added
        }
        else
        {
            tail.setNext(last);
        }
        tail=last;
        size++;//increments size by one
    }

    //removes the tail and returns the element, and then assigns the next one as the new head
    public T removeFirst()
    {
        if(isEmpty())//if the list is empty, there is no node to return
        {
            return null;
        }

        T answer = head.getElement();
        head = head.getNext();//the second element after the original head, becomes the new head
        size--;//decrements the size by one

        if (size == 0)
        {
            tail = null;
        }
        return answer;
    }

    //removes the tail and returns the element, and then assigns the node before the current tail as its new tail
    public T removeLast() {
        T lastElement = null;
        if(isEmpty())
        {
            return null;
        }
        else if(size==1)
        {
            lastElement= head.getElement();
            size--;//decrements the size by one
            head =tail = null;//if the size is one, then the head and the tail which are the same node in this case become null
            return lastElement;
        }
        else
        {
            Node <T> temp = head;
            for(int i =1; i < size; i++)//for loop to go through the list
            {
                if(temp.getNext().getNext() == null)//condition to find second last element
                {
                    lastElement = tail.getElement();
                    temp.setNext(null);
                    tail = temp;
                    size--;//decrements the size by one
                    break;
                }
                temp = temp.getNext();
            }
            return lastElement;
        }

    }

    //push an element to the top of the stack
    public void pushAtHead(T element){
        addFirst(element);
    }

    //pop an element from the top of the stack
    public T popFromHead(){
        return removeFirst();
    }

    //push an element at the tail
    public void pushAtTail(T element){
        addLast(element);
    }

    //pop an element from the tail
    public T popFromTail(){
        return removeLast();
    }

    //add an element at the tail
    public void enqueueAtTail(T element){
        addLast(element);
    }

    //remove an element at the head
    public T dequeueAtHead()
    {
        return removeFirst();
    }

    //search an element in the stack from head to tail
    public int searchStack(T element)
    {
        if (isEmpty()) {//if the list is empty, then return -1
            return -1;
        }

        Node<T> temp = head;//make a temporary node
        int position = 1;//let the starting position at the head be one
        while(temp != null)
        {
            if (temp.getElement() == element)
            {
                return position;
            }
            temp = temp.getNext();
            position++;//increments position by one
        }
        return -1;//return -1 if the element is not found in the stack
    }

}
