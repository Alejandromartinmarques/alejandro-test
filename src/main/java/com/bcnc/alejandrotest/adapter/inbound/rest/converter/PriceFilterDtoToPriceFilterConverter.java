package com.bcnc.alejandrotest.adapter.inbound.rest.converter;

import org.mapstruct.Mapper;

import com.bcnc.alejandrotest.adapter.inbound.rest.dto.PriceFilterDto;
import com.bcnc.alejandrotest.domain.PriceFilter;

/**
 * This converter class uses mapstruct to convert PriceFilterDto to Price filter (domain object).
 * 
 * @author Alejandro Martin Marques
 */
@Mapper(componentModel = "spring")
public interface PriceFilterDtoToPriceFilterConverter {
    
    PriceFilter priceFilterDtoToPriceFilter(PriceFilterDto priceFilterDto);    
}
