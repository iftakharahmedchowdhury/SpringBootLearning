package dev.jpapractice.Controller;

import dev.jpapractice.Service.LibraryService;
import dev.jpapractice.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("api/library")
    public List<Library> getAll(){
        return libraryService.getAll();
    }

    @GetMapping("api/library/{name}")
    public List<Library> searchLibraryByName(@PathVariable String name) {
        return libraryService.getLibrariesByName(name);
    }

    @PostMapping("api/library")
    public String addLibrary(@RequestBody Library library){

        libraryService.addLibrary(library);
        return "Successfully added";

    }
    @PutMapping("api/library/{name}")
    public List<Library> updateByName(@PathVariable("name") String name, @RequestBody Library library) {

        libraryService.updateLibrariesByName(name, library);
        return searchLibraryByName(library.getName());

    }
    @DeleteMapping("api/library/{name}")
    public String DeleteLibrary(@PathVariable String name) {
         libraryService.DeleteLibraryByName(name);
        return "successfull";
    }


}
