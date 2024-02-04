package Day6.LibrarySystem;

public class NonFictionalBook extends Book{
    public NonFictionalBook(String title, String name, String isbn) {
        super(title, name, isbn);
        this.setFictional(false);
    }
}
