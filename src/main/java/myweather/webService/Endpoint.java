package myweather.webService;

import myweather.model.CityWithSelection;
import myweather.model.Weather;
import myweather.service.CityService;
import myweather.soap.*;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@org.springframework.ws.server.endpoint.annotation.Endpoint
public class Endpoint implements NewWSDLFile {

    private static final String URI = "http://www.example.org/NewWSDLFile";

    private final CityService cityService;

    public Endpoint(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    @PayloadRoot(namespace = URI, localPart = "GetWeather")
    @ResponsePayload
    public GetWeatherResponse getWeather(@RequestPayload GetWeather parameters) throws GetWeatherError_Exception {

        try {
            System.out.println(parameters.getCityWithSelectionName());
            CityWithSelection selectedCity = cityService.getByName(parameters.getCityWithSelectionName());
            Weather weather = cityService.getWeather(selectedCity.getLat(), selectedCity.getLon());

            GetWeatherResponse response = new GetWeatherResponse();
            response.setTemperature(Double.valueOf(weather.getTemperature()));

            return response;

        } catch (Exception e) {
            GetWeatherError getWeatherError = new GetWeatherError();
            getWeatherError.setErrorName(e.getMessage());
            throw new GetWeatherError_Exception("error", getWeatherError);
        }
    }
}
