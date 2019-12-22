package ru.java.View;



public class AdminPanel {
    private AutoParkView autoparkView = new AutoParkView();
    private UserView userView = new UserView();
    private ContractView contractView = new ContractView();

    public void showCars(){
        autoparkView.showCars();
    }

    public void addCar(String brand, String info, Integer price){
        autoparkView.addCar(brand, info, price);
    }

    public void removeCarByID(long ID){
        autoparkView.removeCarByID(ID);
    }

    public void updateCar(long carId, String brand, String info, Integer price){
        autoparkView.updateCar(carId, brand, info, price);
    }

    public Long register(String name, String phonenumber){
        return userView.register(name,phonenumber,"admin");
    }

    public void showUsers(){
        userView.showUsers();
    }

    public void showContracts(){contractView.showContracts();}

    public void showApprovedContracts(){contractView.showApprovedContracts();}

    public void showNotApprovedContracts(){contractView.showNotApprovedContracts();}

    public void approveContract(long contractID, long adminID){contractView.approveContract(contractID,adminID);}

}
