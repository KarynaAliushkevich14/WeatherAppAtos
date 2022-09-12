package Controller;

import Model.City;
import Model.Weather;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherService {
    WeatherController wc;

    String URL = "https://api.openweathermap.org/data/2.5/weather?lat=40.416&lon=-3.703&appid=ea55909b3da405c992153748db757253";

    public JSONObject getRequestResponse() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        City newCity = new City();
        newCity.setId("1");
        newCity.setName("Madrid");
        newCity.setLat("40.416");
        newCity.setLon("-3.703");

        //request
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL))
                .build();
        //response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return new JSONObject(response.body().toString()); //put JSON String into JSONObject
    }

    //parsing array to object
    public JSONObject returnWeatherArray () throws IOException, InterruptedException {
        JSONArray weatherArray = getRequestResponse().getJSONArray("weather");
        JSONObject obj_JSON = weatherArray.getJSONObject(0);
        return obj_JSON;
    }

    //set to Weather fields JSON fields
    public void setWeatherFields(Weather weather) throws IOException, InterruptedException {
        weather.setIcon(returnWeatherArray().getString("icon"));
        weather.setMain(returnWeatherArray().getString("main"));
        weather.setId(returnWeatherArray().getInt("id"));
        weather.setDescription(returnWeatherArray().getString("description"));
    }



    /*parser Gson
    public OpenWeather gsonParser() throws IOException, InterruptedException {
        Gson gson = new Gson();
        OpenWeather openWeather =  gson.fromJson(getRequestResponse(), OpenWeather.class);
        return openWeather;
    }*/




}
