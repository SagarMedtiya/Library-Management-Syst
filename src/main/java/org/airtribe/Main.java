package org.airtribe;

import org.airtribe.book.Book;
import org.airtribe.book.LibraryInventory;
import org.airtribe.lendingService.LendingService;
import org.airtribe.patron.Patron;
import org.airtribe.patron.PatronManagement;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LibraryInventory libraryInventory = new LibraryInventory();
        PatronManagement patronManagement = new PatronManagement();
        LendingService lendingService = new LendingService(libraryInventory, patronManagement);

        // Adding books
        Book book1 = new Book("Effective Java", "Joshua Bloch", "1234567890", 2008);
        Book book2 = new Book("Clean Code", "Robert C. Martin", "0987654321", 2008);
        libraryInventory.addBook(book1);
        libraryInventory.addBook(book2);

        // Adding patrons
        Patron patron1 = new Patron("Sagar", "1");
        Patron patron2 = new Patron("Sumit", "2");
        patronManagement.addPatron(patron1);
        patronManagement.addPatron(patron2);

        // Checkout and return process
        lendingService.checkoutBook("1234567890", "1");
        lendingService.returnBook("1234567890");

        // Logging book search
        logger.info("Searching for books by title 'Effective Java': " + libraryInventory.searchByTitle("Effective Java"));
        logger.info("Searching for books by author 'Robert C. Martin': " + libraryInventory.searchByAuthor("Robert C. Martin"));
    }
}