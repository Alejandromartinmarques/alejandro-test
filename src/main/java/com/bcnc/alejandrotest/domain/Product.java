package com.bcnc.alejandrotest.domain;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

/**
 * This class represent the product domain object in the application
 * 
 * @author Alejandro Martin Marques
 */
@Builder
@Data
public class Product {

    private String id;
    private String name;
    private LocalDate creation;
    private ProductStatus status;
    private Brand brand;
    private Price price;

}
