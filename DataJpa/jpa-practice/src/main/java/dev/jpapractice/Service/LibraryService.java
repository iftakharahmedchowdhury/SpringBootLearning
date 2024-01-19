package dev.jpapractice.Service;

import dev.jpapractice.Repo.LibraryRepo;
import dev.jpapractice.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepo libraryRepo;

    public LibraryService(LibraryRepo libraryRepo) {
        this.libraryRepo = libraryRepo;
    }

    public List<Library> getAll() {
        return libraryRepo.findAll();
    }


    public String addLibrary(Library library) {

        libraryRepo.save(library);

        return "Successfully added";
    }

    public List<Library> getLibrariesByName(String name) {
        return libraryRepo.findByName(name);
    }


   public void updateLibrariesByName(String name, Library library) {
       libraryRepo.updateByName(name, library);
   }


    public void DeleteLibraryByName(String name) {
       libraryRepo.deleteByName(name);
    }

    public Optional<Library> findById(Long id) {
       return libraryRepo.findById(id);
    }
}
