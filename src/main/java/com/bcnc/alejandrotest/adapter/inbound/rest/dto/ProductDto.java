package com.bcnc.alejandrotest.adapter.inbound.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.bcnc.alejandrotest.domain.ProductStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This DTO class represents a Product object what we want to return or recive on rest requests.
 * @author Alejandro Martin Marques
 */
@Data
@AllArgsConstructor
public class ProductDto {
    
    private Long id; 
    private String name;
    private LocalDate creationDate;
    private ProductStatus status;
    private BrandDto brand;
    private BigDecimal price;
}
