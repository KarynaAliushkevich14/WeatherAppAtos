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

    private String name;
    private int id;
    private String main;
    private String description;
    private String icon;
    private String temperature;


    public void setName(String name) {
        this.name = name;
    }
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
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }


    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                " name=" + name +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", temp='" + temperature + '\'' +
                '}';
    }
}
