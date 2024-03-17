package com.bcnc.alejandrotest.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

/**
 * This domain class represent the concept of product in this project.
 * 
 * @author Alejandro Martin Marques
 */
@Builder
@Data
public class Product {

    private Long id; 
    private String name;
    private LocalDate creationDate;
    private ProductStatus status;
    private Brand brand;
    private BigDecimal price;

}
