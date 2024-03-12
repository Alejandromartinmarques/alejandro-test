package com.bcnc.alejandrotest.adapter.inbound.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcnc.alejandrotest.adapter.inbound.rest.dto.PriceDto;

/**
 * Controlled where is declared all endpoints of prices
 * 
 * @author Alejandro Martin Marques
 */
@RestController
@RequestMapping("/prices")
public class PriceController {

    @GetMapping("/products")
    public ResponseEntity<List<PriceDto>> getProductPrices() {
        // TODO priority1
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<List<PriceDto>> getProductPricesByProduct(@PathVariable("productId") Long productId) {
        // TODO priority1
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }
}
