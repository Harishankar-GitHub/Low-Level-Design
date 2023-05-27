import management.exception.InvalidNumberOfFreePortsException;
import management.service.PortManagement;
import management.service.PortManagementImpl;

import java.util.List;
import java.util.Scanner;

public class PortController {

    public static void main(String[] args) {
        PortManagement portManagement = new PortManagementImpl();

        printAvailableActions();
        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            int action = s.nextInt();

            switch (action) {
                case 0 :
                    printAvailableActions();
                    break;
                case 1:
                    System.out.println("Number of needed ports:");
                    List<Integer> listOfFreePorts = portManagement.getListOfFreePorts(s.nextInt());
                    listOfFreePorts.forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Number of free ports: 0 < numberOfFreePorts <= 55535");
                    try {
                        portManagement.updateNumOfFreePorts(s.nextInt());
                    } catch (InvalidNumberOfFreePortsException e) {
                        System.out.println("Exception occurred while updating the number of free ports: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid action");
                    printAvailableActions();
                    break;
            }
        }

        s.close();
    }

    private static void printAvailableActions() {
        System.out.println("Available actions are:");
        System.out.println("0. Show available actions");
        System.out.println("1. List of free ports present in a device.");
        System.out.println("2. Update number of free ports: 0 < numberOfFreePorts <= 55535");
    }
}
