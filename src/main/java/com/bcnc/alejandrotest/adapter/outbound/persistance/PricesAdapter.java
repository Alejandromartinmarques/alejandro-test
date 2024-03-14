package com.bcnc.alejandrotest.adapter.outbound.persistance;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bcnc.alejandrotest.adapter.outbound.persistance.repository.PricesRepository;
import com.bcnc.alejandrotest.application.provider.PricesProvider;
import com.bcnc.alejandrotest.domain.Price;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PricesAdapter implements PricesProvider {

    private final PricesRepository pricesRepository;

    @Override
    public List<Price> findPricesOfProducts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findPricesOfProducts'");
    }

    @Override
    public List<Price> findPricesByProduct(UUID productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findPricesByProduct'");
    }

    @Override
    public Price findCurrentPriceOfProductByProductId(UUID productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCurrentPriceOfProductByProductId'");
    }
}
