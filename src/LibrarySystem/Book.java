package Day6.LibrarySystem;

public class Book {
    private String title;
    private String name;
    private String isbn;
    private boolean fictional;

    public Book(String title, String name, String isbn) {
        this.title = title;
        this.name = name;
        this.isbn = isbn;
    }

    public void setFictional(boolean fictional) {
        this.fictional = fictional;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void updateIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateTitle(String name) {
        this.name = name;
    }
    public boolean isFictional(){
         return this.fictional;
    }
}
