import jdk.dynalink.beans.StaticClass;

import java.util.*;

public class QueueImplementation {
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<String> playList = new ArrayList<>();
    public static Queue<String> playListQueue = new LinkedList<>();
    public static void initialize(){
        int choice;
        do {
            System.out.println("Please enter the size of the playlist");
            try {
                choice=sc.nextInt();
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                return;
            }
        }while (choice<1);
        for (int i=1;i<=choice;i++){
            System.out.println("Please enter song number "+ i);
            playList.add(sc.nextLine());
        }
        playListQueue.addAll(playList);
        System.out.println("The queue is " +playListQueue.toString());
    }

    public static void enqueue(){
        System.out.println("Enter the song you want to add");
        String newSong = sc.nextLine();
        playListQueue.add(newSong);
    }

    public static void dequeue(){
        playListQueue.remove();
        System.out.println("We did remove the element in the front , now the size of the playlist is "+playListQueue.size());
    }

    public static void peek(){
        System.out.println("The element in the front of the playlist is "+playListQueue.peek());
    }

    public static void isEmpty(){
        if (playListQueue.isEmpty()){
            System.out.println("The playlist is empty.");
        }else System.out.println("The playlist is not empty");
    }

    public static void main(String[] args){
        initialize();
        enqueue();
        dequeue();
        peek();
        isEmpty();
    }
}
