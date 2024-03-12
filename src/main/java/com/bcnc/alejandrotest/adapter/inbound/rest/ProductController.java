package com.bcnc.alejandrotest.adapter.inbound.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcnc.alejandrotest.adapter.inbound.rest.dto.PriceDto;

/**
 * Controlled where is declared all endpoints of products
 * 
 * @author Alejandro Martin Marques
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}/price")
    public ResponseEntity<PriceDto> getPrice(@PathVariable("id") Long productId) {
        // TODO poner en el readme que hice este endpoint por que como el otro eran
        // filtros tan abiertos tuve que usar criteria para hacer un diseño extensible,
        // por ejemplo poner mas filtros,
        // TODO por eso he hecho este endpoint para utilizar la verbosidad de JPA que es
        // más simple aunque no lo pidiese en el enunciado
        return new ResponseEntity<>(null, HttpStatus.NOT_IMPLEMENTED);
    }

}
