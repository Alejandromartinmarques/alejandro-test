package com.bcnc.alejandrotest.adapter.outbound.persistance.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bcnc.alejandrotest.adapter.outbound.persistance.entity.BrandEntity;
import com.bcnc.alejandrotest.domain.Brand;

/**
 * This converter class use mapstruct to convert BrandEntity to Brand (domain object).
 * 
 * @author Alejandro Martin Marques
 */
@Mapper(componentModel = "spring")
public interface BrandEntityToBrandConverter {
    
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Brand brandEntityToBrand(BrandEntity brandEntity);
}
