package com.bcnc.alejandrotest.adapter.inbound.rest.dto;

import jakarta.validation.constraints.Positive;

/**
 * This DTO record contains a pagination information.
 * @author Alejandro Martin Marques
 */
public record PaginationFilterDto ( 
    @Positive(message = "page only can be positive number") Integer page ,
    @Positive(message = "pageSize only can be positive number")Integer pageSize) {}
