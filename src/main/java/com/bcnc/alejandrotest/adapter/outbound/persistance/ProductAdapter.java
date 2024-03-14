package com.bcnc.alejandrotest.adapter.outbound.persistance;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bcnc.alejandrotest.adapter.outbound.persistance.repository.ProductRepository;
import com.bcnc.alejandrotest.application.provider.ProductsProvider;
import com.bcnc.alejandrotest.domain.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductAdapter implements ProductsProvider {
    private final ProductRepository productRepository;

    @Override
    public Product findProduct(UUID productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findProduct'");
    }
}
