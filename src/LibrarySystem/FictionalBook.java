package Day6.LibrarySystem;

public class FictionalBook extends Book{

    public FictionalBook(String title, String name, String isbn) {
        super(title, name, isbn);
        this.setFictional(true);
    }
}
