package dev.jpapractice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides(
        @AttributeOverride(
                name = "Location",
column =@Column(name = "lib_add")
        )
)
public class LibraryAddress {
    private String Location;
}
