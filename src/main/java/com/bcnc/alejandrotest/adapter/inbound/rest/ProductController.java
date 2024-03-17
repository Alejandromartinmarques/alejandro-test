package com.bcnc.alejandrotest.adapter.inbound.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcnc.alejandrotest.adapter.inbound.rest.converter.ProductToProductDtoConverter;
import com.bcnc.alejandrotest.adapter.inbound.rest.dto.ProductDto;
import com.bcnc.alejandrotest.application.SearchProductUseCase;
import com.bcnc.alejandrotest.domain.Product;

/**
 * This controller class contains the endpoints of products.
 * 
 * @author Alejandro Martin Marques
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    //Use Cases
    private SearchProductUseCase searchProductUseCase;

    //Converters
    private ProductToProductDtoConverter productToProductDtoConverter;

    /**
     * This controller method contains the GET endpoint with path /products/id, is used to search the detail information for single product by product id.
     * @param productId Product id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getPrice(@PathVariable("id") Long productId) {
        
        //Call Use case
        Product productDomain = searchProductUseCase.searchProductUseCase(productId);

        //Prepare and return response
        ProductDto productDto = productToProductDtoConverter.productToProductDto(productDomain);
        
        return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
    }

}
