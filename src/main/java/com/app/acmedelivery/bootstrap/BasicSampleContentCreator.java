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

    @Override
    public void run(String... args) throws Exception {

        List<Product> pizzaTowerCatalog = List.of(
                Product.builder().name("Margherita").price(BigDecimal.valueOf(10)).serial("aaa0").productCategory(ProductCategory.PIZZA).build(),
                Product.builder().name("Special").price(BigDecimal.valueOf(12)).serial("aaa1").productCategory(ProductCategory.PIZZA).build(),
                Product.builder().name("Diavola").price(BigDecimal.valueOf(13)).serial("aaa2").productCategory(ProductCategory.PIZZA).build(),
                Product.builder().name("Pepperoni").price(BigDecimal.valueOf(11)).serial("aaa3").productCategory(ProductCategory.PIZZA).build(),
                Product.builder().name("Mushroom").price(BigDecimal.valueOf(11)).serial("aaa4").productCategory(ProductCategory.PIZZA).build(),
                Product.builder().name("Coca Cola").price(BigDecimal.valueOf(1.5)).serial("baa5").productCategory(ProductCategory.SODAS).build(),
                Product.builder().name("Pepsi").price(BigDecimal.valueOf(1.5)).serial("aaa6").productCategory(ProductCategory.SODAS).build(),
                Product.builder().name("Fanta").price(BigDecimal.valueOf(1.5)).serial("aaa7").productCategory(ProductCategory.SODAS).build(),
                Product.builder().name("Sprite").price(BigDecimal.valueOf(1.5)).serial("aaa8").productCategory(ProductCategory.SODAS).build(),
                Product.builder().name("Mountain Dew").price(BigDecimal.valueOf(2)).serial("aaa9").productCategory(ProductCategory.SODAS).build()
        );

        logger.info("Created {} products", productService.createAll(pizzaTowerCatalog).size());

        Store pizzaTower = storeService.create(
                Store.builder().
                storeName("Tower of Pizza").
                storeCategory(StoreCategory.PIZZA).
                storeRegion("Athens").catalog(pizzaTowerCatalog).
                ratings(List.of(Rating.FIVE, Rating.ONE)).
                build()
        );
        logger.info("Created {}.", pizzaTower);

        List<Product> suzySushiCatalog = List.of(
                Product.builder().name("Sashimi").price(BigDecimal.valueOf(10)).serial("baa0").productCategory(ProductCategory.SUSHI).build(),
                Product.builder().name("Nigiri").price(BigDecimal.valueOf(12)).serial("baa1").productCategory(ProductCategory.SUSHI).build(),
                Product.builder().name("Chicken Noodles").price(BigDecimal.valueOf(8.5)).serial("baa2").productCategory(ProductCategory.NOODLES).build(),
                Product.builder().name("Shrimp Noodles").price(BigDecimal.valueOf(9)).serial("baa3").productCategory(ProductCategory.NOODLES).build(),
                Product.builder().name("Vegan Noodles").price(BigDecimal.valueOf(7.5)).serial("baa4").productCategory(ProductCategory.VEGAN).build(),
                Product.builder().name("Wasabi Mayo").price(BigDecimal.valueOf(0.5)).serial("baa5").productCategory(ProductCategory.SAUCES).build(),
                Product.builder().name("Sake").price(BigDecimal.valueOf(8)).serial("baa6").productCategory(ProductCategory.ALCOHOL).build(),
                Product.builder().name("Beer").price(BigDecimal.valueOf(4)).serial("baa7").productCategory(ProductCategory.ALCOHOL).build(),
                Product.builder().name("Sprite").price(BigDecimal.valueOf(1.5)).serial("baa8").productCategory(ProductCategory.SODAS).build(),
                Product.builder().name("Mountain Dew").price(BigDecimal.valueOf(2)).serial("baa9").productCategory(ProductCategory.SODAS).build()
        );

        logger.info("Created {} products", productService.createAll(suzySushiCatalog).size());

        Store suzySushi = storeService.create(
                Store.builder().
                        storeName("Suzy Sushi").
                        storeCategory(StoreCategory.SUSHI).
                        storeRegion("Thessaloniki").catalog(suzySushiCatalog).
                        ratings(List.of(Rating.FIVE, Rating.ONE, Rating.TWO, Rating.THREE, Rating.FOUR)).
                        build()
        );
        logger.info("Created {}.", suzySushi);

        List<Product> americanBurgersCatalog = List.of(
                Product.builder().name("Hamburger").price(BigDecimal.valueOf(2.95)).serial("baa0").productCategory(ProductCategory.BURGERS).build(),
                Product.builder().name("Cheeseburger").price(BigDecimal.valueOf(3.15)).serial("baa1").productCategory(ProductCategory.BURGERS).build(),
                Product.builder().name("Onion Rings").price(BigDecimal.valueOf(3.1)).serial("baa2").productCategory(ProductCategory.APPETIZERS).build(),
                Product.builder().name("Chicken Wings").price(BigDecimal.valueOf(5.4)).serial("baa3").productCategory(ProductCategory.APPETIZERS).build(),
                Product.builder().name("Caesars").price(BigDecimal.valueOf(6.9)).serial("baa4").productCategory(ProductCategory.SALADS).build(),
                Product.builder().name("BBQ sauce").price(BigDecimal.valueOf(0.5)).serial("baa5").productCategory(ProductCategory.SAUCES).build(),
                Product.builder().name("Chicken Wrap").price(BigDecimal.valueOf(4.2)).serial("baa6").productCategory(ProductCategory.WRAPS).build(),
                Product.builder().name("Beer").price(BigDecimal.valueOf(4)).serial("baa7").productCategory(ProductCategory.ALCOHOL).build(),
                Product.builder().name("Coca Cola").price(BigDecimal.valueOf(1.8)).serial("baa8").productCategory(ProductCategory.SODAS).build(),
                Product.builder().name("Sprite").price(BigDecimal.valueOf(1.7)).serial("baa9").productCategory(ProductCategory.SODAS).build()
        );

        logger.info("Created {} products", productService.createAll(americanBurgersCatalog).size());

        Store americanBurgers = storeService.create(
                Store.builder().
                        storeName("American Burgers").
                        storeCategory(StoreCategory.BURGERS).
                        storeRegion("Athens").catalog(americanBurgersCatalog).
                        ratings(List.of(Rating.FIVE, Rating.ONE, Rating.TWO, Rating.THREE, Rating.FOUR)).
                        build()
        );
        logger.info("Created {}.", americanBurgers);

        List<Product> morningGloryCatalog = List.of(
                Product.builder().name("Turkey Sandwich").price(BigDecimal.valueOf(3.4)).serial("baa0").productCategory(ProductCategory.SANDWICHES).build(),
                Product.builder().name("Caesars").price(BigDecimal.valueOf(5.6)).serial("baa1").productCategory(ProductCategory.SALADS).build(),
                Product.builder().name("Espresso").price(BigDecimal.valueOf(2.1)).serial("baa2").productCategory(ProductCategory.COFFEE).build(),
                Product.builder().name("Cappuccino").price(BigDecimal.valueOf(2.2)).serial("baa3").productCategory(ProductCategory.COFFEE).build(),
                Product.builder().name("Greek Coffee").price(BigDecimal.valueOf(2.1)).serial("baa4").productCategory(ProductCategory.COFFEE).build(),
                Product.builder().name("Freddo Cappuccino").price(BigDecimal.valueOf(2.3)).serial("baa5").productCategory(ProductCategory.COFFEE).build(),
                Product.builder().name("Green Tea").price(BigDecimal.valueOf(1.8)).serial("baa6").productCategory(ProductCategory.TEA).build(),
                Product.builder().name("Apple Pie").price(BigDecimal.valueOf(1.4)).serial("baa7").productCategory(ProductCategory.DESSERTS).build(),
                Product.builder().name("Milkshake Vanilla").price(BigDecimal.valueOf(2.95)).serial("baa8").productCategory(ProductCategory.DESSERTS).build(),
                Product.builder().name("Milkshake Choco").price(BigDecimal.valueOf(2.95)).serial("baa9").productCategory(ProductCategory.DESSERTS).build()
        );

        logger.info("Created {} products", productService.createAll(morningGloryCatalog).size());

        Store morningGlory = storeService.create(
                Store.builder().
                        storeName("Morning Glory").
                        storeCategory(StoreCategory.BREAKFAST).
                        storeRegion("Patra").catalog(morningGloryCatalog).
                        ratings(List.of(Rating.FIVE, Rating.ONE, Rating.TWO, Rating.THREE, Rating.FOUR)).
                        build()
        );
        logger.info("Created {}.", morningGlory);


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
