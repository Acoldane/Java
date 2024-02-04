import javax.management.openmbean.KeyAlreadyExistsException;
import javax.naming.NameNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListChallenge {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> menu = new ArrayList<>();

    public static void initialize(){
        menu.add("Coffee");
        menu.add("Tea");
        menu.add("toast");
        menu.add("Juice");
    }

    public static void addSomeFoodInTheMenu()throws KeyAlreadyExistsException{
        String suggestion;
        do {
            System.out.println("Please enter a suggestion to expand our coffee shop's menu");
            suggestion = sc.nextLine();
            if (menu.contains(suggestion)){
                throw new KeyAlreadyExistsException("This article already exist in the menu");
            }
            else {
                menu.add(suggestion);
                break;
            }
        }while(suggestion.isEmpty());
    }
    public static void removeAnElementFromTheMenu() throws NameNotFoundException {
        String objectToRemove;
        do {
            System.out.println("Please enter the element you want to remove from our coffee shop's menu");
            objectToRemove = sc.nextLine();
            if (!menu.contains(objectToRemove)) {
                throw new NameNotFoundException("This element doesn't exist in the menu");
            } else {
                menu.remove(objectToRemove);
                break;
            }
        } while (objectToRemove.isEmpty());
    }

    public static void checkElementExistence() {
        String element;
        do {
            System.out.println("Please enter the element you want to find in our coffee shop's menu");
            element = sc.nextLine();
            if (!menu.contains(element)) {
                System.out.println("This element doesn't exist in the menu");
            } else {
                System.out.println("The element exist in the menu ");
            }
        } while (element.isEmpty());
        sc.nextLine();
    }

    public static void displayAllElementsOfTheMenu(){
        System.out.println("Our Menu");
        for(String element : menu){
            System.out.println(element);
        }
    }
    public static void main(String[] args){
        initialize();
        try {
            addSomeFoodInTheMenu();
        }catch (KeyAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
        try {
            removeAnElementFromTheMenu();
        }catch (NameNotFoundException e){
            System.out.println(e.getMessage());
        }
        checkElementExistence();
        displayAllElementsOfTheMenu();
    }
}
