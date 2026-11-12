
package com.example.maven_internal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryBookTest {

    private LibraryBook library;

    @BeforeEach
    public void setUp() {
        library = new LibraryBook();
        library.addBook(101, "Java Programming");
    }

    // Test 1: Adding and searching for a book
    @Test
    public void testAddAndSearchBook() {
        assertTrue(library.addBook(102, "Python Programming"));
        assertEquals("Python Programming",
                library.searchBook(102));
    }

    // Test 2: Handling duplicate book IDs
    @Test
    public void testDuplicateBookID() {
        assertFalse(library.addBook(101, "C Programming"));
        assertEquals("Java Programming",
                library.searchBook(101));
    }

    // Test 3: Issuing an available book
    @Test
    public void testIssueAvailableBook() {
        assertTrue(library.issueBook(101));
        assertFalse(library.isAvailable(101));
    }

    // Test 4: Issuing an already-issued book
    @Test
    public void testIssueAlreadyIssuedBook() {
        library.issueBook(101);
        assertFalse(library.issueBook(101));
    }

    // Test 5: Returning an issued book
    @Test
    public void testReturnBook() {
        library.issueBook(101);
        assertTrue(library.returnBook(101));
    }

    // Test 6: Updating book availability after return
    @Test
    public void testAvailabilityAfterReturn() {
        library.issueBook(101);
        library.returnBook(101);
        assertTrue(library.isAvailable(101));
    }
}
