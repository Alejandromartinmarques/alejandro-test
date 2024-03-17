package com.bcnc.alejandrotest.application;

import org.springframework.stereotype.Service;

import com.bcnc.alejandrotest.application.provider.ProductsProvider;
import com.bcnc.alejandrotest.domain.Product;

import lombok.RequiredArgsConstructor;

/**
 * This Use Case class contains the search use cases of price.
 * 
 * @author Alejandro Martin Marques
 */
@Service
@RequiredArgsConstructor
public class SearchProductUseCase {

    //Providers
    private final ProductsProvider productsProvider;

    /**
     * This Use Case method is invoked to search detail information from product.
     * @param productId Id of product
     * @return
     */
    public Product searchProductUseCase(Long productId) {
        return productsProvider.findProduct(productId);
    }

}
