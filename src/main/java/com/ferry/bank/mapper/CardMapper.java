package com.ferry.bank.mapper;

import com.ferry.bank.model.Card;
import com.ferry.bank.model.dtos.CardDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CardMapper {
    Card toEntity(CardDto cardDto);

    CardDto toDto(Card card);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Card partialUpdate(CardDto cardDto, @MappingTarget Card card);
}