package dev.jpapractice.Repo;

import dev.jpapractice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {
}
