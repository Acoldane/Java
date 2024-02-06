package CollaborativeStoryTeller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int progress = 1;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        CollaborativeStoryTellerServices collaborativeStoryTellerServices = new CollaborativeStoryTellerServices();
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("story.txt"))) {
            progress = collaborativeStoryTellerServices.writeSequences(objectOutputStream, progress);

            int choice1 = 0;
            Map<Integer, Integer> votes = new HashMap<>();
            do {
                do {
                    System.out.println("Please choose an option");
                    System.out.println("1 to display the whole story");
                    System.out.println("2 to add some lines to the story");
                    System.out.println("3 to display the most voted sentence");
                    System.out.println("4 to vote for a sentence");
                    System.out.println("5 to get the sentences of a specific user");
                    System.out.println("6 to exit");
                    try {
                        choice1 = sc.nextInt();
                    } catch (InputMismatchException e) {
                        e.getStackTrace();
                    }
                } while (choice1 < 1 || choice1 > 6);
                sc.nextLine();
                switch (choice1) {
                    case 1:
                        collaborativeStoryTellerServices.displayAllSequences(collaborativeStoryTellerServices.getAllSequences());
                        break;
                    case 2:
                        progress = collaborativeStoryTellerServices.writeSequences(objectOutputStream,progress);
                        break;
                    case 3:
                        collaborativeStoryTellerServices.getTheMostVotedSequence(votes);
                        break;
                    case 4:
                        votes = collaborativeStoryTellerServices.voteBestSequence(votes);
                        break;
                    case 5:
                        String author;
                        do {
                            System.out.println("Please enter the name of the author");
                            author = sc.nextLine();
                        } while (author == null || author.isEmpty());
                        collaborativeStoryTellerServices.displaySequencesByAuthor(collaborativeStoryTellerServices.getAllSequences(), author);
                        break;
                    case 6:
                        return;
                }
            } while (true);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
