package com.astrobookings.rockets.services;

import com.astrobookings.rockets.domain.Rocket;
import com.astrobookings.rockets.domain.RocketStatus;
import com.astrobookings.rockets.domain.RocketValidationException;
import com.astrobookings.rockets.repositories.RocketRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class RocketService {
    private final RocketRepository repository;

    public RocketService(RocketRepository repository) {
        this.repository = Objects.requireNonNull(repository, "repository cannot be null");
    }

    public Rocket createRocket(Rocket rocket) {
        Rocket validated = validateRocket(rocket);

        if (repository.existsById(validated.id())) {
            throw new RocketValidationException("Rocket id already exists: " + validated.id());
        }
        if (repository.existsByName(validated.name())) {
            throw new RocketValidationException("Rocket name already exists: " + validated.name());
        }

        return repository.save(validated);
    }

    public Rocket getRocketById(String id) {
        String normalizedId = normalizeRequiredText(id, "Rocket id");
        return repository.findById(normalizedId)
                .orElseThrow(() -> new RocketValidationException("Rocket not found: " + normalizedId));
    }

    public List<Rocket> getAllRockets() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(Rocket::name, String.CASE_INSENSITIVE_ORDER))
                .toList();
    }

    public List<Rocket> findRockets(String nameFilter, RocketStatus statusFilter, int page, int pageSize) {
        if (page < 1) {
            throw new RocketValidationException("Page must be greater than zero");
        }
        if (pageSize < 1) {
            throw new RocketValidationException("Page size must be greater than zero");
        }

        String normalizedFilter = nameFilter == null ? "" : nameFilter.trim();
        String lowerFilter = normalizedFilter.toLowerCase(Locale.ROOT);

        return repository.findAll().stream()
                .filter(rocket -> normalizedFilter.isEmpty()
                        || rocket.name().toLowerCase(Locale.ROOT).contains(lowerFilter))
                .filter(rocket -> statusFilter == null || rocket.status() == statusFilter)
                .sorted(Comparator.comparing(Rocket::name, String.CASE_INSENSITIVE_ORDER))
                .skip((long) (page - 1) * pageSize)
                .limit(pageSize)
                .toList();
    }

    public Rocket updateRocket(String id, Rocket updatedRocket) {
        String normalizedId = normalizeRequiredText(id, "Rocket id");
        Rocket validatedRocket = validateRocket(updatedRocket);

        Rocket existingRocket = repository.findById(normalizedId)
                .orElseThrow(() -> new RocketValidationException("Rocket not found: " + normalizedId));

        if (!Objects.equals(existingRocket.id(), validatedRocket.id())) {
            throw new RocketValidationException("Rocket id is immutable and cannot be changed");
        }

        boolean nameChanged = !Objects.equals(existingRocket.name(), validatedRocket.name());
        if (nameChanged && repository.existsByName(validatedRocket.name())) {
            throw new RocketValidationException("Rocket name already exists: " + validatedRocket.name());
        }

        Rocket mergedRocket = new Rocket(
                normalizedId,
                validatedRocket.name(),
                validatedRocket.model(),
                validatedRocket.status(),
                validatedRocket.payloadKg(),
                validatedRocket.assignedToLaunch());

        return repository.save(mergedRocket);
    }

    public void deleteRocket(String id) {
        String normalizedId = normalizeRequiredText(id, "Rocket id");

        Rocket rocket = repository.findById(normalizedId)
                .orElseThrow(() -> new RocketValidationException("Rocket not found: " + normalizedId));

        if (rocket.assignedToLaunch()) {
            throw new RocketValidationException("Rocket is assigned to an active launch and cannot be deleted: " + normalizedId);
        }

        repository.deleteById(normalizedId);
    }

    public void setAssignedToLaunch(String id, boolean assignedToLaunch) {
        Rocket rocket = getRocketById(id);
        repository.save(rocket.withAssignment(assignedToLaunch));
    }

    private Rocket validateRocket(Rocket rocket) {
        if (rocket == null) {
            throw new RocketValidationException("Rocket cannot be null");
        }

        return new Rocket(
                rocket.id(),
                rocket.name(),
                rocket.model(),
                rocket.status(),
                rocket.payloadKg(),
                rocket.assignedToLaunch());
    }

    private String normalizeRequiredText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new RocketValidationException(fieldName + " is required");
        }
        return value.trim();
    }
}
