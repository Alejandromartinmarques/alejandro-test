package com.bcnc.alejandrotest.application.provider;

import java.util.UUID;

import com.bcnc.alejandrotest.domain.Product;

/**
 * This interface provide products to application layer
 */
public interface ProductsProvider {

    /**
     * Method used to return the Product domain information by id
     * 
     * @param productId Id of product
     * @return return a Product domain object
     */
    public Product findProduct(UUID productId);
}
