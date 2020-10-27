package pl.teai.pracadomowatydzien1.dzw.onlineshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
class InitBasket {

    private ShopService shopService;

    @Autowired
    InitBasket(ShopService shopService) {
        this.shopService = shopService;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void initBasket() {
        for (Product product : getProductWithRandomPrice()) {
            shopService.addProductToBasket(product);
        }
        shopService.showProductInBasket();
        shopService.showPriceOfBasket();
    }

    private List<Product> getProductWithRandomPrice() {
        return Arrays.asList(
                new Product("Gra PS4", randomPrice()),
                new Product("Zabawka", randomPrice()),
                new Product("Makaron", randomPrice()),
                new Product("Czekolada", randomPrice()),
                new Product("Klawiatura", randomPrice())
        );
    }

    private BigDecimal randomPrice() {
        double randomPrice = new Random()
                .doubles(1, 50, 300)
                .findFirst().getAsDouble();
        return BigDecimal.valueOf(randomPrice);
    }
}
