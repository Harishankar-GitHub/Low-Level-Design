package com.port.management;

import com.port.management.dto.Range;
import com.port.management.exception.InvalidPortRangeException;
import com.port.management.service.PortManagement;
import com.port.management.service.PortManagementImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class PortManagementLibraryImpl2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PortManagementLibraryImpl2Application.class, args);
	}

	@Override
	public void run(String... args) {
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
