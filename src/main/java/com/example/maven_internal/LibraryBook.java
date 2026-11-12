
package com.example.maven_internal;

import java.util.HashMap;
import java.util.Map;

public class LibraryBook {

    private Map<Integer, Book> books = new HashMap<>();

    static class Book {
        int id;
        String title;
        boolean available;

        Book(int id, String title) {
            this.id = id;
            this.title = title;
            this.available = true;
        }
    }

    // Add a book
    public boolean addBook(int id, String title) {
        if (books.containsKey(id)) {
            return false;
        }

        books.put(id, new Book(id, title));
        return true;
    }

    // Search for a book
    public String searchBook(int id) {
        Book book = books.get(id);

        if (book == null) {
            return null;
        }

        return book.title;
    }

    // Issue a book
    public boolean issueBook(int id) {
        Book book = books.get(id);

        if (book == null || !book.available) {
            return false;
        }

        book.available = false;
        return true;
    }

    // Return a book
    public boolean returnBook(int id) {
        Book book = books.get(id);

        if (book == null || book.available) {
            return false;
        }

        book.available = true;
        return true;
    }

    // Check book availability
    public boolean isAvailable(int id) {
        Book book = books.get(id);

        return book != null && book.available;
    }

    public static void main(String[] args) {

        LibraryBook library = new LibraryBook();

        System.out.println("Library Book Management System");

        System.out.println("Adding Book: " +
                library.addBook(101, "Java Programming"));

        System.out.println("Searching Book: " +
                library.searchBook(101));

        System.out.println("Issuing Book: " +
                library.issueBook(101));

        System.out.println("Book Available: " +
                library.isAvailable(101));

        System.out.println("Returning Book: " +
                library.returnBook(101));

        System.out.println("Book Available: " +
                library.isAvailable(101));
    }
}
