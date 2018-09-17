package com.kodilla.testing.library;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity){
        List<Book> resultList = new ArrayList<>();
        for(int i = 1; i <= booksQuantity; i++){
            Book theBook = new Book("Title " + i, "Author " + i, 1970 + i);
            resultList.add(theBook);
        }
        return resultList;
    }

    // testy z przykładu Kodilli

    @Test
    public void testListBooksWithConditionsReturnList(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret Life of Programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        //Then
        Assert.assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        //Then
        Assert.assertEquals(0, theListOfBooks0.size());
        Assert.assertEquals(15, theListOfBooks15.size());
        Assert.assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Books);

        //When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        //Then
        Assert.assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    // poniżej test, którego chyba oczekują po mnie w tym zadaniu

    @Test
    public void testListBooksInHandsOf(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser1 = new LibraryUser("John", "Smith", "12345678910");
        LibraryUser libraryUser2 = new LibraryUser("Mary", "Smith", "01234567891");
        LibraryUser libraryUser3 = new LibraryUser("James", "Smith", "10123456789");
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf1Book = generateListOfNBooks(1);
        List<Book> resultListOf5Books = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1)).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser2)).thenReturn(resultListOf1Book);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser3)).thenReturn(resultListOf5Books);

        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksInHandsOf(libraryUser1);
        List<Book> theListOfBooks1 = bookLibrary.listBooksInHandsOf(libraryUser2);
        List<Book> theListOfBooks5 = bookLibrary.listBooksInHandsOf(libraryUser3);

        //Then
        Assert.assertEquals(0, theListOfBooks0.size());
        Assert.assertEquals(1, theListOfBooks1.size());
        Assert.assertEquals(5, theListOfBooks5.size());
    }

    // poniżej inne testy, które zrobiłam już sama dla siebie:

    @Test
    public void testRentABookAvailable(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        Book book = new Book("Gone with the Wind", "Margaret Mitchell", 1936);
        List<Book> expectedList = new ArrayList<>();
        expectedList.add(book);
        LibraryUser libraryUser = new LibraryUser("John", "Smith", "12345678910");
        book.setAvailable(true);

        //When
        boolean result = bookLibrary.rentABook(libraryUser, book);
        List<Book> bookResultList = libraryUser.getBooksInHandsOf();

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(expectedList, bookResultList);
    }

    @Test
    public void testRentABookUnavailable(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        Book book = new Book("Gone with the Wind", "Margaret Mitchell", 1936);
        LibraryUser libraryUser = new LibraryUser("John", "Smith", "12345678910");
        book.setAvailable(false);

        //When
        boolean result = bookLibrary.rentABook(libraryUser, book);
        List<Book> bookResultList = libraryUser.getBooksInHandsOf();

        //Then
        Assert.assertFalse(result);
        Assert.assertTrue(bookResultList.isEmpty());
    }

    @Test
    public void testListBooksInHandsOf0Books(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("John", "Smith", "12345678910");

        //When
        List<Book> resultList = libraryUser.getBooksInHandsOf();

        //Then
        Assert.assertTrue(resultList.isEmpty());
    }

    @Test
    public void testListBooksInHandsOf5Books(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> expectedList = generateListOfNBooks(5);
        LibraryUser libraryUser = new LibraryUser("John", "Smith", "12345678910");
        for(Book book : expectedList){
            bookLibrary.rentABook(libraryUser, book);
        }

        //When
        List<Book> bookResultList = libraryUser.getBooksInHandsOf();

        //Then
        Assert.assertEquals(expectedList, bookResultList);
    }

    @Test
    public void testReturnBooks0Books(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("John", "Smith", "12345678910");

        //When
        int numberOfBooks = bookLibrary.returnBooks(libraryUser);

        //Then
        Assert.assertEquals(0, numberOfBooks);
    }

    @Test
    public void testReturnBooks5Books(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> expectedList = generateListOfNBooks(5);
        LibraryUser libraryUser = new LibraryUser("John", "Smith", "12345678910");
        for(Book book : expectedList){
            bookLibrary.rentABook(libraryUser, book);
        }

        //When
        int numberOfBooks = bookLibrary.returnBooks(libraryUser);
        List<Book> listOfBooks = libraryUser.getBooksInHandsOf();

        //Then
        Assert.assertEquals(5, numberOfBooks);
        Assert.assertTrue(listOfBooks.isEmpty());
    }
}
