package pl.sda.moviedb.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.moviedb.domain.curencyrate.AllCurrencyRateResponseService;



@Controller
@RequestMapping("calc/getAll")
@AllArgsConstructor
public class ExchangeRateController {

    private AllCurrencyRateResponseService allCurrencyRateResponseService;

    @RequestMapping
    ModelAndView displayExchangeRatePage() {
        ModelAndView mav = new ModelAndView("exchangeRate.html");
        try {
            mav.addObject("date", allCurrencyRateResponseService.returnDateOfExchangeRates());
            mav.addObject("respon", allCurrencyRateResponseService.returnAllCurrencyRate());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return mav;
    }

}
