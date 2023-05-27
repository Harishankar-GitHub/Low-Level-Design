package com.port.management.service;

import java.util.List;

public interface PortManagement {
    void updateNumOfFreePorts(int numOfFreePorts);
    List<Integer> getListOfFreePorts(int numberOfFreePortsNeeded);
}
