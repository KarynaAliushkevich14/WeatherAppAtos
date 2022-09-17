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
import java.util.List;

@Controller
@AllArgsConstructor
public class WeatherController {

    private final CityService cityService;

    ArrayList<CityWithSelection> myCityOrder ;

    @GetMapping("/cityList")
    public String index(ModelMap model) {
        myCityOrder = (ArrayList)cityService.getCitiesIndex();
        model.addAttribute("cities", myCityOrder);
        return "index";
    }

    @PostMapping("/selectedCities")
    public String postListOfCities (@ModelAttribute ArrayList<CityWithSelection> myCityOrder)  {
        this.myCityOrder=myCityOrder;
        System.out.println("works");
        return "redirect:/selectedCities";
    }

    @GetMapping(path = "/selectedCities")
    public String getSelectedCities(ModelMap modelMap){
        List<Weather> allCitiesWeathers = weatherByLatLon(); // metoda do pobrania 10 weather z miast wyszukiwanych by Id. Napisana nizej tego geta
        List<Weather> weatherFromSelectedCities = new ArrayList<>();

        if (!(myCityOrder.get(0).getName() == null)){
            weatherFromSelectedCities.add(allCitiesWeathers.get(0));
        }
        if (!(myCityOrder.get(1).getName() == null)){
            weatherFromSelectedCities.add(allCitiesWeathers.get(1));
        }
        if (!(myCityOrder.get(2).getName() == null)){
            weatherFromSelectedCities.add(allCitiesWeathers.get(2));
        }
        if (!(myCityOrder.get(3).getName() == null)){
            weatherFromSelectedCities.add(allCitiesWeathers.get(3));
        }
        if (!(myCityOrder.get(4).getName() == null)){
            weatherFromSelectedCities.add(allCitiesWeathers.get(4));
        }
        if (!(myCityOrder.get(5).getName() == null)){
            weatherFromSelectedCities.add(allCitiesWeathers.get(5));
        }
        if (!(myCityOrder.get(6).getName() == null)){
            weatherFromSelectedCities.add(allCitiesWeathers.get(6));
        }
        if (!(myCityOrder.get(7).getName() == null)){
            weatherFromSelectedCities.add(allCitiesWeathers.get(7));
        }
        if (!(myCityOrder.get(8).getName() == null)){
            weatherFromSelectedCities.add(allCitiesWeathers.get(8));
        }
        if (!(myCityOrder.get(8).getName() == null)){
            weatherFromSelectedCities.add(allCitiesWeathers.get(8));
        }
        if (!(myCityOrder.get(9).getName() == null)){
            weatherFromSelectedCities.add(allCitiesWeathers.get(9));
        }

        modelMap.addAttribute("weatherFromSelectedCities", weatherFromSelectedCities);

        return "selectedCities";

    }

    //method that make new list of selected cities
    private List<Weather> weatherByLatLon() {
        List<Weather> weather = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            weather.add(cityService.getWeather(cityService.getById(i).getLat(), cityService.getById(i).getLon()));
        }
        return weather;
    }

}
