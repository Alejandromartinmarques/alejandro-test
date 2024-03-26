package com.bcnc.alejandrotest.adapter.inbound.rest.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bcnc.alejandrotest.adapter.inbound.rest.dto.PriceFilterRequest;
import com.bcnc.alejandrotest.domain.PriceFilter;

/**
 * This converter class uses mapstruct to convert PriceFilterDto to Price filter (domain object).
 * 
 * @author Alejandro Martin Marques
 */
@Mapper(componentModel = "spring")
public interface PriceFilterRequestToPriceFilterConverter {

    @Mapping(source = "pageFilter.page", target = "pageFilter.page")
    @Mapping(source = "pageFilter.pageSize", target = "pageFilter.pageSize")
    @Mapping(source = "product", target = "idProduct")
    PriceFilter priceFilterDtoToPriceFilter(PriceFilterRequest priceFilterRequest);    
}
