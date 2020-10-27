package pl.teai.pracadomowatydzien1.dzw.onlineshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@Profile("pro")
class ProPackageService implements Package {

    @Value("${discount}")
    private double discount;

    @Value("${vat}")
    private double vat;

    @Override
    public BigDecimal getPrice(Basket basket) {
        BigDecimal basketPriceWithVat =   basket.getBasketPrice().add(basket.getBasketPrice().multiply(new BigDecimal(vat)));
        BigDecimal result = basketPriceWithVat.subtract (basketPriceWithVat.multiply(new BigDecimal(discount)));
        return result.setScale(2, RoundingMode.HALF_UP);
    }
}
