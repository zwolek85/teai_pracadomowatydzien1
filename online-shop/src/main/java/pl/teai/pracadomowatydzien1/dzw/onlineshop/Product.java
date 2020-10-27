package pl.teai.pracadomowatydzien1.dzw.onlineshop;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Product {

    private String name;

    private BigDecimal price;

    Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }


    String getName() {
        return name;
    }

    BigDecimal getPrice() {
        return price.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
