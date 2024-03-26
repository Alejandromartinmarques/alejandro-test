package com.bcnc.alejandrotest.adapter.inbound.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcnc.alejandrotest.adapter.inbound.rest.converter.ProductToProductResponseConverter;
import com.bcnc.alejandrotest.adapter.inbound.rest.dto.ProductResponse;
import com.bcnc.alejandrotest.application.SearchProductUseCase;
import com.bcnc.alejandrotest.domain.Product;

import lombok.RequiredArgsConstructor;

/**
 * This controller class contains the endpoints of products.
 * 
 * @author Alejandro Martin Marques
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    //Use Cases
    private final SearchProductUseCase searchProductUseCase;

    //Converters
    private final ProductToProductResponseConverter productToProductDtoConverter;

    /**
     * This controller method contains the GET endpoint with path /products/id, is used to search the detail information for single product by product id.
     * @param productId Product id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getPrice(@PathVariable("id") Long productId) {
        
        //Call Use case
        Product productDomain = searchProductUseCase.searchProductUseCase(productId);

        //Prepare and return response
        ProductResponse productDto = productToProductDtoConverter.productToProductDto(productDomain);
        
        return new ResponseEntity<ProductResponse>(productDto, HttpStatus.OK);
    }

}
