package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment){
        List<Book> bookList = new ArrayList<>();
        if(titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);
        if(resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }

    public boolean rentABook(LibraryUser libraryUser, Book book){
        if (book.getAvailable() == true){
            book.setAvailable(false);
            return libraryUser.rentABook(book);
        } else {
            return false;
        }
    }

    public int returnBooks(LibraryUser libraryUser){
        return libraryUser.returnAllBooks();
    }

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        return libraryDatabase.listBooksInHandsOf(libraryUser);
    }
}
