package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryUser {
    private String firstName;
    private String lastName;
    private String peselId;
    private List<Book> booksInHandsOf = new ArrayList<>();

    public LibraryUser(String firstName, String lastName, String peselId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselId = peselId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPeselId() {
        return peselId;
    }

    public List<Book> getBooksInHandsOf() {
        return booksInHandsOf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryUser that = (LibraryUser) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(peselId, that.peselId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, peselId);
    }

    @Override
    public String toString() {
        return "LibraryUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", peselId='" + peselId + '\'' +
                '}';
    }

    public boolean rentABook(Book book){
        return booksInHandsOf.add(book);
    }

    public int returnAllBooks(){
        if(booksInHandsOf.size() == 0) return 0;
        int numberOfBooksToReturn = booksInHandsOf.size();
        for (Book book : booksInHandsOf){
            book.setAvailable(false);
        }
        booksInHandsOf.clear();
        return numberOfBooksToReturn;
    }
}
