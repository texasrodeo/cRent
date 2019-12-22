package ru.java.domain;

import java.util.Objects;

public class Contract {
    private Long id;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String createdAt) {
        this.created_at = createdAt;
    }

    private String created_at;


    public String getEndsAt() {
        return ends_at;
    }

    public void setEndsAt(String endAt) {
        this.ends_at = endAt;
    }

    private String ends_at;


    private Long client_id;

    public Long getClientID() {
        return client_id;
    }

    public void setClientID(Long client) {
        this.client_id = client;
    }




    public Long getAdminId() {
        return admin_id;
    }

    public void setAdminId(Long adminId) {
        this.admin_id = adminId;
    }

    private Long admin_id;





    private Long car_id;

    public Long getCarId() {
        return car_id;
    }

    public void setCarId(Long car) {
        this.car_id = car;
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    private Car car;

    private Boolean is_approved;

    public Boolean getIsApproved() {return is_approved;}

    public void setIsApproved(Boolean value, Long adminId){
        this.is_approved = value;
        this.admin_id = adminId;
        this.car.setIsAvailable(false); ;
    }


    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if((o==null) || getClass() != o.getClass()) return false;
        Contract item = (Contract) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }


    public Contract() {

    }

    public Contract(String createdAt, String endsAt, Long clientId, Car car){
        this.created_at = createdAt;
        this.ends_at = endsAt;
        this.client_id = clientId;
        this.car = car;
        this.car_id = car.getId();
        //this.admin = admin;
        this.is_approved = false;
    }



    public Contract(Long id, String createdAt, String endsAt, Long clientId, Car car)
    {
        this.id = id;
        this.created_at = createdAt;
        this.ends_at = endsAt;
        this.client_id = clientId;
        this.car = car;
        this.car_id = car.getId();
        //this.admin = admin;
        this.is_approved = false;
    }

    public Contract(Long id, String createdAt, String endsAt, Long clientId, Car car, Boolean isApproved) {
        this.id = id;
        this.ends_at = endsAt;
        this.created_at = createdAt;
        this.client_id = clientId;
        this.car = car;
        this.car_id = car.getId();
        this.is_approved = isApproved;
    }

    public Contract(Long id){
        this.id = id;
    }

    @Override
    public String toString() {
        String result = "Contract{" +
                "id=" + id +
                ", created at='" + created_at + '\'' +
                ", ends at='" + ends_at + '\'' +
                ", client ID='" + client_id.toString()+ '\'';
        if(admin_id!=null){
             result += ", admin Id='" + admin_id.toString() + '\'';
        }
        result += ", car Id=" + car_id.toString() +
            ", approved: " + is_approved +
                '}';
        return result;
    }
}
