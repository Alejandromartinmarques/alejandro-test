package com.bcnc.alejandrotest.adapter.outbound.persistance;

import org.springframework.stereotype.Service;

import com.bcnc.alejandrotest.adapter.outbound.persistance.repository.ProductRepository;
import com.bcnc.alejandrotest.application.provider.ProductsProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductAdapter implements ProductsProvider {
    private final ProductRepository productRepository;
}
