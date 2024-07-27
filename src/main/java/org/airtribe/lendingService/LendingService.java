package org.airtribe.lendingService;

import org.airtribe.book.Book;
import org.airtribe.book.LibraryInventory;
import org.airtribe.patron.Patron;
import org.airtribe.patron.PatronManagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

public class LendingService {
    private static final Logger logger = Logger.getLogger(LendingService.class.getName());
    private LibraryInventory libraryInventory;
    private PatronManagement patronManagement;
    private Map<String, String> borrowedBooks;

    public LendingService(LibraryInventory libraryInventory, PatronManagement patronManagement) {
        this.libraryInventory = libraryInventory;
        this.patronManagement = patronManagement;
        this.borrowedBooks = new HashMap<>();
    }

    public void checkoutBook(String isbn, String patronId) {
        Optional<Book> bookOpt = libraryInventory.searchByIsbn(isbn);
        if (bookOpt.isPresent() && !borrowedBooks.containsKey(isbn)) {
            borrowedBooks.put(isbn, patronId);
            Patron patron = patronManagement.getPatron(patronId);
            patron.addBorrowingHistory(bookOpt.get());
            logger.info("Book checked out: " + isbn + " by Patron: " + patronId);
        } else {
            logger.warning("Book not available for checkout: " + isbn);
        }
    }

    public void returnBook(String isbn) {
        if (borrowedBooks.containsKey(isbn)) {
            borrowedBooks.remove(isbn);
            logger.info("Book returned: " + isbn);
        } else {
            logger.warning("Book not found in borrowed list: " + isbn);
        }
    }

    public boolean isBookBorrowed(String isbn) {
        return borrowedBooks.containsKey(isbn);
    }
}