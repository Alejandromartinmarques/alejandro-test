package com.bcnc.alejandrotest.application.provider;

import java.util.List;
import java.util.UUID;

import com.bcnc.alejandrotest.domain.Price;

/**
 * This interface provide prices to application layer
 */
public interface PricesProvider {

    /**
     * Find prices of all the products
     * 
     * @return
     */
    public List<Price> findPricesOfProducts(); // TODO falta el concepto de la paginación

    /**
     * This method provide page of all persisted prices of a single product
     * 
     * @param productId id of product
     * @return Persisted prices of a single product
     */
    public List<Price> findPricesByProduct(UUID productId); // TODO falta el concepto de la paginación

    /**
     * Find the current price of a product
     * 
     * @param productId id of product
     * @return current price of a product
     */
    public Price findCurrentPriceOfProductByProductId(UUID productId);

}
