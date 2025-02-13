package exercise.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CarList {
    @JsonProperty("cars")
    private List<Car> cars;

    public CarList(){}

/*    public CarList(List<Car> cars){
        this.cars = cars;
    }*/

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
