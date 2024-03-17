package com.bcnc.alejandrotest.application.provider;

import java.util.List;

import com.bcnc.alejandrotest.domain.Price;
import com.bcnc.alejandrotest.domain.PriceFilter;

/**
 * This interface provide prices
 * 
 * @author Alejandro Martin Marques
 */
public interface PricesProvider {

    /**
     * Find prices by dynamic filter
     * @param priceFilter Filter
     * @return
     */
    public List<Price> findPricesByPriceFilter(PriceFilter priceFilter); 

    /**
     * Find the current price of a product
     * 
     * @param productId id of product
     * @return current price of a product
     */
    public Price findCurrentPriceOfProductByProductId(Long productId);

}
