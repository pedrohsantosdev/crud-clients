package com.example.clientes.dto;

import com.example.clientes.entities.Client;

import java.time.LocalDate;

public record ClientResponseDTO(
        Long id,
        String name,
        String cpf,
        Double income,
        LocalDate birthDate,
        Integer children
) {

    public ClientResponseDTO {
    }

    public ClientResponseDTO(Client client) {
        this(client.getId(), client.getName(), client.getCpf(), client.getIncome(),
                client.getBirthDate(), client.getChildren());
    }
}
