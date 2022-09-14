package JsonService;

import Controller.WeatherController;
import Model.CityWithSelection;
import Model.Weather;
import YmlConfig.AppConfig;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherService {

    @Autowired
    private AppConfig appConfig;

    @Bean
    public WeatherController wc() {
        return new WeatherController();
    }
    @Bean
    public HttpClient newClient(){
        return HttpClient.newHttpClient();
    }

    String URL = "https://api.openweathermap.org/data/2.5/weather?lat=40.416&lon=-3.703&appid=ea55909b3da405c992153748db757253";

    public JSONObject getRequestResponse() throws IOException, InterruptedException {
        newClient();
        //request
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(urlValidation(wc().getHardcodeSelectedCities().get(0))))
                .build();
        //response
        HttpResponse<String> response = newClient().send(request, HttpResponse.BodyHandlers.ofString());
        return new JSONObject(response.body().toString()); //put JSON String into JSONObject
    }

    //urlValidation
    public String urlValidation (CityWithSelection cityWithSelection){
        String newURL = appConfig.getURL().replace("{lat}", cityWithSelection.getLat())
                .replace("{lon}", cityWithSelection.getLon())
                .replace("{API key}", appConfig.getKEY());
        return newURL;
    }


    //parsing array to object
    public JSONObject returnWeatherArray () throws IOException, InterruptedException {
        JSONArray weatherArray = getRequestResponse().getJSONArray("weather");
        JSONObject obj_JSON = weatherArray.getJSONObject(0);
        return obj_JSON;
    }

    //set to Weather fields JSON fields
    public void setWeatherFields(Weather weather ) throws IOException, InterruptedException {
        weather.setIcon(returnWeatherArray().getString("icon"));
        weather.setMain(returnWeatherArray().getString("main"));
        weather.setId(returnWeatherArray().getInt("id"));
        weather.setDescription(returnWeatherArray().getString("description"));
    }

}
