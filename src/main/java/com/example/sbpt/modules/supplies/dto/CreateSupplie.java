package com.example.sbpt.modules.supplies.dto;

import com.example.sbpt.modules.supplies.models.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CreateSupplie {

    @NotBlank
    private String name;

    @NotBlank
    private int quantity;

    @NotNull
    private  Category category;
}
