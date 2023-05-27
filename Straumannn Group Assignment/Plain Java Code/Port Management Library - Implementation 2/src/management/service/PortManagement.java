package management.service;

import management.dto.Range;

import java.util.List;

public interface PortManagement {
    List<Integer> getListOfFreePortsInRange(int numOfFreePorts, Range portRange);
}
