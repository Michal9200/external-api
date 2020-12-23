package pl.sda.moviedb.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.moviedb.domain.curencyrate.CurrencyRateResponseService;
import pl.sda.moviedb.domain.searchparams.SearchParams;

import java.time.LocalDate;

@Controller
@RequestMapping("calc/")
@AllArgsConstructor
public class CalculateAmountController {

    private CurrencyRateResponseService currencyRateService;

    @RequestMapping
    ModelAndView displayCalculateAmountPage() {
        ModelAndView mav = new ModelAndView("calculateAmount.html");
        mav.addObject("todayDate", LocalDate.now());
        mav.addObject("params", new SearchParams());
        return mav;
    }

    @PostMapping("/calcAmount")
    ModelAndView calculateAmountMoney(@ModelAttribute("params") SearchParams params){
        ModelAndView mav = new ModelAndView("calculateAmount.html");
        mav.addObject("todayDate", LocalDate.now());
        mav.addObject("params", params);
        try {
            mav.addObject("currency", currencyRateService.calculateValue(params));
            mav.addObject("respon", currencyRateService.findRatesFromLast10Days(params));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return mav;
    }




}
