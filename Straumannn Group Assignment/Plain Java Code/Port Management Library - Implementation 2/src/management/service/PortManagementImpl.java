package management.service;

import management.dto.Range;
import management.exception.InvalidNumberOfFreePortsException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PortManagementImpl implements PortManagement {

    private final List<Integer> freePorts = Collections.synchronizedList(new ArrayList<>());

    public PortManagementImpl(Range portRange) {
        for (int i = portRange.getRangeStartsWith(); i <= portRange.getRangeEndsWith(); i++) {
            freePorts.add(i);
        }
    }

    @Override
    public List<Integer> getListOfFreePortsInRange(int numOfFreePorts, Range portRange) {
        validateNumOfFreePorts(numOfFreePorts);

        List<Integer> freePortsToBeReturned = new ArrayList<>(numOfFreePorts);
        int freePortsAdded = 0;

        synchronized (freePorts) {
            Iterator<Integer> iterator = freePorts.iterator();
            while (iterator.hasNext() && freePortsAdded < numOfFreePorts) {
                int port = iterator.next();
                if (port >= portRange.getRangeStartsWith() && port <= portRange.getRangeEndsWith()) {
                    iterator.remove();
                    freePortsToBeReturned.add(port);
                    freePortsAdded += 1;
                }
            }
        }

        if (freePortsToBeReturned.isEmpty()) {
            System.out.println("No free ports available at the moment!");
        } else {
            System.out.println("Returned " + freePortsToBeReturned.size() + " ports");
        }

        return freePortsToBeReturned;
    }

    private static void validateNumOfFreePorts(int numOfFreePorts) {
        if (numOfFreePorts <= 0 || numOfFreePorts > 55535) {
            System.out.println("Number of free ports should be within 0 < numOfFreePorts <= 55535");
            throw new InvalidNumberOfFreePortsException();
        }
    }
}
