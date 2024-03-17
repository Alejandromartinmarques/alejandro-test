package com.bcnc.alejandrotest.adapter.outbound.persistance.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcnc.alejandrotest.adapter.outbound.persistance.entity.PriceEntity;
import com.bcnc.alejandrotest.adapter.outbound.persistance.entity.ProductEntity;

@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Long>, PricesCustomRepository {

    Optional<PriceEntity> findFirstByProductEntityAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(ProductEntity productEntity, LocalDateTime currentDate);
}
