package com.bcnc.alejandrotest.adapter.outbound.persistance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.bcnc.alejandrotest.adapter.outbound.persistance.entity.PriceEntity;
import com.bcnc.alejandrotest.domain.PriceFilter;

@Repository
public interface PricesCustomRepository {

    Optional<List<PriceEntity>> findPricesByPriceFilter(PriceFilter priceFilter);
}
