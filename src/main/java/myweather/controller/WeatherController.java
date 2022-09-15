package myweather.controller;
import lombok.AllArgsConstructor;
import myweather.model.CityWithSelection;
import myweather.model.Weather;
import myweather.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class WeatherController {

    private final CityService cityService;

    @GetMapping("/cityList")
    public String index(Model model) {
        model.addAttribute("cities", cityService.getCitiesIndex());
        return "index";
    }

    @PostMapping("/selectedCities")
    public String postListOfCities (@ModelAttribute CityWithSelection cityWithSelection)  {
        //napisac post
        //personDAO.save(cityWithSelection)
        return "selectedCities";
    }

    // napisac GET dla wyswietlania nowej listy miast, wybranych uzytkownikiem



    //method that make new list of selected cities
    private List<Weather> WeatherByLatLon() {
        List<Weather> weather = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            weather.add(cityService.getWeather(cityService.getById(i).getLat(), cityService.getById(i).getLon()));
        }
        return weather;
    }

}
