package com.bcnc.alejandrotest.adapter.inbound.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bcnc.alejandrotest.adapter.inbound.rest.converter.PriceFilterDtoToPriceFilterConverter;
import com.bcnc.alejandrotest.adapter.inbound.rest.converter.PriceToPriceDtoConverter;
import com.bcnc.alejandrotest.adapter.inbound.rest.dto.PriceDto;
import com.bcnc.alejandrotest.adapter.inbound.rest.dto.PriceFilterDto;
import com.bcnc.alejandrotest.application.SearchPricesUseCase;
import com.bcnc.alejandrotest.domain.Price;
import com.bcnc.alejandrotest.domain.PriceFilter;

import lombok.RequiredArgsConstructor;

/**
 * This controller class contains the endpoints of prices.
 * 
 * @author Alejandro Martin Marques
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/prices")
public class PriceController {
    
    //Use Cases
    private final SearchPricesUseCase searchPricesUseCase;
    
    //Converters
    PriceFilterDtoToPriceFilterConverter priceFilterDtoToPriceFilterConverter;
    PriceToPriceDtoConverter priceToPriceDtoConverter;

    /**
     * This controller method contains the GET endpoint with path /prices, is used to consult prices with dynamicly PriceFilterDto.
     * @param priceFilterDto Dynamic filter to consult prices.
     * @return
     */
    @GetMapping
    public ResponseEntity<List<PriceDto>> getProductPricesByProduct(@RequestParam PriceFilterDto priceFilterDto) {
        
        //Convert priceFilterDto to domain object
        PriceFilter priceFilterDomain = priceFilterDtoToPriceFilterConverter.priceFilterDtoToPriceFilter(priceFilterDto);
        
        //Call Use Case
        List<Price> pricesDomain = searchPricesUseCase.searchPricesByPriceFilterUseCase(priceFilterDomain);
        
        //Prepare and return response
        List<PriceDto> pricesResponse = priceToPriceDtoConverter.pricesToPriceDtos(pricesDomain);
        HttpStatusCode statusCodeResponse = pricesResponse.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK; 

        return new ResponseEntity<List<PriceDto>>(pricesResponse, statusCodeResponse);
    }
}
