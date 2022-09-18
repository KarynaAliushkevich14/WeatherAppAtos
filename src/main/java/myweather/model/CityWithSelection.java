package myweather.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class CityWithSelection {
    private String id;
    private String name;
    private String lat;
    private String lon;

    public CityWithSelection() {
    }

    public CityWithSelection(String id, String name, String lat, String lon) {
    	this.id=id;
    	this.name=name;
    	this.lat=lat;
    	this.lon=lon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "CityWithSelection{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }
}
