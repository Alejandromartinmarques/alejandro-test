package com.bcnc.alejandrotest.adapter.outbound.persistance.converter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bcnc.alejandrotest.adapter.outbound.persistance.entity.PriceEntity;
import com.bcnc.alejandrotest.domain.Price;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceEntityToPriceConverterTest {
    
    @Autowired
    PriceEntityToPriceConverter priceEntityToPriceConverter;
    
    @Test
    public void priceEntitiesToPricesTest(){
        
        //Given
        LocalDateTime localDateTimeToCheck = LocalDateTime.now();
        BigDecimal priceToCheck = new BigDecimal(1);
        PriceEntity priceEntity = PriceEntity.builder()
            .currency("EUR")
            .endDate(localDateTimeToCheck)
            .id(1L)
            .price(priceToCheck)
            .priority(1L)
            .startDate(localDateTimeToCheck)
            .build();
        //When
        Price priceDomain = priceEntityToPriceConverter.priceEntityToPrice(priceEntity);
        
        //Then
        Assertions.assertEquals("EUR", priceDomain.getCurrency());
        Assertions.assertEquals(localDateTimeToCheck, priceDomain.getEndAplicableDate());
        Assertions.assertEquals(1L, priceDomain.getPriorityScore());
        Assertions.assertEquals(priceToCheck, priceDomain.getAmount());
        Assertions.assertEquals(localDateTimeToCheck, priceDomain.getStartAplicableDate());
    }

}
