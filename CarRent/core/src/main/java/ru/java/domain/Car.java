package ru.java.domain;

import java.util.Objects;

public class Car {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }



    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }



    private Boolean availability;

    public Boolean getIsAvailable() {
        return availability;
    }

    public void setIsAvailable(Boolean available) {
        availability = available;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if((o==null) || getClass() != o.getClass()) return false;
        Car item = (Car) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }


    public Car() {

    }

    public Car(Long id, String brand, String info, Integer price)
    {
        this.id = id;
        this.brand = brand;
        this.info = info;
        this.price = price;
        this.availability = true;
    }

    public Car(Long id, String brand, String info, Integer price, Boolean isAvailable)
    {
        this.id = id;
        this.brand = brand;
        this.info = info;
        this.price = price;
        this.availability = isAvailable ;
    }

    public Car(String brand, String info, Integer price)
    {
        this.id = id;
        this.brand = brand;
        this.info = info;
        this.price = price;
        //this.is_available =  ;
    }

    public Car(Long id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", info='" + info + '\'' +
                ", price='" + price.toString() + '\'' +
                ", available='" + availability.toString() +
                '}';
    }
}
