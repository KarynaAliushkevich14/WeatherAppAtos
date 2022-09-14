package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CityWithSelectionListWrapper {

    private ArrayList<CityWithSelection> cityList;

    //getter
    public ArrayList<CityWithSelection> getCitiesList(){
        return cityList;
    }
    //setter
    public void setCitiesList(ArrayList<CityWithSelection> cities){
        this.cityList =cities;
    }

}
