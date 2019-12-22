package ru.java.service;


import ru.java.domain.User;
import ru.java.persestance.DBAutoPark;

import java.util.List;

public class UserService {
    private DBAutoPark userStore = new DBAutoPark();

    public List<User> getUsers() {
        return userStore.getAll(User.class);
    }

    public boolean removeUserById(long userId){
        User user = new User(userId);
        return userStore.removeUser(user);
    }



    public Long register(String name, String phonenumber, String role){
        for(User user: userStore.getAll(User.class)){
            if(user.getName().equals(name) && user.getPhoneNumber().equals(phonenumber) && user.getRole().equals(role))
                return user.getId();

        }
        User user = new User( name, phonenumber, role);
        if(userStore.addUser(user)){
            return userStore.getUserId(user).get(0);

        }
        else
            return null;

    }
}
