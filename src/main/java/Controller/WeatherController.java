package Controller;

import Model.City;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import Model.Weather;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class WeatherController {

    //from properties.yml
    @Value("${url}")
    @Getter
    private String url;
    @Value("${key}")
    @Getter
    private String key;

    @Value("#{${city.madrid}}")
    private Map<String, String> madrid;
    @Value("#{${city.london}}")
    private Map<String, String> london;
    @Value("#{${city.paris}}")
    private Map<String, String> paris;
    @Value("#{${city.warsaw}}")
    private Map<String, String> warsaw;
    @Value("#{${city.prague}}")
    private Map<String, String> prague;
    @Value("#{${city.kyiv}}")
    private Map<String, String> kyiv;
    @Value("#{${city.oslo}}")
    private Map<String, String> oslo;
    @Value("#{${city.minsk}}")
    private Map<String, String> minsk;
    @Value("#{${city.bratislava}}")
    private Map<String, String> bratislava;
    @Value("#{${city.rome}}")
    private Map<String, String> rome;

    public String urlValidation (City city){
        String newURL= getUrl().replaceFirst("\\{lat\\}", city.getLat())
                .replaceFirst("\\{lon\\}", city.getLon())
                .replaceFirst("\\{API key\\}", key);
        return newURL;
    }

    private List<City> selectableCities;

    @GetMapping("/currentWeather")
    public String getListOfCities(Model model) {
        Weather weather = new Weather();
        selectableCities = Arrays.asList(
                new City(madrid.get("id"),madrid.get("name"),madrid.get("lat"), madrid.get("lon")),
                new City(london.get("id"),london.get("name"),london.get("lat"), london.get("lon")),
                new City(paris.get("id"),paris.get("name"),paris.get("lat"), paris.get("lon")),
                new City(warsaw.get("id"),warsaw.get("name"),warsaw.get("lat"), warsaw.get("lon")),
                new City(prague.get("id"),prague.get("name"),prague.get("lat"), prague.get("lon")),
                new City(kyiv.get("id"),kyiv.get("name"),kyiv.get("lat"), kyiv.get("lon")),
                new City(oslo.get("id"),oslo.get("name"),oslo.get("lat"), oslo.get("lon")),
                new City(minsk.get("id"),minsk.get("name"),minsk.get("lat"), minsk.get("lon")),
                new City(bratislava.get("id"),bratislava.get("name"),bratislava.get("lat"), bratislava.get("lon")),
                new City(rome.get("id"),rome.get("name"),rome.get("lat"),rome.get("lon"))
        );
        model.addAttribute("selectableCities", selectableCities);
        model.addAttribute("weather", weather);
        return "checkbox";
    }

    @PostMapping("/selectedCities")
    public String postListOfCities (@ModelAttribute ArrayList<City> city) {
        System.out.println("Cities created");
        System.out.println(city);

        ArrayList<City> n = new ArrayList<>();
        n.addAll(city);



        return "selectedCities";
    }
}

