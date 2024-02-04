import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class ExceptionChallenges {

    public static void arrayIndexOutOfBounds(){
        try {
            int[] arr = {2, 3, 5};
            System.out.println("Our array is "+ Arrays.toString(arr));
            int i = arr[5];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("The index is out of bounds");
        }
    }

    public static void numberFormatException(){
        try {
            System.out.println("Please enter a number");
            String str = sc.nextLine();
            int temp = Integer.parseInt(str);
        }catch (NumberFormatException e){
            System.out.println("Cannot cast your input to integer");
        }
    }

    public static void fileNotFoundException(){
        try {
            FileReader fileReader = new FileReader("");
        }catch (FileNotFoundException e){
            System.out.println("The file does not exist");
        }
    }

    public static void customisedExceptionsTest() throws CustomException {
        System.out.println("Please enter a positive integer");
        int number = sc.nextInt();
        if(number<0) throw new CustomException("you entered a negative number");
    }

    public static void nullPointerException(){
        try {
            CustomException customException=null;
            System.out.println(customException.getMessage());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
    public static void userInputValidation(){
        int number;
        try {
            do {
                System.out.println("Please enter a positive integer");
                number = sc.nextInt();
            }while (number<0);
        }catch (Exception e){
            System.out.println("An exception is occurred at the input");
        }
    }

    public static void tryWithResources(){
        try(Scanner fileSc = new Scanner(new File("text.txt"))) {
            do {
                System.out.println(fileSc.nextLine());
            }while (fileSc.hasNext());
        }catch (NoSuchElementException e) {
            System.out.println("There is no such element, maybe the file is empty");
        }catch (IOException e){
            System.out.println("There is an IO exception, maybe the file doesn't exist");
        }
    }
    public static void uncheckedException(){
        try {
            int x =10/0;
        }catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws CustomException {
        int choice;
        do{
            System.out.println("Welcome to exception challenges! Please choose a number between 1 to 8");
            choice = sc.nextInt();
            sc.nextLine();
        }while(choice<1 || choice>8);
        switch (choice){
            case 1 :
                arrayIndexOutOfBounds();
                break;
            case 2 :
                numberFormatException();
                break;
            case 3 :
                fileNotFoundException();
                break;
            case 4 :
                try {
                    customisedExceptionsTest();
                }catch (CustomException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 5 :
                nullPointerException();
                break;
            case 6 :
                userInputValidation();
                break;
            case 7 :
                tryWithResources();
                break;
            case 8 :
                uncheckedException();
                break;
        }
    }
}
