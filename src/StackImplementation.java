import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class StackImplementation {
    static Scanner sc = new Scanner(System.in);
    private static String[] array = {"one","two","three","four"};
    private static Stack<String> stack = new Stack<>();

    public static void initialize(){
        stack.addAll(Arrays.asList(array));
    }
    public static void add(){
        System.out.println("Enter a string to add to the stack");
        String newElement=sc.nextLine();
        stack.add(newElement);
    }
    public static void peek(){
        try {
            System.out.println("The last element in the stack is "+stack.peek());
        }catch (EmptyStackException e){
            System.out.println(e.getMessage());
        }
    }

    public static void pop(){
        try {
            stack.pop();
            System.out.println("The last element of the has been removed, now the new last element is "+stack.peek());
        }catch (EmptyStackException e){
            System.out.println(e.getMessage());
        }

    }

    public static void checkIfEmpty(){
        if(stack.isEmpty()){
            System.out.println("The stack is empty");
        }else System.out.println("The stack is not empty");
    }
    public static void main(String[] args){
        initialize();
        add();
        peek();
        pop();
        checkIfEmpty();
    }
}
