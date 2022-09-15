package myweather.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class CityWithSelection {
    private String id;
    private String name;
    private String lat;
    private String lon;

    
    public CityWithSelection(String id, String name, String lat, String lon) {
    	this.id=id;
    	this.name=name;
    	this.lat=lat;
    	this.lon=lon;
    }

    
    


}
