package com.example.Uber.stratergies;

import com.example.Uber.entities.RideRequest;

public interface RideFareCalculatationStrategy {
    int RIDE_FAIR_MULTIPLIER=10;
    double calculateFare(RideRequest rideRequest);

}
