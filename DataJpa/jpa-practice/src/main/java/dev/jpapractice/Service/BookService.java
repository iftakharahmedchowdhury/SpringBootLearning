package dev.jpapractice.Service;

import dev.jpapractice.DTOs.BookDto;
import dev.jpapractice.DTOs.LibraryDto;
import dev.jpapractice.Repo.BookRepo;
import dev.jpapractice.Repo.ShelfRepo;
import dev.jpapractice.model.Book;
import dev.jpapractice.model.Library;
import dev.jpapractice.model.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private LibraryService libraryService;
    @Autowired
    private ShelfRepo shelfRepo;

    public BookService(BookRepo bookRepo, LibraryService libraryService) {
        this.bookRepo = bookRepo;
        this.libraryService = libraryService;
    }

    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    public void addBook(BookDto bookDto) {
        Book newBook = new Book();
        newBook.setName(bookDto.getName());
        List<Optional<Library>> libraries = new ArrayList<>();
        for (LibraryDto libraryDto : bookDto.getLibrary()) {
            Optional<Library> library = libraryService.findById(libraryDto.getId());
            libraries.add(library);
        }

        newBook.setLibrary(
                libraries.stream()
                        .flatMap(optional -> optional.map(Stream::of).orElseGet(Stream::empty))
                        .toList()
        );

        Optional<Shelf> shelfOptional = shelfRepo.findById(bookDto.getShelf().getId());
        shelfOptional.ifPresent(shelf -> newBook.setShelf(shelf));


        bookRepo.save(newBook);
    }
}
