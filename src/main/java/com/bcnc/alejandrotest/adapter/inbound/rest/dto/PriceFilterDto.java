package com.bcnc.alejandrotest.adapter.inbound.rest.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * This DTO record contains a filter to apply in prices search.
 * @author Alejandro Martin Marques
 */
public record PriceFilterDto(PaginationFilterDto pageFilter, Long product,   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {}
