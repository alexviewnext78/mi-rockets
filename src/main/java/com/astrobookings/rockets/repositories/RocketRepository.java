package com.astrobookings.rockets.repositories;

import com.astrobookings.rockets.domain.Rocket;

import java.util.List;
import java.util.Optional;

public interface RocketRepository {
    Rocket save(Rocket rocket);

    Optional<Rocket> findById(String id);

    List<Rocket> findAll();

    void deleteById(String id);

    boolean existsById(String id);

    boolean existsByName(String name);
}
