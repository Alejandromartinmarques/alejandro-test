package com.bcnc.alejandrotest.adapter.outbound.persistance.converter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bcnc.alejandrotest.adapter.outbound.persistance.entity.BrandEntity;
import com.bcnc.alejandrotest.domain.Brand;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandEntityToBrandConverterTest {
  
    @Autowired
    BrandEntityToBrandConverter brandEntityToBrandConverter;

    @Test
    public void convertTest(){
        
        //Given
        BrandEntity brandEntity = BrandEntity.builder()
            .id(2L)
            .name("brandName")
            .build();

        //When
        Brand brandDomain = brandEntityToBrandConverter.brandEntityToBrand(brandEntity);

        //Then
        Assert.assertEquals("brandName", brandDomain.getName());
        Assert.assertEquals("2", brandDomain.getId());
    }
}
