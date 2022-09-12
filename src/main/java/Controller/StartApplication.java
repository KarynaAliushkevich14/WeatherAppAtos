package Controller;
import Model.Weather;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
        WeatherService ws = new WeatherService();
        Weather weather = new Weather();

        try {
            System.out.println(ws.returnWeatherArray()+"\n");
            ws.setWeatherFields(weather);
            System.out.println(weather.getIcon()+" "+weather.getDescription()+weather.getMain()+" "+weather.getId());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*gson
        try {
            ws.getRequestResponse();
            //OpenWeather openWeather = ws.gsonParser();
            //System.out.println("Open Weather " + openWeather.getCurrent().getWeather().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
}
