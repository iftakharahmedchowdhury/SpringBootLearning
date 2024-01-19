package dev.jpapractice.Repo;

import dev.jpapractice.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookRepoTest {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private LibraryRepo libraryRepo;
    @Autowired
    private ShelfRepo shelfRepo;

    @Test
    public void addBook() {

        LibraryAddress libraryAddress = LibraryAddress.builder()
                .Location("CTG")
                .build();
        LibraryOpeningDetails libraryOpeningDetails=LibraryOpeningDetails.builder()
                .openingHours("10am to 8pm")
                .build();

        Library library = Library.builder()
                .name("ggggg")
                .libraryAddress(libraryAddress)
                .libraryOpeningDetails(libraryOpeningDetails)
                .build();

        Shelf shelf = Shelf.builder()
                .name("r2")
                .build();

        Book book = Book.builder()
                .name("Adv. DB")
                .library(Collections.singletonList(library))
                .shelf(shelf)
                .build();

        bookRepo.save(book);

        System.out.println("book = " + book);
    }



}