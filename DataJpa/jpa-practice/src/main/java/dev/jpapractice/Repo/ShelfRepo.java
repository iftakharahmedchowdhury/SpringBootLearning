package dev.jpapractice.Repo;

import dev.jpapractice.model.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShelfRepo extends JpaRepository<Shelf,Long> {


}
