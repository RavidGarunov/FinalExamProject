package org.example;

import cars.Cars;
import service.CarService;

public class Main {
    public static void main(String[] args) {

     //   DBConnection.getConnection();
        //CarService.createtable();

//        CarService.createCar(new Cars(
//                500L,
//                "Hyundai",
//                280,
//                2023,
//                1.8,
//                "Black"));

        //System.out.println(CarService.getAllCars());

       // System.out.println(CarService.getCarById(100L));

//       CarService.updateCarName(100L,"Mercedes Benz");
//        System.out.println(CarService.getCarById(100L));
//        CarService.updateCarName(100L,"Mercedes");
//        System.out.println(CarService.getCarById(100L));

        System.out.println(CarService.getAllCars());
        CarService.deleteCar(500L);
        System.out.println(CarService.getAllCars());

        CarService.createCar(new Cars(
                500L,
                "Hyundai",
                280,
                2023,
                1.8,
                "Black"));

        System.out.println(CarService.getAllCars());

    }

}