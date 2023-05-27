package management;

import management.dto.Range;
import management.exception.InvalidPortRangeException;
import management.service.PortManagement;
import management.service.PortManagementImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PortController {

    public static void main(String[] args) {
        PortManagement portManagement = new PortManagementImpl(new Range(10000, 12000));

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
                    int numOfPortsNeeded = s.nextInt();
                    System.out.println("Please specify the range:");
                    System.out.println("Range Start: ");
                    int rangeStart = s.nextInt();
                    System.out.println("Range End: ");
                    int rangeEnd = s.nextInt();

                    List<Integer> listOfFreePorts = new ArrayList<>();
                    try {
                        listOfFreePorts = portManagement.getListOfFreePortsInRange(numOfPortsNeeded, new Range(rangeStart, rangeEnd));
                    } catch (InvalidPortRangeException e) {
                        System.out.println("Exception occurred while fetching the list of free ports: " + e.getMessage());
                    }

                    listOfFreePorts.forEach(System.out::println);
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
    }
}
