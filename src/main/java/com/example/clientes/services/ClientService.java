package com.example.clientes.services;

import com.example.clientes.dto.ClientResponseDTO;
import com.example.clientes.dto.ClientResquestDTO;
import com.example.clientes.entities.Client;
import com.example.clientes.repositories.ClientRepository;
import com.example.clientes.services.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional(readOnly = true)
    public Page<ClientResponseDTO> findAll(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        Page<ClientResponseDTO> clientsResponseDto = clients.map(client -> new ClientResponseDTO(client));
        return clientsResponseDto;
    }

    @Transactional(readOnly = true)
    public ClientResponseDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new ClientResponseDTO(client);
    }

    @Transactional
    public ClientResponseDTO insert(ClientResquestDTO clientResquestDTO) {
        Client client = new Client(null, clientResquestDTO.name(), clientResquestDTO.cpf(),
                clientResquestDTO.income(), clientResquestDTO.birthDate(), clientResquestDTO.children());
        clientRepository.save(client);
        return new ClientResponseDTO(client);
    }

    @Transactional
    public ClientResponseDTO update(Long id, ClientResquestDTO clientResquestDTO) {
        Client currentClient = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        updateClient(currentClient, clientResquestDTO);
        clientRepository.save(currentClient);
        return new ClientResponseDTO(currentClient);
    }

    @Transactional
    public void delete(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        clientRepository.delete(client);
    }

    private void updateClient(Client currentClient, ClientResquestDTO clientResquestDTO) {
        currentClient.setName(clientResquestDTO.name());
        currentClient.setCpf(clientResquestDTO.cpf());
        currentClient.setIncome(clientResquestDTO.income());
        currentClient.setBirthDate(clientResquestDTO.birthDate());
        currentClient.setChildren(clientResquestDTO.children());
    }
}
