package com.example;

import com.astrobookings.rockets.domain.Rocket;
import com.astrobookings.rockets.domain.RocketStatus;
import com.astrobookings.rockets.repositories.InMemoryRocketRepository;
import com.astrobookings.rockets.services.RocketService;

public class Main {
    public static void main(String[] args) {
        RocketService rocketService = new RocketService(new InMemoryRocketRepository());

        rocketService.createRocket(new Rocket("R-101", "Atlas", "Atlas V", RocketStatus.ACTIVE, 15000, false));
        rocketService.createRocket(new Rocket("R-202", "Aquila", "Aquila 1", RocketStatus.MAINTENANCE, 12000, false));

        System.out.println("All rockets:");
        rocketService.getAllRockets().forEach(System.out::println);
    }
}

