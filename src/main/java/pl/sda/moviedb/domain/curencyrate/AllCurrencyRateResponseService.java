package pl.sda.moviedb.domain.curencyrate;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.moviedb.external.exchangerate.ExchangeRateClient;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class AllCurrencyRateResponseService {

    private ExchangeRateClient exchangeRateClient;

    public List<AllCurrencyRateResponse.Rates> returnAllCurrencyRate() throws JsonProcessingException {
        AllCurrencyRateResponse[] respon = exchangeRateClient.findAllCurrencyRate();
        return respon[0].getRates();
    }

    public LocalDate returnDateOfExchangeRates() throws JsonProcessingException {
        AllCurrencyRateResponse[] respon = exchangeRateClient.findAllCurrencyRate();
        return respon[0].getEffectiveDate();
    }

}
