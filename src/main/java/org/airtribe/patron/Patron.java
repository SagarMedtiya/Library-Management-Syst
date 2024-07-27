package org.airtribe.patron;

import org.airtribe.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private String id;
    private List<Book> borrowingHistory;

    public Patron(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowingHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Book> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void setBorrowingHistory(List<Book> borrowingHistory) {
        this.borrowingHistory = borrowingHistory;
    }
    public void addBorrowingHistory(Book book) {
        borrowingHistory.add(book);
    }
    @Override
    public String toString(){
            return "Patron{" + "name='" + name +'\'' + ", id" + id + '\'' + ", borrowingHistory=" + borrowingHistory + '}';
    }
}
