package com.app.acmedelivery.bootstrap;


import com.app.acmedelivery.base.BaseComponent;
import com.app.acmedelivery.domainModel.*;
import com.app.acmedelivery.service.AccountService;
import com.app.acmedelivery.service.OrderService;
import com.app.acmedelivery.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
@Profile("generateSampleData")
@RequiredArgsConstructor
public class BasicSampleContentCreator extends BaseComponent implements CommandLineRunner {
   private final StoreService storeService;
   private final OrderService orderService;

	private final AccountService accountService;

    @Override
    public void run(String... args) throws Exception {

        //@formatter:off
        List<Product> pizzaTowerCatalog = List.of(
                Product.builder().name("Margherita").price(BigDecimal.valueOf(10)).description("Πίτσα με σάλτσα ντομάτας & τυρί Gouda").productCategory(ProductCategory.PIZZA).build(),
                Product.builder().name("Special").price(BigDecimal.valueOf(12)).description("Πίτσα με λευκή σάλτσα, τυρί Gouda, λευκές νιφάδες τυριού, χοιρινό καπνιστό, μπέικον, μανιτάρια, φρέσκια ντομάτα & κρεμμύδι").productCategory(ProductCategory.PIZZA).build(),
                Product.builder().name("Diavola").price(BigDecimal.valueOf(13)).description("σάλτσα τομάτα, πικάντικο σαλάμι, πράσινες πιπεριές").productCategory(ProductCategory.PIZZA).build(),
                Product.builder().name("Pepperoni").price(BigDecimal.valueOf(11)).description("Πίτσα με σάλτσα ντοματας, τυρί Gouda & τριπλό πεπερόνι").productCategory(ProductCategory.PIZZA).build(),
                Product.builder().name("Greek").price(BigDecimal.valueOf(11)).description("Πίτσα με σάλτσα ντομάτας, τυρί Gouda, λευκές νιφάδες τυριού, κρεμμύδι, ελιές, πράσινη πιπεριά & φρέσκια ντομάτα").productCategory(ProductCategory.PIZZA).build(),
                Product.builder().name("Coca Cola").price(BigDecimal.valueOf(1.5)).description("330ml").productCategory(ProductCategory.SODAS).build(),
                Product.builder().name("Pepsi").price(BigDecimal.valueOf(1.5)).description("330ml").productCategory(ProductCategory.SODAS).build(),
                Product.builder().name("Fanta").price(BigDecimal.valueOf(1.5)).description("330ml").productCategory(ProductCategory.SODAS).build(),
                Product.builder().name("Sprite").price(BigDecimal.valueOf(1.5)).description("330ml").productCategory(ProductCategory.SODAS).build(),
                Product.builder().name("Mountain Dew").price(BigDecimal.valueOf(2)).description("500ml").productCategory(ProductCategory.SODAS).build()
        );



        Store pizzaTower = Store.builder().
                storeName("Tower of Pizza").
                storeCategory(StoreCategory.PIZZA).
                storeRegion("Athens").catalog(pizzaTowerCatalog).
                build();

        pizzaTowerCatalog.forEach(product -> product.setStore(pizzaTower));

       storeService.create(pizzaTower);

        List<Product> suzySushiCatalog = List.of(
                Product.builder().name("Sashimi").price(BigDecimal.valueOf(10)).description("Φιλέτο Τόνου").productCategory(ProductCategory.SUSHI).build(),
                Product.builder().name("Nigiri").price(BigDecimal.valueOf(12)).description("Ρύζι με φιλέτο σολομού").productCategory(ProductCategory.SUSHI).build(),
                Product.builder().name("Chicken Noodles").price(BigDecimal.valueOf(8.5)).description("Νουντλς με " +
																											 "κοτόπουλο").productCategory(ProductCategory.NOODLES).build(),
                Product.builder().name("Shrimp Noodles").price(BigDecimal.valueOf(9)).description("Νουτνλς με " +
																										  "γαρίδες").productCategory(ProductCategory.NOODLES).build(),
                Product.builder().name("Vegan Noodles").price(BigDecimal.valueOf(7.5)).description("Νουντλς Βίγκαν").productCategory(ProductCategory.VEGAN).build(),
                Product.builder().name("Wasabi Mayo").price(BigDecimal.valueOf(0.5)).description("Μαγιονέζα Wasabi").productCategory(ProductCategory.SAUCES).build(),
                Product.builder().name("Sake").price(BigDecimal.valueOf(8)).description("Ιαπωνικό αλκοολικό ποτό " +
																								"ρυζιού 250ml").productCategory(ProductCategory.ALCOHOL).build(),
                Product.builder().name("Beer").price(BigDecimal.valueOf(4)).description("500ml").productCategory(ProductCategory.ALCOHOL).build(),
                Product.builder().name("Sprite").price(BigDecimal.valueOf(1.5)).description("330ml").productCategory(ProductCategory.SODAS).build(),
                Product.builder().name("Mountain Dew").price(BigDecimal.valueOf(2)).description("500ml").productCategory(ProductCategory.SODAS).build()
        );

        Store suzySushi = Store.builder().
                        storeName("Suzy Sushi").
                        storeCategory(StoreCategory.SUSHI).
                        storeRegion("Thessaloniki").catalog(suzySushiCatalog).
                        build();

        suzySushiCatalog.forEach(product -> product.setStore(suzySushi));

		storeService.create(suzySushi);

        List<Product> americanBurgersCatalog = List.of(
                Product.builder().name("Hamburger").price(BigDecimal.valueOf(2.95)).description("Με ζουμερό μπιφτέκι, pickle sauce, μουστάρδα & ketchup").productCategory(ProductCategory.BURGERS).build(),
                Product.builder().name("Cheeseburger").price(BigDecimal.valueOf(3.15)).description("Με τυρί cheddar πάνω σε σε λαχαριστό μπιφτέκι, pickle sauce, μουστάρδα & ketchup").productCategory(ProductCategory.BURGERS).build(),
                Product.builder().name("Onion Rings").price(BigDecimal.valueOf(3.1)).description("Τραγανές ροδέλες κρεμμυδιού").productCategory(ProductCategory.APPETIZERS).build(),
                Product.builder().name("Chicken Wings").price(BigDecimal.valueOf(5.4)).description("Ελαφρώς πικάντικες φτερούγες κοτόπουλου. Συνοδεύονται από Hellmann`s Original BBQ sauce").productCategory(ProductCategory.APPETIZERS).build(),
                Product.builder().name("Caesars").price(BigDecimal.valueOf(6.9)).description("Σαλάτα με μαρούλι, ζουμερές λωρίδες κοτόπουλου, μαρούλι, καλαμπόκι, κρουτόν, τριμμένο τυρί & vinaigrette ελαιόλαδο").productCategory(ProductCategory.SALADS).build(),
                Product.builder().name("BBQ sauce").price(BigDecimal.valueOf(0.5)).description("30gr").productCategory(ProductCategory.SAUCES).build(),
                Product.builder().name("Chicken Wrap").price(BigDecimal.valueOf(4.2)).description("Με τραγανό παναρισμένο κοτόπουλο, ντομάτα, μαρούλι, μουστάρδα & Goody`s sauce").productCategory(ProductCategory.WRAPS).build(),
                Product.builder().name("Beer").price(BigDecimal.valueOf(4)).description("330ml").productCategory(ProductCategory.ALCOHOL).build(),
                Product.builder().name("Coca Cola").price(BigDecimal.valueOf(1.8)).description("330ml").productCategory(ProductCategory.SODAS).build(),
                Product.builder().name("Sprite").price(BigDecimal.valueOf(1.7)).description("330ml").productCategory(ProductCategory.SODAS).build()
        );


        Store americanBurgers = Store.builder().
                        storeName("American Burgers").
                        storeCategory(StoreCategory.BURGERS).
                        storeRegion("Athens").catalog(americanBurgersCatalog).
                        build();

		americanBurgersCatalog.forEach(product -> product.setStore(americanBurgers));

		storeService.create(americanBurgers);

        List<Product> morningGloryCatalog = List.of(
                Product.builder().name("Turkey Sandwich").price(BigDecimal.valueOf(3.4)).description("baa0").productCategory(ProductCategory.SANDWICHES).build(),
                Product.builder().name("Caesars").price(BigDecimal.valueOf(5.6)).description("baa1").productCategory(ProductCategory.SALADS).build(),
                Product.builder().name("Espresso").price(BigDecimal.valueOf(2.1)).description("baa2").productCategory(ProductCategory.COFFEE).build(),
                Product.builder().name("Cappuccino").price(BigDecimal.valueOf(2.2)).description("baa3").productCategory(ProductCategory.COFFEE).build(),
                Product.builder().name("Greek Coffee").price(BigDecimal.valueOf(2.1)).description("baa4").productCategory(ProductCategory.COFFEE).build(),
                Product.builder().name("Freddo Cappuccino").price(BigDecimal.valueOf(2.3)).description("baa5").productCategory(ProductCategory.COFFEE).build(),
                Product.builder().name("Green Tea").price(BigDecimal.valueOf(1.8)).description("baa6").productCategory(ProductCategory.TEA).build(),
                Product.builder().name("Apple Pie").price(BigDecimal.valueOf(1.4)).description("baa7").productCategory(ProductCategory.DESSERTS).build(),
                Product.builder().name("Milkshake Vanilla").price(BigDecimal.valueOf(2.95)).description("baa8").productCategory(ProductCategory.DESSERTS).build(),
                Product.builder().name("Milkshake Choco").price(BigDecimal.valueOf(2.95)).description("baa9").productCategory(ProductCategory.DESSERTS).build()
        );

        Store morningGlory = Store.builder().
                        storeName("Morning Glory").
                        storeCategory(StoreCategory.BREAKFAST).
                        storeRegion("Patra").catalog(morningGloryCatalog).
                        build();

		morningGloryCatalog.forEach(product -> product.setStore(morningGlory));

		storeService.create(morningGlory);


        List<Product> hindiLoversCatalog = List.of(
                Product.builder().name("India Gate Salad").price(BigDecimal.valueOf(10)).description("h1").productCategory(ProductCategory.SALADS).build(),
                Product.builder().name("Masala Peanuts").price(BigDecimal.valueOf(12)).description("h2").productCategory(ProductCategory.APPETIZERS).build(),
                Product.builder().name("Mushroom Soup").price(BigDecimal.valueOf(9)).description("h3").productCategory(ProductCategory.APPETIZERS).build(),
                Product.builder().name("Bombay Potatoes").price(BigDecimal.valueOf(5)).description("h4").productCategory(ProductCategory.APPETIZERS).build(),
                Product.builder().name("Chicken Tikka Masala").price(BigDecimal.valueOf(11)).description("h5").productCategory(ProductCategory.NOODLES).build()
        );

        Store hindilovers = Store.builder().
                        storeName("Hindi Lovers").
                        storeCategory(StoreCategory.INDIAN).
                        storeRegion("Victoria").catalog(hindiLoversCatalog).
                        build();

		hindiLoversCatalog.forEach(product -> product.setStore(hindilovers));

		storeService.create(hindilovers);

		Product product = Product.builder().name("Hamburger").price(BigDecimal.valueOf(2.95)).description("Με ζουμερό" +
																												  " μπιφτέκι, pickle sauce, μουστάρδα & ketchup").productCategory(ProductCategory.BURGERS).build();
		storeService.create(americanBurgers);

		Account account = Account.builder().firstName("nick").lastName("Jones").mobilePhone("2322242411").address(
				"addr").email("smth@email.com").password("daasdad").build();

		accountService.create(account);

		List<OrderItem> orderItemList =
				List.of(
						OrderItem.builder().product(americanBurgersCatalog.get(1)).quantity(1).price(americanBurgersCatalog.get(1).getPrice()).build(),
						OrderItem.builder().product(americanBurgersCatalog.get(2)).quantity(2).price(americanBurgersCatalog.get(2).getPrice()).build()
					   	);

		Order order =
				Order.builder().
						account(account).
							 store(americanBurgers).
							 paymentMethod(PaymentMethod.Cash).
							 submitDate(new Date()).
							 orderItems(orderItemList).build();

//		Order order = orderService.initiateOrder(account,americanBurgers);
//		orderService.addItem(order,Product.builder().name("Hamburger").price(BigDecimal.valueOf(2.95)).description(
//				"Με ζουμερό μπιφτέκι, pickle sauce, μουστάρδα & ketchup").productCategory(ProductCategory.BURGERS).build(),1);
//		orderService.checkout(order ,PaymentMethod.Cash);
//

		orderItemList.forEach(orderItem -> orderItem.setOrder(order));
		order.setTotalPrice(orderService.calculateTotalPrice(orderItemList));
		orderService.create(order);
        //@formatter:on

    }
}
