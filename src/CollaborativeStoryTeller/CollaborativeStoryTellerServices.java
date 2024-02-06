package CollaborativeStoryTeller;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CollaborativeStoryTellerServices {
    Scanner sc = new Scanner(System.in);
    public int writeSequences(ObjectOutputStream objectOutputStream,int progress) throws IOException {
        String author;
        do{
            System.out.println("Please enter your name");
            author = sc.nextLine();
        }while (author.isEmpty());
        String sequence;
        do{
            System.out.println("Please the line number "+progress+" of the story");
            sequence = sc.nextLine();
        }while (sequence.isEmpty());
        ArrayList<StoryLine> storyLines = new ArrayList<>();
        StoryLine storyLine = new StoryLine(sequence,author,progress);
        storyLines.add(storyLine);
        progress++;
        String choice;
        do {
            do {
                System.out.println("To add another line please enter y, to stop and save please enter s");
                choice = sc.nextLine();
            } while (!choice.equals("y") && !choice.equals("s"));
            if (choice.equals("y")){
                do{
                    System.out.println("Please enter your name");
                    author = sc.nextLine();
                }while (author.isEmpty());
                do{
                    System.out.println("Please the line number "+progress+" of the story");
                    sequence = sc.nextLine();
                }while (sequence.isEmpty());
                StoryLine storyLine1 = new StoryLine(sequence,author,progress);
                storyLines.add(storyLine1);
                progress++;
            }
        }while(!choice.equals("s"));
        CollaborativeStoryTeller collaborativeStoryTeller = new CollaborativeStoryTeller(storyLines);
        objectOutputStream.writeObject(collaborativeStoryTeller);
        return progress;
    }
    
    public CollaborativeStoryTeller getAllSequences() {
        ArrayList<CollaborativeStoryTeller> collaborativeStoryTellers = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("story.txt")) {
            boolean cont = true;
            try (ObjectInputStream input = new ObjectInputStream(fis)) {
                while (cont) {
                    CollaborativeStoryTeller collaborativeStoryTeller = (CollaborativeStoryTeller) input.readObject();
                    if (collaborativeStoryTeller != null) {
                        collaborativeStoryTellers.add(collaborativeStoryTeller);
                    } else {
                        cont = false;
                    }
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        if (!collaborativeStoryTellers.isEmpty()) {
            CollaborativeStoryTeller collaborativeStoryTeller = new CollaborativeStoryTeller();
            for (CollaborativeStoryTeller storyTeller : collaborativeStoryTellers) {
                collaborativeStoryTeller.addStoryLines(storyTeller.getStoryLines());
            }
            return collaborativeStoryTeller;
        }
        return null;
    }

    public void displayAllSequences(CollaborativeStoryTeller collaborativeStoryTeller){
        for (StoryLine storyLine : collaborativeStoryTeller.getStoryLines()){
            System.out.println("Sequence "+storyLine.getProgress()+" : "+storyLine.getSequence()+". Written by "+storyLine.getAuthor());
        }
    }

    public Map<Integer,Integer> voteBestSequence(Map<Integer,Integer> votes){
        int sequenceIndex;
        do {
            System.out.println("Enter the number of the sentence you wishing to vote for");
            sequenceIndex = sc.nextInt();
        }while (sequenceIndex<0);
        sc.nextLine();
        if (votes.containsKey(sequenceIndex)) votes.put(sequenceIndex,votes.get(sequenceIndex)+1);
        else votes.put(sequenceIndex,1);
        return votes;
    }

    public void getTheMostVotedSequence(Map<Integer,Integer> votes){
        if (votes.isEmpty()){
            System.out.println("There's no votes yes");
        }else {
            int maxVotes =0;
            int key=0;
            for (Map.Entry<Integer,Integer> entry : votes.entrySet()){
                if (votes.get(entry.getKey())>maxVotes){
                    maxVotes = votes.get(entry.getKey());
                    key = entry.getKey();
                }
            }
            System.out.println("The most voted sequence is the sequence number "+key);
        }
    }
    public void displaySequencesByAuthor(CollaborativeStoryTeller collaborativeStoryTeller,String author){
        List<StoryLine> storyLines = collaborativeStoryTeller.getStoryLines().stream()
                .filter(storyLine -> storyLine.getAuthor().equals(author))
                .toList();
        if(storyLines.isEmpty()) System.out.println("There is no sequence written by the "+author);
        else {
            for (StoryLine storyLine : storyLines) {
                System.out.println("Sequence " + storyLine.getProgress() + " : " + storyLine.getSequence() + ". Written by " + storyLine.getAuthor());
            }
        }
    }
}
