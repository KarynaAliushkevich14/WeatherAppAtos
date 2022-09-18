package myweather.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Weather {

    private int id;
    private String main;
    private String description;
    private String icon;
    private int temperature;


    public void setId(int id) {
    	this.id = id;
    }
    public void setMain(String main) {
    	this.main = main;
    }
    public void setDescription(String description) {
    	this.description = description;
    }
    public void setIcon(String icon) {
    	this.icon = icon;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }


    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", temp='" + temperature + '\'' +
                '}';
    }
}
