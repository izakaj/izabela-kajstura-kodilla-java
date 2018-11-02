package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testLibraryClones(){
        //Given
        Library library = new Library("Main library");
        for(int i = 0; i < 10; i++){
            library.getBooks().add(new Book("Title " + i, "Author " + i,
                    LocalDate.of(2001 + i, i + 1, i + 1)));
        }

        //shallow copy
        Library shallowClonedLibrary = null;
        try{
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Shallow copy of the library.");
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //deep copy
        Library deepClonedLibrary = null;
        try{
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Deep copy of the library.");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().add(new Book("For Whom The Bell Tolls",
                "Ernest Hemingway",
                LocalDate.of(1940, 1, 1)));

        //Then
        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(11, library.getBooks().size());
        Assert.assertEquals(11, shallowClonedLibrary.getBooks().size());
        Assert.assertEquals(10, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(library.getBooks(), shallowClonedLibrary.getBooks());
        Assert.assertNotEquals(library.getBooks(), deepClonedLibrary.getBooks());
    }
}
