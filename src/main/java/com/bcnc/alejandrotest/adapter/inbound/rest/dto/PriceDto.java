package com.bcnc.alejandrotest.adapter.inbound.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This DTO class represents a Price object what we want to return or recive on rest requests.
 * @author Alejandro Martin Marques
 */
@Data
@AllArgsConstructor
public class PriceDto {
    private Long id;
    private LocalDateTime startAplicableDate;
    private LocalDateTime endAplicableDate;
    private Long priority;
    private BigDecimal ammount;
}
