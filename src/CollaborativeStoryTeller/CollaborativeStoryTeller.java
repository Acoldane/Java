package CollaborativeStoryTeller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class CollaborativeStoryTeller implements Serializable{
    ArrayList<StoryLine> storyLines = new ArrayList<>();

    public ArrayList<StoryLine> getStoryLines() {
        return storyLines;
    }

    public void setStoryLines(ArrayList<StoryLine> storyLines) {
        this.storyLines = storyLines;
    }

    public CollaborativeStoryTeller(ArrayList<StoryLine> storyLines) {
        this.storyLines = storyLines;
    }

    public CollaborativeStoryTeller(){}

    public void addStoryLines(ArrayList<StoryLine> storyLines){
        this.storyLines.addAll(storyLines);
    }

}

