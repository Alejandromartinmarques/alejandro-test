package com.bcnc.alejandrotest.domain;

import lombok.Data;

/**
 * This domain class is used to represent page information to filter.
 * 
 * @author Alejandro Martin Marques
 */
@Data
public class PageFilter {

    Integer page;
    Integer pageSize;
}
