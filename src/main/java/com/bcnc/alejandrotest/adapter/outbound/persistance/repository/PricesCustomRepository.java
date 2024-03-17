package com.bcnc.alejandrotest.adapter.outbound.persistance.repository;

import java.util.List;
import java.util.Optional;

import com.bcnc.alejandrotest.adapter.outbound.persistance.entity.PriceEntity;
import com.bcnc.alejandrotest.domain.PriceFilter;

public interface PricesCustomRepository {

    Optional<List<PriceEntity>> findPricesByDinamicFilter(PriceFilter priceFilter);
}
