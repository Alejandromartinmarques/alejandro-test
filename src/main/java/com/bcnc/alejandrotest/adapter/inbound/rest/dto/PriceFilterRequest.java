package com.bcnc.alejandrotest.adapter.inbound.rest.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This DTO class contains a filter to apply in prices search.
 * 
 * @author Alejandro Martin Marques
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PriceFilterRequest {

    private PaginationFilterDto pageFilter;
    private Long product;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
}