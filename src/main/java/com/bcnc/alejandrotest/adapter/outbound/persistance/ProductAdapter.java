package com.bcnc.alejandrotest.adapter.outbound.persistance;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bcnc.alejandrotest.adapter.outbound.persistance.converter.ProductEntityToProductConverter;
import com.bcnc.alejandrotest.adapter.outbound.persistance.entity.ProductEntity;
import com.bcnc.alejandrotest.adapter.outbound.persistance.repository.ProductRepository;
import com.bcnc.alejandrotest.application.provider.PricesProvider;
import com.bcnc.alejandrotest.application.provider.ProductsProvider;
import com.bcnc.alejandrotest.domain.Price;
import com.bcnc.alejandrotest.domain.Product;

import lombok.RequiredArgsConstructor;

/**
 * @author Alejandro Martin Marques
 */
@Service
@RequiredArgsConstructor
public class ProductAdapter implements ProductsProvider {
    
    //Repositories
    private final ProductRepository productRepository;

    //Providers
    private final PricesProvider pricesProvider;

    //Converters
    private final ProductEntityToProductConverter productEntityToProductConverter;

    @Override
    public Product findProduct(Long productId) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(productId);
        if(optionalProductEntity.isPresent()){
            ProductEntity productEntity = optionalProductEntity.get();
            Product productDomain = productEntityToProductConverter.productEntityToProduct(productEntity);

            //Set current price of product
            Price currentPriceOfProduct = pricesProvider.findCurrentPriceOfProductByProductId(productDomain.getId());
            productDomain.setPrice(currentPriceOfProduct.getAmmount());

            return productDomain;
        }else{
            //TODO
            return null;
        }
    }
}
