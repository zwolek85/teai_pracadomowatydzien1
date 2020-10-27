package pl.teai.pracadomowatydzien1.dzw.onlineshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Basket {

    private List<Product> products;

    public Basket() {
        products = new ArrayList<>();
    }

    void addProduct(Product product) {
        products.add(product);
    }

    List<Product> getProducts() {
        return products;
    }

    public BigDecimal getBasketPrice() {
        return products.stream().map(product -> product.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }
}
