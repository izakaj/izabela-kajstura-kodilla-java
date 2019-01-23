package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MedianAdapterTestSuite {
    @Test
    public void testPublicationYearMedian() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Mikołaj Rej", "Żywot człowieka poczciwego",
                1567, "ABC123"));
        bookSet.add(new Book("Gall Anonim", "Kronika polska",
                1113, "DEF456"));
        bookSet.add(new Book("Jan Długosz", "Roczniki",
                1480, "GHI789"));
        bookSet.add(new Book("Jan Kochanowski", "Odprawa posłów greckich",
                1578, "JKL741"));
        bookSet.add(new Book("Joanna Chmielewska", "Zbrodnia w efekcie",
                2013, "MNO852"));
        bookSet.add(new Book("Małgorzata Musierowicz", "Sprężyna",
                2008, "PQR963"));
        bookSet.add(new Book("Katarzyna Puzyńska", "Rodzanice",
                2019, "STU159"));
        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int medianYear = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(1578, medianYear);

    }
}