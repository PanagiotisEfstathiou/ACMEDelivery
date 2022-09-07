package com.app.acmedelivery.bootstrap;


import com.app.acmedelivery.base.BaseComponent;
import com.app.acmedelivery.domainModel.Product;
import com.app.acmedelivery.domainModel.Store;
import com.app.acmedelivery.service.AccountService;
import com.app.acmedelivery.service.ProductService;
import com.app.acmedelivery.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Profile("Generate-basic-content")
@RequiredArgsConstructor
public class BasicSampleContentCreator extends BaseComponent implements CommandLineRunner {

   private final ProductService productService;
   private final StoreService storeService;
   private final AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        Store pizzaHouse = storeService.create(Store.builder().storeName("Pizza House").build());
        logger.info("Created {}.", pizzaHouse);

        List<Product> products = List.of(
                Product.builder().name("Margherita").price(BigDecimal.valueOf(10)).store(pizzaHouse).build(),
                Product.builder().name("Special").price(BigDecimal.valueOf(12)).store(pizzaHouse).build(),
                Product.builder().name("Diavola").price(BigDecimal.valueOf(13)).store(pizzaHouse).build(),
                Product.builder().name("Pepperoni").price(BigDecimal.valueOf(11)).store(pizzaHouse).build(),
                Product.builder().name("Mushroom").price(BigDecimal.valueOf(11)).store(pizzaHouse).build()
        );


    }
}
