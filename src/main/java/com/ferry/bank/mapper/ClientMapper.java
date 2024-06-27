package com.ferry.bank.mapper;

import com.ferry.bank.model.Client;
import com.ferry.bank.model.dtos.ClientDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {AccountMapper.class, CardMapper.class, NewsMapper.class, FeatureMapper.class})
public interface ClientMapper extends EntityMapper<Client, ClientDto> {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Client partialUpdate(ClientDto clientDto, @MappingTarget Client client);
}