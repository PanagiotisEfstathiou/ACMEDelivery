package com.app.acmedelivery.bootstrap;


import com.app.acmedelivery.base.BaseComponent;
import com.app.acmedelivery.domainModel.*;
import com.app.acmedelivery.repository.ProductRepository;
import com.app.acmedelivery.service.AccountService;
import com.app.acmedelivery.service.ProductService;
import com.app.acmedelivery.service.ProductServiceImpl;
import com.app.acmedelivery.service.StoreService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Component
@Profile("generateSampleData")
@RequiredArgsConstructor
public class BasicSampleContentCreator extends BaseComponent implements CommandLineRunner {

   private final ProductService productService;
   private final StoreService storeService;
  // private final AccountService accountService;

    @Override
    public void run(String... args) throws Exception {

        List<Product> products = List.of(
                Product.builder().name("Margherita").price(BigDecimal.valueOf(10)).serial("aaa").productCategory(ProductCategory.PIZZA).build(),
                Product.builder().name("Special").price(BigDecimal.valueOf(12)).serial("aaa1").productCategory(ProductCategory.PIZZA).build(),
                Product.builder().name("Diavola").price(BigDecimal.valueOf(13)).serial("aaa2").productCategory(ProductCategory.PIZZA).build(),
                Product.builder().name("Pepperoni").price(BigDecimal.valueOf(11)).serial("aaa3").productCategory(ProductCategory.PIZZA).build(),
                Product.builder().name("Mushroom").price(BigDecimal.valueOf(11)).serial("aaa4").productCategory(ProductCategory.PIZZA).build()
        );

        logger.info("Created {} products", productService.createAll(products).size());

        Store pizzaHouse = storeService.create(
                Store.builder().
                storeName("Pizza House").
                storeCategory(StoreCategory.PIZZA).
                storeRegion("sdada").catalog(products).
                ratings(List.of(Rating.FIVE, Rating.ONE)).
                build()
        );
        logger.info("Created {}.", pizzaHouse);

        List<Product> hindiplates = List.of(
                Product.builder().name("India Gate Salad").price(BigDecimal.valueOf(10)).serial("h1").productCategory(ProductCategory.SALADS).build(),
                Product.builder().name("Masala Peanuts").price(BigDecimal.valueOf(12)).serial("h2").productCategory(ProductCategory.APPETIZERS).build(),
                Product.builder().name("Mushroom Soup").price(BigDecimal.valueOf(9)).serial("h3").productCategory(ProductCategory.APPETIZERS).build(),
                Product.builder().name("Bombay Potatoes").price(BigDecimal.valueOf(5)).serial("h4").productCategory(ProductCategory.APPETIZERS).build(),
                Product.builder().name("Chicken Tikka Masala").price(BigDecimal.valueOf(11)).serial("h5").productCategory(ProductCategory.NOODLES).build()
        );

        logger.info("Created {} products", productService.createAll(hindiplates).size());

        Store hindilovers = storeService.create(
                Store.builder().
                        storeName("Hindi Lovers").
                        storeCategory(StoreCategory.INDIAN).
                        storeRegion("Victoria").catalog(hindiplates).
                        ratings(List.of(Rating.TWO, Rating.THREE)).
                        build()
        );
        logger.info("Created {}.", hindilovers);






    }
}
