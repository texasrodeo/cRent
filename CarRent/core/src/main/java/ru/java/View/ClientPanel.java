package ru.java.View;

public class ClientPanel {
    private AutoParkView autoparkView = new AutoParkView();
    private UserView userView = new UserView();
    private ContractView contractView = new ContractView();

    public void showCars(){
        autoparkView.showCars();
    }

    public Long register(String name, String phoneNumber){
        return userView.register(name,phoneNumber,"client");
    }





    public void showApprovedContractsForClient(Long ID){contractView.showApprovedContractsForClient(ID);}

    public void showNotApprovedContractsForClient(Long ID){contractView.showNotApprovedContractsForClient(ID);}

    public void addContract(String createdAt, String endsAt, Long ID, Long carID){contractView.addContract(createdAt,endsAt,ID,carID);}


}
