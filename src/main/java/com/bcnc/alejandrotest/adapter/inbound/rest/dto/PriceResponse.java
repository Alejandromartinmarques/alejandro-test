package com.bcnc.alejandrotest.adapter.inbound.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This DTO class represents a Price object what we want to return or recive on rest requests.
 * @author Alejandro Martin Marques
 */
@Data
@AllArgsConstructor
public class PriceResponse {

    private Long id;
    private Long priority;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startAplicableDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endAplicableDate;
    private BigDecimal amount;
    private String currency;
}
