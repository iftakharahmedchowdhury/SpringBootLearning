package dev.jpapractice.Repo;

import dev.jpapractice.model.Library;
import dev.jpapractice.model.LibraryAddress;
import dev.jpapractice.model.LibraryOpeningDetails;
import jakarta.persistence.Id;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryRepoTest {
    @Autowired
private LibraryRepo libraryRepo;

    @Test
    public void addLibrary(){
        LibraryAddress libraryAddress = LibraryAddress.builder()
                .Location("Dhaka")
                .build();
        LibraryOpeningDetails libraryOpeningDetails=LibraryOpeningDetails.builder()
                .openingHours("8am to 8pm")
                .build();

        Library library = Library.builder()
                .name("Y")
                .libraryAddress(libraryAddress)
                .libraryOpeningDetails(libraryOpeningDetails)
                .build();

        libraryRepo.save(library);
    }
@Test
    public void LibryByOD(){
    List<Library> libraries=
            libraryRepo.findLibrariesByLibraryOpeningDetails(
                    new LibraryOpeningDetails(3L)    //for this i need to make a parameteriz constractor which tale id in library opening details model class so that i only can serch library with opening details id . i made it just for learning purpose
            );
    System.out.println("libraries = " + libraries);
}


}