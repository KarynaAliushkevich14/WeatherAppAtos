package myweather.webService;

import myweather.model.CityWithSelection;
import myweather.model.Weather;
import myweather.service.CityService;
import myweather.soap.*;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@org.springframework.ws.server.endpoint.annotation.Endpoint
public class Endpoint implements WeatherSOAP {

    private static final String URI = "http://www.example.org/WeatherSOAP/";

    private final CityService cityService;

    public Endpoint(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    @PayloadRoot(namespace = URI, localPart = "GetWeatherRequest")
    @ResponsePayload
    public GetWeatherResponse getWeatherOperation(@RequestPayload GetWeatherRequest parameters) throws GetWeatherRequestFaultMessage {

        try {
            System.out.println(parameters.getCityName());
            System.out.println(parameters.getId());
            CityWithSelection selectedCity = cityService.getByName(parameters.getCityName());
            Weather weather = cityService.getWeather(selectedCity.getLat(), selectedCity.getLon());
            System.out.println(weather.getTemperature());

            GetWeatherResponse response = new GetWeatherResponse();
            response.setTemp(Double.valueOf(weather.getTemperature().split(" ")[0]));

            return response;
        } catch (Exception e) {
            GetWeatherRequestFault getWeatherError = new GetWeatherRequestFault();
            getWeatherError.setDesc(e.getMessage());
            throw new GetWeatherRequestFaultMessage("Error: city doesn't exist", getWeatherError);
        }
    }
}
