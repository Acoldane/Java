package Day6.LibrarySystem;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Library{
    private ArrayList<Book> library= new ArrayList<>();

    public ArrayList<Book> getLibrary() {
        return library;
    }

    public void setLibrary(ArrayList<Book> library) {
        this.library = library;
    }
    public void addBook(Book book){
        this.library.add(book);
    }
    public void addBooks(ArrayList<Book> books){
        this.library.addAll(books);
    }
    public void deleteBook(Book book){
        if(book!=null) {
            this.library.remove(book);
        }else System.out.println("Can't find the book in");
    }
    public int getIndexOfBook(Book book){
        return this.library.indexOf(book);
    }
    public ArrayList<Book> getFictionalBooks(){
        ArrayList<Book> fictionalBooks = new ArrayList<>();
        for (Book book : library){
            if (book.isFictional()){
                fictionalBooks.add(book);
            }
        }
        return fictionalBooks;
    }

    public ArrayList<Book> getNonFictionalBooks(){
        ArrayList<Book> fictionalBooks = new ArrayList<>();
        for (Book book : library) {
            if (!book.isFictional()) {
                fictionalBooks.add(book);
            }
        }
        return fictionalBooks;
    }

    public Book findBookByTitle(String title){
        for(Book book : library){
            if(book.getTitle().equals(title)) return book;
        }
        return null;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;
        do {
            do {
                System.out.println("Welcome to the Library System");
                System.out.println("1- Add book");
                System.out.println("2- Delete book");
                System.out.println("3- Find a book");
                System.out.println("4- get all fictional books");
                System.out.println("5- get all non fictional books");
                System.out.println("6- exit");
                choice = sc.nextInt();
                sc.nextLine();
            } while (choice < 0 || choice > 6);
            switch (choice) {
                case 1:
                    System.out.println("Please enter the book title");
                    String title = sc.nextLine();
                    System.out.println("Please enter the book author name");
                    String author = sc.nextLine();
                    System.out.println("Please enter the book isbn");
                    String isbn = sc.nextLine();
                    String fictional;
                    do {
                        System.out.println("Please press y if the book is fictional and n if it's not.");
                        fictional = sc.nextLine();
                    } while (!fictional.equals("y") && !fictional.equals("n"));

                    if (fictional.equals("y")) {
                        Book book = new FictionalBook(title, author, isbn);
                        library.addBook(book);
                    } else {
                        Book book = new NonFictionalBook(title, author, isbn);
                        library.addBook(book);
                    }
                    break;
                case 2:
                    System.out.println("Please enter the book title.");
                    String title1 = sc.nextLine();
                    library.deleteBook(library.findBookByTitle(title1));
                    break;
                case 3:
                    System.out.println("please enter the book title");
                    String title2 = sc.nextLine();
                    Book book = library.findBookByTitle(title2);
                    System.out.println("Book title : " + book.getTitle());
                    System.out.println("Author name : " + book.getName());
                    System.out.println("isbn : " + book.getIsbn());
                    break;
                case 4:
                    System.out.println("List of fictional books");
                    for (Book book1 : library.getFictionalBooks()) {
                        System.out.println("Book title : " + book1.getTitle());
                        System.out.println("Author name : " + book1.getName());
                        System.out.println("isbn : " + book1.getIsbn());
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("List of non fictional books");
                    for (Book book1 : library.getNonFictionalBooks()) {
                        System.out.println("Book title : " + book1.getTitle());
                        System.out.println("Author name : " + book1.getName());
                        System.out.println("isbn : " + book1.getIsbn());
                        System.out.println();
                    }
                    break;
                case 6:
                    return;
            }
            System.out.println("please press enter to continue");
            sc.nextLine();
        }while (true);
        //ArrayList<>
    }
}
