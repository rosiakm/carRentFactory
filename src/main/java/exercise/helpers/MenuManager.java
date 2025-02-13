package exercise.helpers;

import exercise.models.CarsManager;

import java.io.IOException;
import java.util.Scanner;

public class MenuManager {

    public static CarsManager manager = new CarsManager();

    public static void printMenu(){
        System.out.println(" ");
        System.out.println("Please choose one option");
        System.out.println("1. Add a new car");
        System.out.println("2. Show the complete list of cars");
        System.out.println("3. Show the age of specific models");
        System.out.println("4. Filter cars by age");
        System.out.println("5. Rent a car");
        System.out.println("6. Return a rented car");
        System.out.println("7. End program");
    }

    public static void addNewCarMenu(Scanner scanner) throws IOException {

        System.out.println("Provide cars brand");
        scanner.nextLine();
        String brand = scanner.nextLine();
        System.out.println("Provide cars model");
        String model = scanner.nextLine();
        System.out.println("Provide cars year of production");
        int prodYear = scanner.nextInt();

        manager.addCar(brand,model,prodYear);

        System.out.println(brand + " " + model + " from year " + prodYear + " is added!");
    }

    public static void countCarsAgeMenu(Scanner scanner){
        System.out.println("Provide cars brand");
        scanner.nextLine();
        String brand = scanner.nextLine();
        System.out.println("Provide cars model");
        String model = scanner.nextLine();

        manager.countCarsAge(brand,model);
    }

    public static void printCarsByAgeMenu(Scanner scanner){
        System.out.println("Provide the minimum age range");
        scanner.nextLine();
        int minProdYear = scanner.nextInt();

        manager.printCarsByAge(minProdYear);
    }

    public static void rentACarMenu(Scanner scanner) throws IOException {
        System.out.println("Provide cars id number");
        int id = scanner.nextInt();

        manager.rentCar(id);
    }

    public static void returnACarMenu(Scanner scanner) throws IOException {
        System.out.println("Provide car id number");
        int id = scanner.nextInt();

        manager.returnCar(id);
    }
}
