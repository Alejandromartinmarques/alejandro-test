package com.bcnc.alejandrotest.adapter.outbound.persistance.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bcnc.alejandrotest.adapter.outbound.persistance.entity.PriceEntity;
import com.bcnc.alejandrotest.domain.Price;

/**
 * This converter class use mapstruct to convert PriceEntity to Price (domain object).
 * 
 * @author Alejandro Martin Marques
 */
@Mapper(componentModel = "spring")
public interface PriceEntityToPriceConverter {
    
    @Mapping(source = "startDate", target = "startAplicableDate")
    @Mapping(source = "endDate", target = "endAplicableDate")
    Price priceEntityToPrice(PriceEntity priceEntity);

    /**
     * This converter method is necessary to convert a list of elements with mapstruct
     * @param priceEntities list of price entities to convert
     * @return
     */
    List<Price> priceEntitiesToPrices(List<PriceEntity> priceEntities);

    
} 