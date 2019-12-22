package ru.java.View;
import java.util.Scanner;

public class MainMenu {
    private Scanner in = new Scanner(System.in);
    private Scanner input = new Scanner(System.in);

    private Long sessionID;
    private static final String delimiter = "; ";

    public void show() {
        input.useDelimiter(delimiter);
        System.out.println("Enter your name; phoneNumber");
        String name = input.next();
        String phoneNumber = input.nextLine().substring(delimiter.length());
        System.out.println("Enter your role: 1-admin, 2-client");
        int choice = in.nextInt();

        if(choice == 1){
            AdminPanel adminPanel = new AdminPanel();
            sessionID = adminPanel.register(name,phoneNumber);
            while (true) {
                System.out.println("====Menu====");
                System.out.println("1. Show cars (Enter 1)");
                System.out.println("2. Add car (Enter 2)");
                System.out.println("3. Delete car (Enter 3)");
                System.out.println("4. Update car (Enter 4)");
                System.out.println("5. Show users (Enter 5)");
                System.out.println("6. Show all contracts (Enter 6)");
                System.out.println("7. Show all approved contracts (Enter 7)");
                System.out.println("8. Show all not approved contracts (Enter 8)");
                System.out.println("9. Approve contract (Enter 9)");
                System.out.println("10. Back (Enter 10)");
                System.out.println("11. Exit (Enter 11)");

                int menuitem = in.nextInt();
                int carId;
                String brand;
                String info;
                Integer price;
                switch (menuitem) {
                    case 1:
                        adminPanel.showCars();
                        break;
                    case 2:
                        System.out.println("Enter car brand; price; info ");
                        brand = input.next();
                        price= input.nextInt();
                        info = input.nextLine();

                        adminPanel.addCar(brand, info.substring(2), price);
                        break;
                    case 3:
                        System.out.println("Enter car ID: ");
                        carId = in.nextInt();
                        adminPanel.removeCarByID((long)carId);
                        break;
                    case 4:
                        System.out.println("Enter car ID: ");
                        carId = in.nextInt();
                        System.out.println("Enter car brand; price; info ");
                        brand = input.next();
                        price= input.nextInt();
                        info = input.nextLine();

                        adminPanel.updateCar(carId, brand, info.substring(2), price);
                        break;
                    case 5:
                        adminPanel.showUsers();
                        break;
                    case 6:
                        adminPanel.showContracts();
                        break;
                    case 7:
                        adminPanel.showApprovedContracts();
                        break;
                    case 8:
                        adminPanel.showNotApprovedContracts();
                        break;
                    case 9:
                        System.out.println("Enter contract ID:");
                        int contractID = in.nextInt();
                        adminPanel.approveContract((long)contractID, sessionID);
                        break;
                    case 10:
                        show();
                        break;
                    case 11:
                        System.exit(0);
                }


            }
        }
        else{
            ClientPanel clientPanel = new ClientPanel();
            sessionID = clientPanel.register(name,phoneNumber);
//            Date beginning;
//            Date ending;
            String beginning;
            String ending;
            Integer carId;
            while (true) {
                System.out.println("====Menu====");
                System.out.println("1. Show cars (Enter 1)");
                System.out.println("2. Add contract (Enter 2)");
                System.out.println("3. Show your approved contracts (Enter 3)");
                System.out.println("4. Show your not approved contracts (Enter 4)");
                System.out.println("5. Back (Enter 5)");
                System.out.println("10. Exit (Enter 10)");

                int menuitem = in.nextInt();
                switch (menuitem){
                    case 1:
                        clientPanel.showCars();
                        break;
                    case 2:
                        //SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
                        System.out.println("Enter date of beginning; carID; date of ending; ");
                       // try{
                            beginning = input.next();
                            carId = input.nextInt();
//                            ending= s.parse(input.nextLine().substring(delimiter.length()));
                            ending= input.nextLine().substring(delimiter.length());

                            clientPanel.addContract(beginning, ending, sessionID, (long)carId);
                        //}
//                        catch (ParseException e){
//                            System.out.println("Incorrect date input ");
//                        }
                        break;
                    case 3:
                        clientPanel.showApprovedContractsForClient(sessionID);
                        break;
                    case 4:
                        clientPanel.showNotApprovedContractsForClient(sessionID);
                        break;
                    case 5:
                        show();
                        break;
                    case 10:
                        System.exit(0);
                }
            }
        }



    }
}
