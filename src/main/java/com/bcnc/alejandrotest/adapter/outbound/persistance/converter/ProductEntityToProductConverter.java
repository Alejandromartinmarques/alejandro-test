package com.bcnc.alejandrotest.adapter.outbound.persistance.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.bcnc.alejandrotest.adapter.outbound.persistance.entity.ProductEntity;
import com.bcnc.alejandrotest.domain.Product;
import com.bcnc.alejandrotest.domain.ProductStatus;

/**
 * This converter class use mapstruct to convert ProductEntity to Product(domain object).
 * 
 * @author Alejandro Martin Marques
 */
@Mapper(componentModel = "spring", uses = BrandEntityToBrandConverter.class)
public interface ProductEntityToProductConverter {
    
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "creationDate", target = "creationDate")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "brandEntity", target = "brand")
    Product productEntityToProduct(ProductEntity productEntity);

    default String mapProductStatusToString(ProductStatus status) {
        return status.name();
    }

     /**
     * This converter method is necessary to convert a list of elements with mapstruct
     * @param productEntities list of product entities to convert
     * @return
     */
    List<Product> productEntitiesToProducts(List<ProductEntity> productEntities);
}
