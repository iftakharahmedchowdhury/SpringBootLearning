package dev.jpapractice.Repo;

import dev.jpapractice.model.Library;
import dev.jpapractice.model.LibraryOpeningDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LibraryRepo extends JpaRepository<Library,Long> {

   /* List<Library>findLibrariesByLibraryOpeningDetails_Id(Long OD);*/
List<Library>findLibrariesByLibraryOpeningDetails(LibraryOpeningDetails libraryOpeningDetails);


   List<Library> findByName(String name);

   /* void updateLibrariesByName(String name, Library library);*/

   @Transactional
   @Modifying
   /*@Query("UPDATE Library l SET l = :library WHERE l.name = :name")*/ // not working because Hibernate needs to know how to update each individual field.
   @Query("UPDATE Library l SET l.name = :#{#library.name}, l.libraryAddress = :#{#library.libraryAddress}, l.libraryOpeningDetails = :#{#library.libraryOpeningDetails} WHERE l.name = :name")

   void updateByName(String name, Library library);

   @Transactional
   void deleteByName(String name);


}
