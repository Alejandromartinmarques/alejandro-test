package com.bcnc.alejandrotest.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This domain class represent the concept of price in this project.
 * 
 * @author Alejandro Martin Marques
 */
@Data
@AllArgsConstructor
public class Price {

    private Long id;
    private LocalDateTime startAplicableDate;
    private LocalDateTime endAplicableDate;
    private Long priorityScore;
    private String currency;
    private BigDecimal ammount;

}
