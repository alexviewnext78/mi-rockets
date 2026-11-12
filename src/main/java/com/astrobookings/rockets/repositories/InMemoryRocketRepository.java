package com.astrobookings.rockets.repositories;

import com.astrobookings.rockets.domain.Rocket;
import com.astrobookings.rockets.domain.RocketValidationException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryRocketRepository implements RocketRepository {
    private final Map<String, Rocket> rocketsById = new HashMap<>();

    @Override
    public Rocket save(Rocket rocket) {
        if (rocket == null) {
            throw new RocketValidationException("Rocket cannot be null");
        }

        String normalizedId = normalizeText(rocket.id());
        Rocket normalizedRocket = new Rocket(
                normalizedId,
                rocket.name(),
                rocket.model(),
                rocket.status(),
                rocket.payloadKg(),
                rocket.assignedToLaunch());

        rocketsById.entrySet().removeIf(entry -> entry.getKey().equalsIgnoreCase(normalizedId));
        rocketsById.put(normalizedId, normalizedRocket);
        return normalizedRocket;
    }

    @Override
    public Optional<Rocket> findById(String id) {
        String normalizedId = normalizeText(id);
        if (normalizedId == null) {
            return Optional.empty();
        }

        return rocketsById.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(normalizedId))
                .map(Map.Entry::getValue)
                .findFirst();
    }

    @Override
    public List<Rocket> findAll() {
        return new ArrayList<>(rocketsById.values());
    }

    @Override
    public void deleteById(String id) {
        String normalizedId = normalizeText(id);
        if (normalizedId == null) {
            return;
        }
        rocketsById.entrySet().removeIf(entry -> entry.getKey().equalsIgnoreCase(normalizedId));
    }

    @Override
    public boolean existsById(String id) {
        String normalizedId = normalizeText(id);
        if (normalizedId == null) {
            return false;
        }
        return rocketsById.keySet().stream()
                .anyMatch(key -> key.equalsIgnoreCase(normalizedId));
    }

    @Override
    public boolean existsByName(String name) {
        String normalizedName = normalizeText(name);
        if (normalizedName == null) {
            return false;
        }
        return rocketsById.values().stream()
                .anyMatch(rocket -> normalizeText(rocket.name()).equalsIgnoreCase(normalizedName));
    }

    private String normalizeText(String value) {
        if (value == null) {
            return null;
        }
        String trimmed = value.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }
}
