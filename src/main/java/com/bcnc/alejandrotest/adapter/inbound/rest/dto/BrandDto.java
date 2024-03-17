package com.bcnc.alejandrotest.adapter.inbound.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This DTO class represents a Brand object what we want to return or recive on rest requests.
 * @author Alejandro Martin Marques
 */
@Data
@AllArgsConstructor
public class BrandDto {
    private String id;
    private String name;
}
