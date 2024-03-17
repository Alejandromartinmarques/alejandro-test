package com.bcnc.alejandrotest.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bcnc.alejandrotest.application.provider.PricesProvider;
import com.bcnc.alejandrotest.domain.Price;
import com.bcnc.alejandrotest.domain.PriceFilter;

import lombok.RequiredArgsConstructor;

/**
 * This Use Case class contains the search use cases of price.
 * 
 * @author Alejandro Martin Marques
 */
@Service
@RequiredArgsConstructor
public class SearchPricesUseCase {

    //Providers
    private final PricesProvider pricesProvider;

    /**
     * This Use Case method is invoked to find prices by dynamic filter.
     * @param priceFilter Filter
     * @return
     */
    public List<Price> searchPricesByPriceFilterUseCase(PriceFilter priceFilter) {
        return pricesProvider.findPricesByPriceFilter(priceFilter);
    }
}
