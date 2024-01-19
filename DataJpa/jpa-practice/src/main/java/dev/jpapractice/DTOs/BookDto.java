package dev.jpapractice.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class BookDto {
    private String name;
    private List<LibraryDto> library;
    private ShelfDto shelf;
}

