package com.carrental.main;

import com.carrental.dao.*;
import java.util.Scanner;

public class CarRentalApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CarDAO carDAO = new CarDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        RentalDAO rentalDAO = new RentalDAO();

        while (true) {
            System.out.println("\n--- Car Rental System ---");
            System.out.println("1. Add Car");
            System.out.println("2. Add Customer");
            System.out.println("3. Rent Car");
            System.out.println("4. View Available Cars");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Car Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Car Model: ");
                    String model = sc.nextLine();
                    System.out.print("Price per day: ");
                    double price = sc.nextDouble();
                    carDAO.addCar(cname, model, price);
                    break;

                case 2:
                    System.out.print("Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    customerDAO.addCustomer(name, phone);
                    break;

                case 3:
                    System.out.print("Car ID: ");
                    int carId = sc.nextInt();
                    System.out.print("Customer ID: ");
                    int custId = sc.nextInt();
                    rentalDAO.rentCar(carId, custId);
                    break;

                case 4:
                    carDAO.showAvailableCars();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
