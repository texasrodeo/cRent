package ru.java.persestance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DBInterface<T, E, L> {

    interface Mapper<R> {
        List<R> foo(ResultSet param) throws SQLException;
    }
//    List<T> getAllCars();
//    List<E> getAllUsers();
     List<L> getAllContracts();


    T getCarById(Long id);
    E getUserById(Long id);
    L getContractById(Long id);

    boolean addCar(T item);
    boolean alterCar(T item);
    boolean removeCar(T item);

    boolean addContract(L item);
    boolean approveContract(Long id, E user);



    boolean addUser(E item);
    boolean removeUser(E item);
    List<Long> getUserId(E item);


}
