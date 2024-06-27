package com.ferry.bank.mapper;

import com.ferry.bank.model.News;
import com.ferry.bank.model.dtos.NewsDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface NewsMapper {
    News toEntity(NewsDto newsDto);

    NewsDto toDto(News news);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    News partialUpdate(NewsDto newsDto, @MappingTarget News news);
}