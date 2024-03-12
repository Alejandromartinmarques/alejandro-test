package com.bcnc.alejandrotest.adapter.outbound.persistance.repository;

import java.util.HashMap;

import com.bcnc.alejandrotest.adapter.outbound.persistance.entity.PriceEntity;

public interface PricesCriteriaRepository {

    PriceEntity findPricesByDinamicFilter(HashMap<String, Object> dinamicFilter);
}
