package myweather.service;

import myweather.model.CityWithSelection;
import myweather.model.Weather;

import java.util.List;

public interface CityService {

    Weather getWeather(String lat, String lon);

    CityWithSelection getById(int id);

    List<CityWithSelection> getCitiesIndex();

    CityWithSelection getByName(String name);
}
