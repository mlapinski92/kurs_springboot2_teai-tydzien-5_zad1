package pl.lapinski.pracadomowa_tydzien5_zad1.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import pl.lapinski.pracadomowa_tydzien5_zad1.model.BreakingBadQuote;

import java.util.List;

@Controller
public class QuoteController {

    private List<BreakingBadQuote> getTeams() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange("https://breaking-bad-quotes.herokuapp.com/v1/quotes/100",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<BreakingBadQuote>>() {
                }).getBody();
    }
    @GetMapping("/quotes")
    public String getTeams(Model model){
        model.addAttribute("quotes", getTeams());
        return "quotes";
    }
}
