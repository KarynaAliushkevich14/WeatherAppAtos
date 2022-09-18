package myweather.controller;

import lombok.AllArgsConstructor;
import myweather.model.CityWithSelection;
import myweather.model.Weather;
import myweather.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Controller
//@AllArgsConstructor
public class WeatherController {

    private static final Logger LOGGER = Logger.getLogger(WeatherController.class.getName());

    private CityService cityService;

    public WeatherController(CityService cityService) {
        this.cityService = cityService;
    }


    @GetMapping("/cityList")
    public String index(ModelMap model) {
        List<CityWithSelection> myCityOrder = cityService.getCitiesIndex();
        model.addAttribute("cities", myCityOrder);
        return "index";
    }

    @PostMapping("/selectedCities")
    public String postListOfCities(Integer[] cityIndexes, ModelMap modelMap) {
        LOGGER.info("postListOfCities(" + Arrays.toString(cityIndexes) + ")");
        if (cityIndexes != null) {
            List<CityWithSelection> cityWithSelections = new ArrayList<>();
            for (Integer cityIndex : cityIndexes) {
                CityWithSelection cityWithSelection = cityService.getById(cityIndex);
                cityWithSelections.add(cityWithSelection);
            }
            //modelMap.addAttribute("cityWithSelections", cityWithSelections);
            LOGGER.info("cityWithSelections: " + cityWithSelections);

            List<Weather> weather = new ArrayList<>();
            for (CityWithSelection cityWithSelection: cityWithSelections){
                Weather x = cityService.getWeather(cityWithSelection.getLat(), cityWithSelection.getLon());
                Weather newWeather = new Weather(x.getId(), x.getMain(), x.getDescription(), x.getIcon(), x.getTemperature());
                weather.add(newWeather);
            }

            LOGGER.info("weather: " + weather);

            modelMap.addAttribute("weatherFromSelectedCities", weather);
        }

        return "selectedCities";
    }

    @GetMapping(path = "/selectedCities")
    public String getSelectedCities(ModelMap modelMap) {
        //List<Weather> allCitiesWeathers = weatherByLatLon(); // metoda do pobrania 10 weather z miast wyszukiwanych by Id. Napisana nizej tego geta
        List<Weather> weatherFromSelectedCities = new ArrayList<>();
        List<CityWithSelection> cityWithSelections = (List<CityWithSelection>) modelMap.getAttribute("cityWithSelections");
        LOGGER.info("cityWithSelections: " + cityWithSelections);

        modelMap.addAttribute("weatherFromSelectedCities", weatherFromSelectedCities);

        return "selectedCities";
    }
}
