import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LinkedListChallenges {
    static Scanner sc = new Scanner(System.in);
    static LinkedList<Integer> linkedList = new LinkedList<>();

    public static void initialize(){
        linkedList.add(5);
        linkedList.add(9);
        linkedList.add(8);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(3);
        linkedList.add(18);
        linkedList.add(9);
    }
    public static void addNode(){
        System.out.println("Please enter a number");
        try {
            int number = sc.nextInt();
            linkedList.add(number);
            System.out.println("You have added "+number+" to the list");
        }catch (InputMismatchException e){
            System.out.println("Wrong input");
        }
    }

    public static void removeNode(){
        try {
            int number = linkedList.remove();
            System.out.println("We have deleted "+number+" from the list");
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    public static void length(){
        try {
            System.out.println("The size of the list is "+linkedList.size());
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    public static void reverseList(){
        LinkedList<Integer> reversedLinkedList = new LinkedList<>();
        for (int i=0;i< linkedList.size();i++){
            reversedLinkedList.add(linkedList.getLast());
            linkedList.removeLast();
            i--;
        }
        System.out.println("The reversed list is "+ reversedLinkedList);
    }

    public static void isListEmpty(){
        if (linkedList.isEmpty()){
            System.out.println("The list is empty");
        }else System.out.println("The list is not empty");
    }

    public static void main(String[] args){
        initialize();
        addNode();
        removeNode();
        length();
        reverseList();
        isListEmpty();
    }
}
