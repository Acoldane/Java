package Day7.MusicPlayerSystem.BankingSystem;

public enum CDStatus {
    EMPTY("Empty cd player"),
    INSERTED("Cd inserted");
    private final String status;


    CDStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
