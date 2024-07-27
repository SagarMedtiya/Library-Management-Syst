package org.airtribe.book;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
public class LibraryInventory {
    private List<Book> books;
        public LibraryInventory() {
            this.books = new ArrayList<>();
        }
        public void addBook(Book book) {
            books.add(book);
        }
        public void removeBook(String isbn){
            books.removeIf(book -> book.getIsbn().equals(isbn));
        }
        public void updateBook(String isbn, Book updatedBook){
            Optional<Book> bookOpt = books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst();
            bookOpt.ifPresent(book ->{
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPublicationYear(updatedBook.getPublicationYear());
            });
        }

        public List<Book> searchByTitle(String title){
            return books.stream().filter(book -> book.getTitle().contains(title)).toList();
        }
        public List<Book> searchByAuthor(String author){
            return books.stream().filter(book -> book.getTitle().contains(author)).toList();
        }
        public Optional<Book> searchByIsbn(String isbn){
            return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst();
        }
}
