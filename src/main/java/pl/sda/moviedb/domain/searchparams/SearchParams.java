package pl.sda.moviedb.domain.searchparams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchParams {

    private BigDecimal amount;
    private String code;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

}
