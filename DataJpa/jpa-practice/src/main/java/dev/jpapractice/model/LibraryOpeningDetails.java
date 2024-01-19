package dev.jpapractice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibraryOpeningDetails {
    @Id
    @SequenceGenerator(
            name = "lib_open_sequnce",
            sequenceName = "lib_open_sequnce",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lib_open_sequnce"

    )
    private Long id;

    private String openingHours;

    public LibraryOpeningDetails(Long id) { // added for testing jpa and learning purpose. for some testing feature i want to search library by open  opening details id
        this.id = id;
    }
}
