package com.example.sbpt.libro.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CreateBookDto {
    @NotBlank
    private String titulo;

    @NotBlank
    private String isbn;

}
