package ru.java.View;


import ru.java.domain.User;
import ru.java.service.UserService;

public class UserView {
    private UserService userService = new UserService();

    public void showUsers() {
        System.out.println("--- All users: ---");
        for(User user : userService.getUsers()) {
            System.out.println(user);
        }
    }



//    public void removeUser(long userId){
//
//        if(userService.removeUserById(userId))
//            System.out.println(String.format("User with id = %d has been removed",userId));
//        else
//            System.out.println(String.format("User with id = %d doesn't exist",userId));
//    }

    public Long register(String name, String phoneNumber, String role){
        Long sessionId = userService.register(name, phoneNumber, role);
        if(sessionId!=null){
            System.out.println("Successfully entered");
            return  sessionId;
        }

        else{
            System.out.println("Error!");
            return null;
        }

    }
}
