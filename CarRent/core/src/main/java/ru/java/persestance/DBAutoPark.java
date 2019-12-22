package ru.java.persestance;


import ru.java.domain.Car;
import ru.java.domain.Contract;
import ru.java.domain.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DBAutoPark implements DBInterface<Car, User, Contract> {

    public DBAutoPark() {
        try {
            Class.forName("org.h2.Driver");
            //DBUtils.createTable();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver class not found" + e.getMessage());
        }
    }

    public <T> List<T> getAll(Class<T> clazz) {

        List<T> elements = new ArrayList<T>();

        try (Statement statement = DBUtils.getConnection().createStatement()) {

            Field[] fields = clazz.getDeclaredFields();
            Class[] params = {};

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + clazz.getSimpleName().toLowerCase() + "s");

            while (resultSet.next()) {
                T t = clazz.getConstructor(params).newInstance();

                for (Field field : fields) {
                    field.setAccessible(true);
                    if (resultSet.getObject(field.getName()) instanceof Integer)
                        try{
                            field.set(t, resultSet.getLong(field.getName()));
                        }
                        catch (IllegalArgumentException e) {
                            field.set(t, resultSet.getInt(field.getName()));
                        }

                    else if (resultSet.getObject(field.getName()) instanceof String)
                        field.set(t, resultSet.getString(field.getName()));
                    else if (resultSet.getObject(field.getName()) instanceof Boolean)
                        field.set(t, resultSet.getBoolean(field.getName()));

                }

                elements.add(t);
            }

        } catch (SQLException | NoSuchMethodException e) {
            e.printStackTrace();
            return Collections.emptyList();
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return elements;
    }

    private Mapper<User> createMapperForCar() {
        Mapper a = new Mapper<Car>() {
            @Override
            public List<Car> foo(ResultSet resultSet) {

                List<Car> result = new ArrayList<>();
                try {
                    while (resultSet.next()) {
                        Long id = resultSet.getLong("id");
                        String brand = resultSet.getString("brand");
                        String info = resultSet.getString("info");
                        Integer price = resultSet.getInt("price");
                        Boolean available = resultSet.getBoolean("availability");
                        Car car = new Car(id, brand, info, price, available);
                        result.add(car);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return result;
            }
        };
        return a;
    }

    @Override
    public boolean addCar(Car car){
        String query = "INSERT INTO cars" + " (brand, info, price, availability) " +
            "VALUES ('" + car.getBrand() + "', '" + car.getInfo() + "', " + car.getPrice().toString() + ", true)";
        return DBUtils.executeQuery(query);
    }

    @Override
    public boolean removeCar(Car car) {
        return DBUtils.executeQuery("DELETE FROM cars WHERE id like " + car.getId().toString());
    }

    @Override
    public boolean alterCar(Car car) {
        String query = "UPDATE cars set brand='" + car.getBrand()
            + "', info='" + car.getInfo() + "', price=" + car.getPrice().toString() + ", availability=" + car.getIsAvailable().toString() +
            " where id like " + car.getId().toString();
        return DBUtils.executeQuery(query);
    }

    @Override
    public Car getCarById(Long id){
        Mapper a = createMapperForCar();
        List<Car> cars = DBUtils.executeSelectQuery("select * from cars where id=" + id, a);
        if(cars != null && !cars.isEmpty())
        {
            return cars.get(0);
        }
        return null;
    }

    //оптимизировать - DB в независимости от домена создаёт connection
//    @Override
//    public List<Car> getAllCars() {
//        Mapper a = createMapperForCar();
//        return DBUtils.executeSelectQuery("select * from cars", a);
//    }



    @Override
    public boolean addUser(User user){
        String query = "INSERT INTO users" + "(name, phone_number, role)" +
            "VALUES ('" + user.getName() + "', '" + user.getPhoneNumber() + "', '" + user.getRole() + "')";
        return DBUtils.executeQuery(query);
    }

    @Override
    public boolean removeUser(User user) {
        return DBUtils.executeQuery("DELETE FROM users WHERE id like " + user.getId().toString());
    }


    private Mapper<User> createMapperForUser() {
        Mapper a = new Mapper<User>() {
            @Override
            public List<User> foo(ResultSet resultSet) {
                List<User> result = new ArrayList<>();
                try{
                    while(resultSet.next()){
                        Long id = resultSet.getLong("id");
                        String name = resultSet.getString("name");
                        String phoneNumber = resultSet.getString("phone_number");
                        String role = resultSet.getString("role");

                        User user = new User(id, name, phoneNumber, role);
                        result.add(user);
                    }
                }
                catch (SQLException e){
                    e.printStackTrace();
                }

                return result;
            }
        };
        return a;
    }

    @Override
    public User getUserById(Long id){
        Mapper a = createMapperForUser();
        List<User> users = DBUtils.executeSelectQuery("select * from users where id="+id.toString(), a);
        if(users != null && !users.isEmpty())
        {
            return users.get(0);
        }
        return null;
    }
//    @Override
//    public List<User> getAllUsers() {
//        Mapper a = createMapperForUser();
//        return DBUtils.executeSelectQuery("select * from users", a);
//    }

    @Override
    public List<Long> getUserId(User user) {
        Mapper a = new Mapper<Long>() {
            @Override
            public List<Long> foo(ResultSet resultSet) {
                List<Long> result = new ArrayList<>();
                try{
                    while(resultSet.next()){
                        Long id = resultSet.getLong("id");
                        result.add(id);
                    }
                }
                catch (SQLException e){
                    e.printStackTrace();
                }

                return result;
            }
        };
        return DBUtils.executeSelectQuery("select id from users where name='"+user.getName()+
            "' and phone_number='"+user.getPhoneNumber()+"' and role='"+user.getRole()+"'", a);
    }


    @Override
    public boolean addContract(Contract contract){
        String query = "INSERT INTO contracts" + "(created_at, ends_at, client_id, admin_id, car_id, is_approved)" +
            "VALUES ('"+contract.getCreatedAt()+"', '"+contract.getEndsAt()+"', "+contract.getClientID()
            +", 0, "+contract.getCarId() + ", false)";
        return DBUtils.executeQuery(query);
    }


    @Override
    public Contract getContractById(Long id){
        Mapper a = new Mapper<Contract>() {
            @Override
            public List<Contract> foo(ResultSet resultSet) {
                return null;
            }
        };
        List<Contract> contracts = DBUtils.executeSelectQuery("select * from contracts where id="+ id, a);
        if(contracts != null && !contracts.isEmpty())
        {
            return contracts.get(0);
        }
        return null;
    }

    private Mapper<Contract> createMapperForContract() {
        Mapper a = new Mapper<Contract>() {
            @Override
            public List<Contract> foo(ResultSet resultSet) {
                List<Contract> result = new ArrayList<>();
                try {
                    while (resultSet.next()) {
                        Long id = resultSet.getLong("id");
                        String createdAt = resultSet.getString("created_at");
                        String endsAt = resultSet.getString("ends_at");
                        Long clientId = resultSet.getLong("client_id");

                        Long carId = resultSet.getLong("car_id");
                        Boolean isApproved = resultSet.getBoolean("is_approved");

                        Contract contract = new Contract(id, createdAt, endsAt, clientId, new Car(carId), isApproved);
                        result.add(contract);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return result;
            }
        };
        return a;
    }


    @Override
    public List<Contract> getAllContracts() {
        Mapper a = createMapperForContract();

        return DBUtils.executeSelectQuery("select * from contracts", a);
    }


    public List<Contract> getApprovedContracts() {
        Mapper a = createMapperForContract();
        return DBUtils.executeSelectQuery("select * from contracts where is_approved = true", a);
    }

    public List<Contract> getNotApprovedContracts() {
        Mapper a = createMapperForContract();
        return DBUtils.executeSelectQuery("select * from contracts where is_approved = false", a);
    }

    public List<Contract> getApprovedContractsForClient(Long client_id) {
        Mapper a = createMapperForContract();
        return DBUtils.executeSelectQuery("select * from contracts where is_approved = true and client_id="+client_id.toString(), a);
    }

    public List<Contract> getNotApprovedContractsForClient(Long client_id) {
        Mapper a = createMapperForContract();
        return DBUtils.executeSelectQuery("select * from contracts where is_approved = false and client_id="+client_id.toString(), a);
    }

    @Override
    public boolean approveContract(Long contract_id, User user) {
        return DBUtils.executeQuery("UPDATE contracts set admin_id='" + user.getId().toString()
            + "', is_approved=true"+
            " where id like " + contract_id);
    }











}
