package com.ferry.bank.mapper;

import com.ferry.bank.model.Feature;
import com.ferry.bank.model.dtos.FeatureDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FeatureMapper extends EntityMapper<Feature, FeatureDto> {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Feature partialUpdate(FeatureDto featureDto, @MappingTarget Feature feature);
}