package com.bcnc.alejandrotest.adapter.outbound.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcnc.alejandrotest.adapter.outbound.persistance.entity.PriceEntity;

@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Long>, PricesCriteriaRepository {

    PriceEntity findByIdProduct(Long idProduct);
}