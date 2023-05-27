package com.port.management.service;

import com.port.management.exception.InvalidNumberOfFreePortsException;

import java.util.ArrayList;
import java.util.List;

public class PortManagementImpl implements PortManagement {

    private static final int PORT_STARTS_FROM = 10000;  // Configurable
    private final List<Integer> freePorts = new ArrayList<>();

    @Override
    public synchronized void updateNumOfFreePorts(int numOfFreePorts) {
        System.out.println("Number of free ports to be updated: " + numOfFreePorts);
        validateNumOfFreePorts(numOfFreePorts);
        setNumOfFreePorts(numOfFreePorts);
    }

    @Override
    public synchronized List<Integer> getListOfFreePorts(int numberOfFreePortsNeeded) {
        List<Integer> freePortsToBeReturned = new ArrayList<>(numberOfFreePortsNeeded);
        int freePortsAdded = 1;
        int indexOfFreePort = 0;

        // freePortsCount = 10
        // Need Ports = 5
        // Total Ports List = 10K to 65K reducing
        // Occupied Ports List =

        while (freePortsAdded <= numberOfFreePortsNeeded && indexOfFreePort < freePorts.size()) {
            int freePort = freePorts.get(indexOfFreePort);

            if (freePort == 0) {
                indexOfFreePort += 1;
                continue;
            }

            freePortsToBeReturned.add(freePort);
            freePorts.set(indexOfFreePort, 0);   // Marking the ports as not free.
            freePortsAdded += 1;
        }

        return freePortsToBeReturned.isEmpty() ? returnEmptyList() : freePortsToBeReturned;
    }

    private static void validateNumOfFreePorts(int numOfFreePorts) {
        if (numOfFreePorts <= 0 || numOfFreePorts > 55535) {
            System.out.println("Number of free ports should be within 0 < numOfFreePorts <= 55535");
            throw new InvalidNumberOfFreePortsException();
        }
    }

    private void setNumOfFreePorts(int numOfFreePorts) {
        freePorts.clear();

        for (int i = 0; i < numOfFreePorts; i++) {
            freePorts.add(PORT_STARTS_FROM + i);
        }

        System.out.println("Free ports are updated.");
    }

    private static ArrayList<Integer> returnEmptyList() {
        System.out.println("No free ports available at the moment!");
        return new ArrayList<>();
    }
}
