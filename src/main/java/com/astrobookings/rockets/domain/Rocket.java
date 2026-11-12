package com.astrobookings.rockets.domain;

public record Rocket(
        String id,
        String name,
        String model,
        RocketStatus status,
        double payloadKg,
        boolean assignedToLaunch
) {
    public Rocket {
        id = validateRequiredText(id, "Rocket id");
        name = validateRequiredText(name, "Rocket name");
        model = validateRequiredText(model, "Rocket model");

        if (status == null) {
            throw new RocketValidationException("Rocket status is required");
        }
        if (payloadKg <= 0) {
            throw new RocketValidationException("Rocket payload must be greater than zero");
        }
    }

    public Rocket withName(String newName) {
        return new Rocket(id, newName, model, status, payloadKg, assignedToLaunch);
    }

    public Rocket withModel(String newModel) {
        return new Rocket(id, name, newModel, status, payloadKg, assignedToLaunch);
    }

    public Rocket withStatus(RocketStatus newStatus) {
        return new Rocket(id, name, model, newStatus, payloadKg, assignedToLaunch);
    }

    public Rocket withPayloadKg(double newPayloadKg) {
        return new Rocket(id, name, model, status, newPayloadKg, assignedToLaunch);
    }

    public Rocket withAssignment(boolean assigned) {
        return new Rocket(id, name, model, status, payloadKg, assigned);
    }

    private static String validateRequiredText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new RocketValidationException(fieldName + " is required");
        }
        String trimmed = value.trim();
        if (trimmed.isEmpty()) {
            throw new RocketValidationException(fieldName + " is required");
        }
        return trimmed;
    }
}
