package pl.sda.moviedb.domain.curencyrate;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.moviedb.domain.searchparams.SearchParams;
import pl.sda.moviedb.external.exchangerate.ExchangeRateClient;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


@Service
@AllArgsConstructor
public class CurrencyRateResponseService {

    private ExchangeRateClient exchangeRateClient;


    public List<CurrencyRateResponse.Rate> findRatesFromLast10Days(SearchParams params) throws JsonProcessingException {
        CurrencyRateResponse respon = exchangeRateClient.findCurrencyRatefromlast10days(params.getCode(), params.getDate().minusDays(14), params.getDate());
        return respon.getRates();
    }

    public String calculateValue(SearchParams params) throws JsonProcessingException {
        CurrencyRateResponse respon = exchangeRateClient.findCurrencyRate(params.getCode(), params.getDate());
        BigDecimal value = params.getAmount().divide(BigDecimal.valueOf(respon.getRates().get(respon.getRates().size()-1).getMid()), 2, RoundingMode.HALF_EVEN) ;
        return value + " " + params.getCode();
    }
}
