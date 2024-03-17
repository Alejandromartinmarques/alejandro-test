package com.bcnc.alejandrotest.adapter.inbound.rest.dto;

import lombok.Builder;
import lombok.Data;

/**
 * This DTO class contains error structure to return in rest requests.
 * @author Alejandro Martin Marques
 */
@Data
@Builder
public class RestExceptionDto {
    private String errorType;
    private String errorMessage;
}
