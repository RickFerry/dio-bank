package com.ferry.bank.service;

import com.ferry.bank.mapper.ClientMapper;
import com.ferry.bank.model.Client;
import com.ferry.bank.model.dtos.ClientDto;
import com.ferry.bank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        return clientMapper.toEntity(entity);
    }

    @Override
    protected Client toEntity(ClientDto dto) {
        return clientMapper.toDto(dto);
    }

    @Override
    protected ClientDto toDto(Client entity) {
        return clientMapper.toEntity(entity);
    }

    @Override
    protected List<Client> toEntity(List<ClientDto> dtoList) {
        return clientMapper.toDto(dtoList);
    }

    @Override
    protected List<ClientDto> toDto(List<Client> entityList) {
        return clientMapper.toEntity(entityList);
    }

    @Override
    protected Set<ClientDto> toDto(Set<Client> entityList) {
        return entityList.stream()
                .map(clientMapper::toEntity)
                .collect(Collectors.toSet());
    }
}
