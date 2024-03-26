package com.bcnc.alejandrotest.domain;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * This domain class is used to represent price information available to filter.
 * 
 * @author Alejandro Martin Marques
 */
@Data
public class PriceFilter {

    PageFilter pageFilter;
    Long idProduct;
    LocalDateTime startDate;
    LocalDateTime endDate;
    LocalDateTime date;
}
