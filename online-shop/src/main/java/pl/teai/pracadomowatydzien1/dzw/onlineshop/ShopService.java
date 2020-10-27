package pl.teai.pracadomowatydzien1.dzw.onlineshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ShopService {

    private static final Logger LOG = LoggerFactory.getLogger(ShopService.class);

    private Package packageVariant;

    private Basket basket;

    @Autowired
    ShopService(Package packageVariant) {
        this.packageVariant = packageVariant;
        basket = new Basket();
    }

    void addProductToBasket(Product product) {
        basket.addProduct(product);
    }

    void showPriceOfBasket() {
        LOG.info("Price of basket: " + packageVariant.getPrice(basket));
    }

    void showProductInBasket(){
        basket.getProducts().forEach(product -> LOG.info(product.toString()));
    }

}
