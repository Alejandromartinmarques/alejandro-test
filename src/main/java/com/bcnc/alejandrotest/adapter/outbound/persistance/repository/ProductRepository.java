package com.bcnc.alejandrotest.adapter.outbound.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcnc.alejandrotest.adapter.outbound.persistance.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
