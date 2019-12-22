package ru.java.View;

import ru.java.domain.Contract;
import ru.java.service.ContractService;


import java.util.List;

public class ContractView {

    private ContractService contractService = new ContractService();

    public void showContracts() {
        System.out.println("--- All contracts: ---");
        List<Contract> contracts = contractService.getContracts();
        if (contracts.size() == 0) {
            System.out.println("No contracts yet");
        } else {
            for (Contract contract : contracts) {
                System.out.println(contract);
            }
        }
    }

    public void showApprovedContracts() {
        System.out.println("--- All approved contracts: ---");
        List<Contract> contracts = contractService.getApprovedContracts();
        if (contracts.size() == 0) {
            System.out.println("No approved contracts yet");
        } else {
            for (Contract contract : contracts) {
                System.out.println(contract);
            }
        }
    }

    public void showNotApprovedContracts() {
        System.out.println("--- All not approved contracts: ---");
        List<Contract> contracts = contractService.getNotApprovedContracts();
        if (contracts.size() == 0) {
            System.out.println("No not approved contracts yet");
        } else {
            for (Contract contract : contracts) {
                System.out.println(contract);
            }
        }

    }

    public void showApprovedContractsForClient(Long clientID) {
        System.out.println("--- Your approved contracts: ---");
        List<Contract> contracts = contractService.getApprovedContractsForClient(clientID);
        if (contracts.size() == 0) {
            System.out.println("No approved contracts yet");
        } else {
            for (Contract contract : contracts) {
                System.out.println(contract);
            }
        }
    }

    public void showNotApprovedContractsForClient(Long clientID) {
        System.out.println("--- Your not approved contracts: ---");
        List<Contract> contracts = contractService.getNotApprovedContractsForClient(clientID);
        if (contracts.size() == 0) {
            System.out.println("No not approved contracts yet");
        } else {
            for (Contract contract : contracts) {
                System.out.println(contract);
            }
        }
    }


    public void addContract(String createdAt, String endAt, Long clientID, Long carID) {

        if (contractService.addContract(createdAt, endAt, clientID, carID))
            System.out.println("Contract has been added");
        else
            System.out.println("Error, wrong car ID");
    }

    public void approveContract(Long contractID, Long adminID) {
        if (contractService.approveContract(contractID, adminID)) {
            System.out.println(String.format("Contract with id = %d has been approved", contractID));
        } else
            System.out.println(String.format("Contract with id = %d doesn't exist", contractID));
    }

}
