package ru.java.service;


import ru.java.domain.Car;
import ru.java.domain.Contract;
import ru.java.domain.User;
import ru.java.persestance.DBAutoPark;

import java.util.List;

public class ContractService {
    private DBAutoPark contractStore = new DBAutoPark();



    public List<Contract> getContracts() {
        return contractStore.getAllContracts();
    }



    public boolean addContract(String createdAt, String endAt, Long clientID, Long carID){
        Car carForContract = contractStore.getCarById(carID);
        if(carForContract != null){
            Contract contract = new Contract(createdAt, endAt, clientID, carForContract);
            return contractStore.addContract(contract);
        }
        else return false;
    }

    public List<Contract> getApprovedContracts(){
        return contractStore.getApprovedContracts();
    }

    public List<Contract> getNotApprovedContracts(){
        return contractStore.getNotApprovedContracts();
    }

    public List<Contract> getApprovedContractsForClient(Long clientID){
        return contractStore.getApprovedContractsForClient(clientID);
    }

    public List<Contract> getNotApprovedContractsForClient(Long clientID){
        return contractStore.getNotApprovedContractsForClient(clientID);
    }

    public boolean approveContract(Long contractID, Long adminId){
        return contractStore.approveContract(contractID, new User(adminId));
    }


}
