package dev.jpapractice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(
name = "library"
)
public class Library {
@Id
@SequenceGenerator(
        name = "lib_sequence", /*lib_id*/
sequenceName = "lib_sequence",
allocationSize = 1
)
@GeneratedValue(
strategy = GenerationType.SEQUENCE,
generator = "lib_sequence"
)

    private Long id;
    private String name;
    @Embedded
    private LibraryAddress libraryAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lib_open_id", referencedColumnName = "id")
    @JsonManagedReference
    private LibraryOpeningDetails libraryOpeningDetails;


}
