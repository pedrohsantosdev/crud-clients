package com.example.clientes.controller;

import com.example.clientes.dto.ClientResponseDTO;
import com.example.clientes.dto.ClientResquestDTO;
import com.example.clientes.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<Page<ClientResponseDTO>> findAll(Pageable pageable) {
        Page<ClientResponseDTO> clientsResponseDto = clientService.findAll(pageable);
        return ResponseEntity.ok().body(clientsResponseDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientResponseDTO> findById(@PathVariable Long id) {
        ClientResponseDTO clientResponseDTO = clientService.findById(id);
        return ResponseEntity.ok().body(clientResponseDTO);
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> insert(@Valid @RequestBody ClientResquestDTO clientResquestDTO) {
        ClientResponseDTO clientResponseDTO = clientService.insert(clientResquestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(clientResponseDTO.id()).toUri();
        return ResponseEntity.created(uri).body(clientResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ClientResquestDTO clientResquestDTO) {
        ClientResponseDTO clientResponseDTO = clientService.update(id, clientResquestDTO);
        return ResponseEntity.ok().body(clientResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
