package com.bcnc.alejandrotest.adapter.inbound.rest.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;

/**
 * This DTO record contains a pagination information.
 * @author Alejandro Martin Marques
 */
@Data
public class PaginationFilterDto {
    @Positive(message = "page only can be positive number") Integer page ;
    @Positive(message = "pageSize only can be positive number")Integer pageSize; 
}
