package ru.java.domain;

import java.util.Objects;

public class User {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String phone_number;

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone_number = phoneNumber;
    }



    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if((o==null) || getClass() != o.getClass()) return false;
        User item = (User) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }


    public User() {

    }

    public User(String name, String phonenumber, String role){
        this.name = name;
        this.phone_number = phonenumber;
        this.role = role;
    }

    public User(Long id, String name, String phonenumber, String role)
    {
        this.id = id;
        this.name = name;
        this.phone_number = phonenumber;
        this.role = role;
    }

    public User(Long id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone number='" + phone_number + '\'' +
                ", role='" + role +
                '}';
    }
}
