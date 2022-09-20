package myweather.controller;


import myweather.model.CityWithSelection;
import myweather.model.Weather;
import myweather.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class WeatherController {

    private static final Logger LOGGER = Logger.getLogger(WeatherController.class.getName());
    private CityService cityService;

    public WeatherController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cityList")
    public String index(ModelMap modelMap) {
        List<CityWithSelection> myCityOrder = cityService.getCitiesIndex();
        modelMap.addAttribute("cities", myCityOrder);
        return "index";
    }

    @PostMapping("/selectedCities")
    public String postListOfCities(Integer[] cityIndexes, ModelMap modelMap) {
        LOGGER.info("postListOfCities(" + Arrays.toString(cityIndexes) + ")");
        if (cityIndexes != null) {
            List<CityWithSelection> cityWithSelections = new ArrayList<>();
            List<Weather> weather = new ArrayList<>();
            for (Integer cityIndex : cityIndexes) {
                CityWithSelection cityWithSelection = cityService.getById(cityIndex);
                cityWithSelections.add(cityWithSelection);

                Weather weatherFields = cityService.getWeather(cityWithSelection.getLat(), cityWithSelection.getLon());
                weatherFields.setName(cityWithSelection.getName());
                Weather newWeather = new Weather(weatherFields.getName(), weatherFields.getId(), weatherFields.getMain(), weatherFields.getDescription(), weatherFields.getIcon(), weatherFields.getTemperature());
                weather.add(newWeather);
            }
            LOGGER.info("cityWithSelections: " + cityWithSelections);
            LOGGER.info("weather: " + weather);

            modelMap.addAttribute("weatherFromSelectedCities", weather);
            modelMap.addAttribute("cityWithSelections", cityWithSelections);
        }
        return "selectedCities";
    }

//    @GetMapping(path = "/selectedCities")
//    public String getSelectedCities(ModelMap modelMap) {

//        List<Weather> weatherFromSelectedCities = (List<Weather>) modelMap.getAttribute("weather");
//        List<CityWithSelection> cityWithSelections = (List<CityWithSelection>) modelMap.getAttribute("cityWithSelections");
//        LOGGER.info("cityWithSelections: " + cityWithSelections);
//
//        modelMap.addAttribute("weatherFromSelectedCities", weatherFromSelectedCities);
//        modelMap.addAttribute("cityWithSelections", cityWithSelections);
//
//        return "selectedCities";
//    }
}
