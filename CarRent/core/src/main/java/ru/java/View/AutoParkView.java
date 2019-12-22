package ru.java.View;


import ru.java.domain.Car;
import ru.java.service.AutoparkService;


public class AutoParkView {
    private AutoparkService autoparkService = new AutoparkService();

    public void showCars() {
        System.out.println("--- All cars: ---");
        for(Car car : autoparkService.getCars()) {
            System.out.println(car);
        }
    }



    public void removeCarByID(long carId){

        if(autoparkService.removeCarByID(carId))
            System.out.println(String.format("Car with id = %d has been removed",carId));
        else
            System.out.println(String.format("Car with id = %d doesn't exist",carId));
    }

    public void addCar(String brand, String info, Integer price){

        if(autoparkService.addCar(brand, info, price))
            System.out.println("Car with has been added");
        else
            System.out.println("Error!");
    }

    public void updateCar(Long carId, String brand, String info, Integer price){
        if(autoparkService.updateCar(carId, brand, info, price))
        {
            System.out.println(String.format("Car with id = %d has been updated ", carId));
        }
        else
            System.out.println(String.format("Car with id = %d doesn't exist",carId));
    }
}
