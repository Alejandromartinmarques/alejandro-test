package com.bcnc.alejandrotest.adapter.outbound.persistance;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bcnc.alejandrotest.adapter.outbound.persistance.converter.PriceEntityToPriceConverter;
import com.bcnc.alejandrotest.adapter.outbound.persistance.entity.PriceEntity;
import com.bcnc.alejandrotest.adapter.outbound.persistance.entity.ProductEntity;
import com.bcnc.alejandrotest.adapter.outbound.persistance.repository.PricesCustomRepository;
import com.bcnc.alejandrotest.adapter.outbound.persistance.repository.PricesRepository;
import com.bcnc.alejandrotest.application.provider.PricesProvider;
import com.bcnc.alejandrotest.domain.Price;
import com.bcnc.alejandrotest.domain.PriceFilter;
import com.bcnc.alejandrotest.domain.exception.ElementNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Alejandro Martin Marques
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PricesAdapter implements PricesProvider {

    //Repositories
    private final PricesRepository pricesRepository;
    private final PricesCustomRepository pricesCustomRepository;

    //Converters
    private final PriceEntityToPriceConverter priceEntityToPriceConverter;

    @Override
    public List<Price> findPricesByPriceFilter(PriceFilter priceFilter) {

        //Obtain optionalPriceEntities by repository
        Optional<List<PriceEntity>> optionalPriceEntities = pricesCustomRepository.findPricesByPriceFilter(priceFilter);
       
        //Manage results
        if(optionalPriceEntities.isPresent()){
            return priceEntityToPriceConverter.priceEntitiesToPrices(optionalPriceEntities.get());
        }else{
            log.info("Prices not finded with provided filters");
            throw new ElementNotFoundException();
        }
    }

    /**
     * This mehthod find the price of product in the moment of request and the most priority price
     */
    @Override
    public Price findCurrentPriceOfProductByProductId(Long productId) {

        //Build parameters to find the current price of product
        ZoneId spainZone = ZoneId.of("Europe/Madrid");
        ZonedDateTime spainCurrentDateTime = ZonedDateTime.now(spainZone);
        LocalDateTime spainCurrentLocalDateTime = spainCurrentDateTime.toLocalDateTime();
        ProductEntity productEntity = ProductEntity.builder().id(productId).build();

        //Obtain optionalPriceEntity by repository
        Optional<PriceEntity> optionalPriceEntity = pricesRepository.findFirstByProductEntityAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(productEntity, spainCurrentLocalDateTime, spainCurrentLocalDateTime);
      
        //Manage results
        if(optionalPriceEntity.isPresent()){
            return priceEntityToPriceConverter.priceEntityToPrice(optionalPriceEntity.get());
        }else{
            return null;
        }
    }


}
