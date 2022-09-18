package myweather.service;

import myweather.model.Weather;
import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
//@Service
public class WeatherService {

    Weather weather = new Weather();

	//from properties.yml
    @Value("${url}")
    @Getter
    private  String url;
    @Value("${key}")
    @Getter
    private String key;

    public Weather setWeatherFields(String lat, String lon) {
        weather.setIcon(returnWeatherArray(lat, lon).getString("icon"));
        weather.setMain(returnWeatherArray(lat, lon).getString("main"));
        weather.setId(returnWeatherArray(lat, lon).getInt("id"));
        weather.setDescription(returnWeatherArray(lat, lon).getString("description"));
        weather.setTemperature(returnWeatherTemp(lat, lon).getInt("temp"));
        return weather;
    }

    //String URL = "https://api.openweathermap.org/data/2.5/weather?lat=41.895&lon=112.484&appid=33e00d482f5deafa608560965822312a";

    private JSONObject getRequestResponse(String lat, String lon)  {
        HttpClient client = HttpClient.newHttpClient();
        //request
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(urlValidation(lat, lon)))
                .build();
        //response
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new JSONObject(response.body().toString()); //put JSON String into JSONObject
    }
    //parsing array to object

    private  JSONObject returnWeatherArray (String lat, String lon)  {
        JSONArray weatherArray = getRequestResponse( lat, lon).getJSONArray("weather");
        JSONObject obj_JSON = weatherArray.getJSONObject(0);
        return obj_JSON;
    }
    //set to Weather fields JSON fields

    private  JSONObject returnWeatherTemp (String lat, String lon)  {
        JSONObject weatherTemperature = getRequestResponse( lat, lon).getJSONObject("main");
        return weatherTemperature;
    }

    //RestTemplate -> Weather.class

    //urlValidation
    public String urlValidation (String lat, String lon){
        return "https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid="+key;
    }
}
