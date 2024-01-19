package dev.jpapractice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "book"
)
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_lib_map",
            joinColumns = @JoinColumn(

                    name = "book_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "lib_id",
                    referencedColumnName = "id"
            )
    )
    @JsonManagedReference
    private List<Library> library;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name ="shelf_id",
            referencedColumnName = "id"
    )
    @JsonManagedReference
    private Shelf shelf;




}
