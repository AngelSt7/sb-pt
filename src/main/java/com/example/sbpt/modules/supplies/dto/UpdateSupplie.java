package com.example.sbpt.modules.supplies.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
public class UpdateSupplie {

    @NotBlank
    private UUID id;

    @NotNull
    @Min(5)
    @Max(1000)
    private int quantity;

}
