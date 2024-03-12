package com.bcnc.alejandrotest.adapter.outbound.persistance;

import org.springframework.stereotype.Service;

import com.bcnc.alejandrotest.adapter.outbound.persistance.repository.PricesRepository;
import com.bcnc.alejandrotest.application.provider.PricesProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PricesAdapter implements PricesProvider {

    private final PricesRepository pricesRepository;
}
