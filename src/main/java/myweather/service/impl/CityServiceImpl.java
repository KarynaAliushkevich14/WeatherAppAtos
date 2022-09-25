package myweather.service.impl;

import lombok.AllArgsConstructor;
import myweather.model.CityWithSelection;
import myweather.model.Weather;
import myweather.service.CityService;
import myweather.service.WeatherService;
import org.springframework.stereotype.Component;
import myweather.repository.CityDAO;
import java.util.List;

@Component
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityDAO cityDAO;

    private final WeatherService weatherService;

    @Override
    public Weather getWeather(String lat, String lon) {
        return weatherService.setWeatherFields(lat, lon);
    }

    @Override
    public CityWithSelection getById(int id) {
        return cityDAO.findById(id);
    }


    @Override
    public List<CityWithSelection> getCitiesIndex() {
        return cityDAO.index();
    }

    @Override
    public CityWithSelection getByName(String name) {
        return cityDAO.findNameIgnoreCase(name);
    }
}
