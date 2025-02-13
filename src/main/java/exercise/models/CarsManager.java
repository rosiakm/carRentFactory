package exercise.models;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static exercise.helpers.DateFormatHelper.convertLocalDateToString;
import static exercise.helpers.DateFormatHelper.convertStringToLocalDate;
import static exercise.helpers.FileManager.jsonPath;
import static exercise.helpers.JsonHandler.*;

public class CarsManager {

    public static CarList cars;

    static {
        try {
            cars = deserializeCarsJson(jsonPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CarsManager(){}

    public void addCar(String brand, String model, int prodYear) throws IOException {
        cars = deserializeCarsJson(jsonPath);
        if(cars.getCars() == null){
            cars.setCars(new ArrayList<>());
        }
        cars.getCars().add(new Car(brand, model, prodYear));
        writeCarsToJson(cars);
    }

    public void printTheCarList(){
        cars.getCars().forEach(System.out::println);
    }

    public void countCarsAge(String brand, String model){
        List<Car> filteredCars = cars.getCars().stream().filter(car -> car.getBrand().equals(brand))
                .filter(car -> car.getModel().equals(model))
                .toList();

        for (Car car : filteredCars){
            int carsAge = (Year.now().getValue()) - car.getProdYear();
            System.out.println(car.getBrand() + " " + car.getModel() + " with id " + car.getId() + ", is " + carsAge + " years old.");
        }
    }

    public void printCarsByAge(int prodYear){
        cars.getCars().stream().filter(car -> car.getProdYear() >= prodYear)
                .sorted(Comparator.comparingInt(Car::getProdYear))
                .forEach(System.out::println);
    }

    public void rentCar(int id) throws IOException {
        cars = deserializeCarsJson(jsonPath);
        Car car = new Car();

        if(filterCarById(id).isPresent()){
            car = filterCarById(id).get();
        }

        if(car.getIsAvailable()){
            car.setIsAvailable(false);
            System.out.println("You have rented " + car.getBrand() + " " + car.getModel() + " with id " + car.getId() );
        } else {
            System.out.println(car.getBrand() + " " + car.getModel() + " with id " + car.getId() + " is already rented");
        }

        setCarRentExpireDate(car);

        writeCarsToJson(cars);
    }

    public void returnCar(int id) throws IOException {
        cars = deserializeCarsJson(jsonPath);
        Car car = new Car();

        if(filterCarById(id).isPresent()){
            car = filterCarById(id).get();
        }

        if(car.getIsAvailable()){
            System.out.println(car.getBrand() + " " + car.getModel() + " with id " + car.getId() + " is available");
            System.out.println("You can't return it back!");
        } else {
            car.setIsAvailable(true);
            System.out.println("Thanks for returning " + car.getBrand() + " " + car.getModel() + " with id " + car.getId());
            countFine(convertStringToLocalDate(car.getRentDetails().getRentExpireDate()));
        }

        car.getRentDetails().setRentExpireDate(null);

        writeCarsToJson(cars);
    }

    private Optional<Car> filterCarById(int id){
        return cars.getCars().stream().filter(car -> car.getId() == id)
                .findFirst();
    }

    private void setCarRentExpireDate(Car car){
        car.getRentDetails().setRentExpireDate(convertLocalDateToString(LocalDate.now().plusWeeks(2)));
        System.out.println("The rent expire date is set to: " + car.getRentDetails().getRentExpireDate());
    }

    private long countDaysToRentDeadline(LocalDate rentExpireDate){
        return ChronoUnit.DAYS.between(LocalDate.now(), rentExpireDate);
    }

    private void countFine(LocalDate rentExpireDate){
        if(countDaysToRentDeadline(rentExpireDate) < 0){
            int fine = (int) (Math.abs(countDaysToRentDeadline(rentExpireDate))*100);
            System.out.println("The fine for exceeding the deadline is: " + fine + "$");
        }
    }
}
