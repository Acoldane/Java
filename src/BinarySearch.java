import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BinarySearch {
    static Scanner sc = new Scanner(System.in);
    static int[] array = {1,3,5,8,9,15,18,22,31,64,88,89,95};
    public static LinkedList<Integer> toLinkedList(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int number :array){
            linkedList.add(number);
        }
        return linkedList;
    }

    public static void main(String[] args){
        System.out.println("Please enter the value you're searching for");
        int value =sc.nextInt();
        int index = toLinkedList().indexOf(value);
        if (index!=-1){
            System.out.println("The index of "+value+" in the array is "+ index);
        }else {
            System.out.println("The value doesn't exist in this array");
        }
    }
}
