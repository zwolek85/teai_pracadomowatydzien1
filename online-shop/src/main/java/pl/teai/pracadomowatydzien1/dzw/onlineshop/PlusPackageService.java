package pl.teai.pracadomowatydzien1.dzw.onlineshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@Profile("plus")
class PlusPackageService implements Package {

    @Value("${vat}")
    private double vat;

    @Override
    public BigDecimal getPrice(Basket basket) {
        BigDecimal result = basket.getBasketPrice().add(basket.getBasketPrice().multiply(new BigDecimal(vat)));
        return result.setScale(2, RoundingMode.HALF_UP);
    }
}
