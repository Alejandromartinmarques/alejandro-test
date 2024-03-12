package com.bcnc.alejandrotest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represent the brand domain object in the application
 * 
 * @author Alejandro Martin Marques
 */
@Data
@AllArgsConstructor
public class Brand {

    private String id;
    private String name;
}
