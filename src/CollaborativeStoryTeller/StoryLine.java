package CollaborativeStoryTeller;

import java.io.Serializable;

public class StoryLine implements Serializable {
    private String sequence;
    private String author;
    private int progress;

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public StoryLine(String sequence, String author, int progress) {
        this.sequence = sequence;
        this.author = author;
        this.progress = progress;
    }
}
