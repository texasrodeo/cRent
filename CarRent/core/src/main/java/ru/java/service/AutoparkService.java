package ru.java.service;


import ru.java.domain.Car;
import ru.java.persestance.DBAutoPark;

import java.util.List;

public class AutoparkService {
    private DBAutoPark autoPark = new DBAutoPark();

    public List<Car> getCars()  {
        return autoPark.getAll(Car.class);
    }


    public Car getCarById(long id){
        return  autoPark.getCarById(id);
    }

    public boolean removeCarByID(long carId){
        Car item = new Car(carId);
        return autoPark.removeCar(item);
    }

    public boolean addCar(String brand, String info, Integer price){
//        Car car = new Car(autoPark.getCurrentId().getAndIncrement(), brand, info, price);
        return autoPark.addCar(new Car(brand, info, price));

    }

    public boolean updateCar(Long id, String brand, String info, Integer price){
        return autoPark.alterCar(new Car(id, brand, info, price));

    }
}
