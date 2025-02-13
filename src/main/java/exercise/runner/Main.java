package exercise.runner;

import exercise.models.CarsManager;

import java.io.IOException;
import java.util.Scanner;

import static exercise.helpers.MenuManager.*;

public class Main {
    public static void main(String[] args) throws IOException {
        CarsManager carsManager = new CarsManager();
        Scanner scanner = new Scanner(System.in);

        while (true){
            printMenu();
            int option = scanner.nextInt();
            switch (option){
                case 1 -> addNewCarMenu(scanner);
                case 2 -> carsManager.printTheCarList();
                case 3 -> countCarsAgeMenu(scanner);
                case 4 -> printCarsByAgeMenu(scanner);
                case 5 -> rentACarMenu(scanner);
                case 6 -> returnACarMenu(scanner);
                case 7 -> System.exit(0);
                default -> System.out.println("Please choose from available options!");
            }
        }
    }
}
