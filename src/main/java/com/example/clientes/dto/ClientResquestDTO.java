package com.example.clientes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record ClientResquestDTO(

        @NotBlank(message = "Cannot be empty")
        String name,

        @NotBlank(message = "Cpf is sheltering")
        String cpf,

        @PositiveOrZero(message = "The value cannot be negative")
        Double income,

        @PastOrPresent(message = "Cannot be a future date")
        LocalDate birthDate,

        @PositiveOrZero(message = "The field cannot be negative")
        Integer children
) {
}
