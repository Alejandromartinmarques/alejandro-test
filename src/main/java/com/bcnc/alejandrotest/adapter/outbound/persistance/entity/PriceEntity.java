package com.bcnc.alejandrotest.adapter.outbound.persistance.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRICES")
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICE_LIST")
    private Long id;

    // TODO comentar en la prueba que si relacionasemos brand con price entity,
    // entonces, pondrias brand como EAGER y product como lazy, pero que siguiedo el
    // patrón de DDD esto no tiene sentido

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity productEntity;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column
    private Long priority;

    @Column
    private BigDecimal price;

    @Column(name = "CURR")
    private String currency;

}
