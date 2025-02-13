package exercise.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import static exercise.models.CarsManager.cars;

public class Car {

    @JsonProperty("brand")
    private String brand;
    @JsonProperty("model")
    private String model;
    @JsonProperty("prodYear")
    private int prodYear;
    @JsonProperty("id")
    private int id;
    @JsonProperty("isAvailable")
    private boolean isAvailable;
    @JsonProperty("rentDetails")
    private RentDetails rentDetails;

    public Car(){}

    public Car (String brand, String model, int prodYear){
        this.brand = brand;
        this.model = model;
        this.prodYear = prodYear;
        this.isAvailable = true;

        if(cars.getCars().isEmpty()){
            this.id = 1;
        } else {
            this.id = (cars.getCars().getLast().getId()) + 1;
        }

        this.rentDetails = new RentDetails();
    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public int getProdYear(){
        return prodYear;
    }

    public int getId(){
        return id;
    }

    public boolean getIsAvailable(){
        return isAvailable;
    }

    public RentDetails getRentDetails(){
        return rentDetails;
    }

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public String toString(){
        return "Car brand: " + brand + ", model: " + model + ", production year: " + prodYear + ", id: " + id + ", is available: " + isAvailable;
    }
}
