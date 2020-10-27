package pl.teai.pracadomowatydzien1.dzw.onlineshop;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Profile("start")
class StartPackageService implements Package {

    @Override
    public BigDecimal getPrice(Basket basket) {
        return basket.getBasketPrice();
    }
}
