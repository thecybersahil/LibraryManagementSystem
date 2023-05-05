// This code defines two classes: Book and Library. Book contains the information about a single book, 
// while Library contains the list of books and methods for adding, removing, and searching for books.

// The main method of the LibraryManagement class serves as the user interface, 
// allowing users to interact with the library by adding, removing, and searching for books.

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int isbn;

    public Book(String title, String author, int isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(int isbn) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getIsbn() == isbn) {
                books.remove(i);
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchBook(String title) {
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().equals(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Library Management System.");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Search book");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nEnter book title:");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    System.out.println("Enter book author:");
                    String author = scanner.nextLine();
                    System.out.println("Enter book ISBN:");
                    int isbn = scanner.nextInt();
                    library.addBook(new Book(title, author, isbn));
                    break;
                case 2:
                    System.out.println("\nEnter book ISBN to remove:");
                    int removeIsbn = scanner.nextInt();
                    library.removeBook(removeIsbn);
                    break;
                case 3:
                    System.out.println("\nEnter book title to search:");
                    scanner.nextLine();
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice.");
                    break;
            }
        }
        scanner.close();
    }
}
