package com.ferry.bank.service;

import com.ferry.bank.mapper.ClientMapper;
import com.ferry.bank.model.Client;
import com.ferry.bank.model.dtos.ClientDto;
import com.ferry.bank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends AbstractService<Client, ClientDto, Long> {
    private final ClientMapper clientMapper;

    @Autowired
    protected ClientService(ClientMapper clientMapper, ClientRepository clientRepository) {
        super(clientRepository, ClientDto.class, Client.class);
        this.clientMapper = clientMapper;
    }

    @Override
    protected ClientDto toDTO(Client entity) {
        return clientMapper.toDto(entity);
    }

    @Override
    protected Client toEntity(ClientDto dto) {
        return clientMapper.toEntity(dto);
    }
}
