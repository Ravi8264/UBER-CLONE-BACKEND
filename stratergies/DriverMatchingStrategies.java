package com.example.Uber.stratergies;

import com.example.Uber.entities.Driver;
import com.example.Uber.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategies {

     List<Driver> findMatchingDriver(RideRequest rideRequest);
}
