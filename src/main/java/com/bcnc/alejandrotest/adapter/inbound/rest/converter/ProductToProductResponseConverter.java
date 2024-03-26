package com.bcnc.alejandrotest.adapter.inbound.rest.converter;

import org.mapstruct.Mapper;

import com.bcnc.alejandrotest.adapter.inbound.rest.dto.ProductResponse;
import com.bcnc.alejandrotest.domain.Product;

/**
 * This converter class use mapstruct to convert Product (domain object) to ProductDto.
 * 
 * @author Alejandro Martin Marques
 */
@Mapper(componentModel = "spring")
public interface ProductToProductResponseConverter {

    ProductResponse productToProductDto(Product product);
    
}
