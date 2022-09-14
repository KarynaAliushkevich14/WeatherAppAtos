package Controller;
import JsonService.WeatherService;
import Model.Weather;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;


@SpringBootApplication
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);

        //initialization
        WeatherService ws = new WeatherService();
        WeatherController wc = new WeatherController();
        Weather weather = new Weather();

        try {
                wc.hardcodeAddedSelectedCities();
                System.out.println(ws.returnWeatherArray()+"\n");
                ws.setWeatherFields(weather);
                System.out.println(weather.getIcon()+" "+weather.getDescription()+weather.getMain()+" "+weather.getId());
                System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
