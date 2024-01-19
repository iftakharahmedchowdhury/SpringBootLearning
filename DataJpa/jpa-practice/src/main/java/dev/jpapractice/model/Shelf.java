package dev.jpapractice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Shelf {
    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    @SequenceGenerator(
            name = "shelf_sequence",
            sequenceName = "shelf_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shelf_sequence"
    )
    private Long id;

    private String name;

    @OneToMany(
            mappedBy = "shelf"
    )
    @JsonBackReference
    private List<Book> books;


}
