package ru.java.persestance;

import java.sql.*;
import java.util.List;

public class DBUtils {
    private static final String URL = "jdbc:h2:C:\\Users\\rakdo\\Downloads/cRent/categories";
    private static final String USER = "nobody";
    private static final String PASSWORD = "666";

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static void createTable(){
        try (//проводник в БД
             Statement statement = connection.createStatement();
        ) {
            statement.execute("DROP table cars");
//            statement.execute("Drop table contracts");
//            statement.execute("Drop table users");
            statement.execute("CREATE TABLE cars (" + "id INT NOT NULL PRIMARY KEY auto_increment, " +
                "brand VARCHAR (100) NOT NULL," +
                "info VARCHAR (100) NOT NULL," +
                "price INT (100) NOT NULL," +
                "availability BOOLEAN (100) NOT NULL)");

            statement.execute("CREATE TABLE contracts (" + "id INT NOT NULL PRIMARY KEY auto_increment, " +
                "created_at DATE (100) NOT NULL," +
                "ends_at DATE (100) NOT NULL," +
                "client_id INT (100) NOT NULL," +
                "admin_id INT (100) NOT NULL," +
                "car_id INT (100) NOT NULL," +
                "is_approved BOOLEAN (100) NOT NULL)");

            statement.execute("CREATE TABLE users (" + "id INT NOT NULL PRIMARY KEY auto_increment, " +
                "name VARCHAR (100) NOT NULL," +
                "phone_number VARCHAR (100) NOT NULL," +
                "role VARCHAR (100) NOT NULL)"
                 );



            statement.execute("INSERT INTO cars" + "(brand, info, price, availability)" +
                "VALUES ('volvo', 'Качественная машина, 200 л.с', 2000, true)");
            statement.execute("INSERT INTO cars" + "(brand, info, price, availability)" +
                "VALUES ('lada', 'Бюджетная машина, 90 л.с', 1000, true)");
            statement.execute("INSERT INTO cars" + "(brand, info, price, availability)" +
                "VALUES ('mercedes', 'Машина премиум-класса, 400 л.с', 8000, true)");


        }
        catch (SQLException e) {
            System.out.println("DDL or DML statement error" + e.getMessage());
        }
    }


    public static <T> List<T> executeSelectQuery(String query, DBInterface.Mapper<T> a) {
        try (
             Statement statement = connection.createStatement();){

            ResultSet resultSet = statement.executeQuery(query);//лучше в ед. числе называть

            return a.foo(resultSet);
        } catch (SQLException e) {
            System.out.println("Connection error" + e.getMessage());
        }
        return null;
    }

    public static boolean executeQuery(String query){
        try (
             Statement statement = connection.createStatement();){

            statement.execute(query);

            return true;
        } catch (SQLException e) {
            System.out.println("Connection error" + e.getMessage());
            return false;
        }
    }




}
