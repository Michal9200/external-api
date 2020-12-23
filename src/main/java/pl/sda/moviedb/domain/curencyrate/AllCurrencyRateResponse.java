package pl.sda.moviedb.domain.curencyrate;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AllCurrencyRateResponse {

    private String table;
    private String no;
    private LocalDate effectiveDate;
    private List<Rates> rates;

    @Getter
    @Setter
    public static class Rates {
        private String currency;
        private String code;
        private Double mid;
    }
}
