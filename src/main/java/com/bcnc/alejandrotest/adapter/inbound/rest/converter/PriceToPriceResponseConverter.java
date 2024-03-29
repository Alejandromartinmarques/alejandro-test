package com.bcnc.alejandrotest.adapter.inbound.rest.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bcnc.alejandrotest.adapter.inbound.rest.dto.PriceResponse;
import com.bcnc.alejandrotest.domain.Price;

/**
 * This converter class use mapstruct to convert Price (domain object) to PriceDto.
 * 
 * @author Alejandro Martin Marques
 */
@Mapper(componentModel = "spring")
public interface PriceToPriceResponseConverter {
    
    @Mapping(source = "priorityScore", target = "priority")
    PriceResponse priceToPriceDto(Price price);

    /**
     * This converter method is necessary to convert a list of elements with mapstruct
     * @param prices list of prices (domain object) to convert
     * @return
     */
    List<PriceResponse> pricesToPriceDtos(List<Price> prices);

}
