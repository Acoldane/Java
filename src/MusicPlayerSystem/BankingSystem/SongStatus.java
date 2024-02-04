package Day7.MusicPlayerSystem.BankingSystem;

public enum SongStatus {
    PAUSE("Pause"),
    PLAY("Play");
    private final String status;


    SongStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
