package Controller;

import Model.CityWithSelection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import Model.CityWithSelectionListWrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class WeatherController {

    //from properties.yml

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

    //fields
    private ArrayList<CityWithSelection> allCitiesWithSelection = new ArrayList<CityWithSelection>() ;
    //HARDCODE STARTS
    private static CityWithSelectionListWrapper wrapperWithSelectedCities = new CityWithSelectionListWrapper();
    private static ArrayList<CityWithSelection> hardcodeSelectedCities = new ArrayList<CityWithSelection>();
    public static ArrayList<CityWithSelection> getHardcodeSelectedCities() {
        return hardcodeSelectedCities;
    }
    public void hardcodeAddedSelectedCities() {
        hardcodeSelectedCities.add(new CityWithSelection("1","Madrid","40.2", "50.1", true));
        hardcodeSelectedCities.add(new CityWithSelection("2","London","40.2", "50.1", true));
        wrapperWithSelectedCities.setCitiesList(hardcodeSelectedCities);
    }
    //HARDCODE ENDS


    //constructor
    public WeatherController() {
        allCitiesWithSelection.add(new CityWithSelection("1","Madrid","40.2", "50.1", false));
        allCitiesWithSelection.add(new CityWithSelection("2","London","40.2", "50.1", false));
        allCitiesWithSelection.add(new CityWithSelection("3","Ottawa","40.2", "50.1", false));
    }

    @GetMapping("/currentWeather")
    public String index(Model model) {
        CityWithSelectionListWrapper wrapper = new CityWithSelectionListWrapper();
        wrapper.setCitiesList(allCitiesWithSelection);
        model.addAttribute("wrapper", wrapper);
        return "test";
    }

    @PostMapping("/selectedCities")
    public String postListOfCities (@ModelAttribute("wrapper") CityWithSelectionListWrapper wrapper, Model model) throws IOException, InterruptedException {

        wrapperWithSelectedCities = wrapper;
        hardcodeAddedSelectedCities();

        model.addAttribute("wrapper", wrapperWithSelectedCities);
        return "selectedCities";

    }
}
