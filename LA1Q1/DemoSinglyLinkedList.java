package LA1Q1;
import java.util.*;
public class DemoSinglyLinkedList {

    public static Scanner input = new Scanner(System.in);//create a public field of Scanner type

    public static void main(String[] args)//main method
    {
        //call myHeader method
        myHeader(1);

        //declare and initialize a String and boolean variable for whether the user chooses to continue or not
        String continueOrNot = "";
        boolean keepGoing = true;

        //declare and fill an ArrayList type reference variable with Integer-tag
        ArrayList<Integer> numbers = new ArrayList(Arrays.asList(56, -22, 34, 57, 98));

        //declare and fill an ArrayList type reference variable with String-tag
        ArrayList<String> names = new ArrayList(Arrays.asList("Griffin", "Will", "Isra", "Delaney", "Madison"));

        //output the Arraylists
        System.out.println("The given Integer array: " + numbers);
        System.out.println("The given String array: "+ names);

        //declare Linked Lists for integers and people
        SinglyLinkList<Integer> integers = new SinglyLinkList();
        SinglyLinkList<String> people = new SinglyLinkList();

        //populate the Linked List for integers with the addFirst method and the numbers Arraylist
        for(int i = 0; i<numbers.size()-2; i++){
            integers.addFirst(numbers.get(i));
        }
        for(int i = numbers.size()-1; i>2; i--){
            integers.addLast(numbers.get(i));
        }

        //populate the Linked List for String with the addFirst method and the names Arraylist
        for(int i = 0; i<names.size()-2; i++){
            people.addFirst(names.get(i));
        }
        for(int i = names.size()-1; i>2; i--){
            people.addLast(names.get(i));
        }

        //output the integers and people Linked Lists
        System.out.println("Your Integer list: " + integers.toString());
        System.out.println("Your String list: " + people.toString());

        //call the stack demo method
        System.out.println("\nStack demo with Integer linked list...");
        stackDemo(integers);

        //call the queue demo method
        System.out.println("\nQueue demo with the String linked list...");
        queueDemo(people);

        //declare a variable for the integer the user is searching for
        int numToSearch;
        System.out.println("\nLet's search the stack: ");

        //output the current stack
        System.out.println("The current stack: " + integers.toString() + "\n");

        //while loop to allow the user to continue
        while (keepGoing) {

            //user input for the number they wish to find
            System.out.print("Enter the value you are searching for: ");
            numToSearch = input.nextInt();

            //call the searchStack method to find the location of the integer
            int indexFound = integers.searchStack(numToSearch);

            if (indexFound == -1) {//index is -1 if the integer is not in the stack
                System.out.println("The value is not found");
            } else {//otherwise, outputs the location of the integer in the stack
                System.out.printf("Value is found at location %d from the top of the stack\n" , indexFound);
            }

            input.nextLine(); // cleaning buffer

            //asks user whether they want to continue or not
            System.out.println("Do you wish to continue? (Press y to continue or any other key to terminate)");
            continueOrNot = input.nextLine();

            //exits while loop if user clicks on any key other than "y"
            if (!continueOrNot.equals("y")) {
                keepGoing = false;
            }
        }

        //calls myFooter method
        myFooter(1);
    }

    //header method
    public static void myHeader(int labNum) {
        //displays a formatted header
        System.out.printf("======================================\nLab Assignment %d\nPrepared By: Nadeen Shilbayeh\n" +
                "Student Number: 251213277\nGoal of this exercise: Review concepts of linked lists, stacks, and queues using generics and arraylists\n======================================\n", labNum);
    }

    //footer method
    public static void myFooter(int labNum) {
        //displays a formatted footer
        System.out.printf("\n======================================\nCompletion of Lab Assignment %d is successful!" +
                "\nSigning off - Nadeen Shilbayeh\n======================================\n", labNum);
    }


    //stackDemo method
    public static void stackDemo(SinglyLinkList list) {

        int topOrBottom = 0;

        while (true) {
            try {//try-catch block to ensure the user's entry is an integer
                //prompts user to enter which end of the linked list they want to start from
                System.out.println("Which end of the linked list would you like to use as the stack top? Enter 1 for head or 2 for tail: ");
                topOrBottom = input.nextInt();

                //ensures the user enters 1 or 2
                if (!(topOrBottom == 1 || topOrBottom == 2)) {
                    Exception ex = new Exception("Incorrect input");
                    throw ex;
                }
                break;
            } catch (Exception ex) {
                System.out.print("Incorrect input!");
                input.nextLine();
            }
        }

        //if the user chooses the head of the linked list as the stack top
        if (topOrBottom == 1) {
            System.out.println("\nStack Top: Head of the linked list");
            System.out.print("\nLet's pop all the elements from the stack in sequence:\nThe current stack: " + list.toString() + "\n");

            //uses a while loop and the popFromHead method to pop the elements in the list one by one
            while (list.getSize() > 0) {
                System.out.println(list.popFromHead() + " has been popped! The revised stack: " + list.toString());
            }


            System.out.println("\nLet's push 39 and -58 in the stack...");
            System.out.println("The current stack: " + list.toString());

            //uses the pushAtHead method to push 39 into the list
            list.pushAtHead(39);
            System.out.println("After 39 is pushed, the revised stack: " + list.toString());


            //uses the pushAtHead method to push -58 into the list
            list.pushAtHead(-58);
            System.out.println("After -58 is pushed, the revised stack: " + list.toString());


        }
        else { //if the user chooses the tail of the linked list as the stack top
            System.out.println("\nStack Top: Tail of the linked list");
            System.out.print("\n\nLet's pop first three elements from the stack in sequence:\nThe current stack: " + list.toString() + "\n\n");

            //uses a while loop and the popFromTail method to pop three elements from the list
            while (list.getSize() > 2) {
                System.out.println(list.popFromTail() + " has been popped! The revised stack: " + list.toString());
            }

            System.out.println("\nLet's push 39 and -58 in the stack...");
            System.out.println("The current stack: " + list.toString());

            //uses the pushAtTail method to push 39 into the list
            list.pushAtTail(39);
            System.out.println("After 39 is pushed, the revised stack: " + list.toString());

            //uses the pushAtTail method to push -58  into the list
            list.pushAtTail(-58);
            System.out.println("After -58 is pushed, the revised stack: " + list.toString());

        }
    }

    //queueDemo method
    public static void queueDemo(SinglyLinkList list) {
        System.out.println("\nNote: Head is the Q-front, and Tail is the Q-rear\n");
        System.out.println("Let's enqueue Joelle and Lukas in the queue in sequence...\n\nThe current queue: " + list.toString());

        //enqueue Joelle into the list using the enqueueAtTail method
        list.enqueueAtTail("Joelle");
        System.out.println("\nAfter Joelle is enqueued, the revised queue: " + list.toString());

        //enqueue Lukas into the list using the enqueueAtTail method
        list.enqueueAtTail("Lukas");
        System.out.println("After Lukas is enqueued, the revised queue: " + list.toString());


        System.out.println("\nLet's dequeue first three elements from the queue in sequence...\n\nThe current queue: " + list.toString() + "\n");

        //uses a for loop and the dequeueAtHead method to remove three people from the list
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s has been dequeued! The revised queue: ", list.dequeueAtHead());
            System.out.println(list.toString());
        }
    }
}

