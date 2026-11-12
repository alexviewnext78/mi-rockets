package com.astrobookings.rockets.domain;

public class RocketValidationException extends IllegalArgumentException {
    public RocketValidationException(String message) {
        super(message);
    }
}
