package com.example.Uber.service;

import com.example.Uber.entities.Driver;
import com.example.Uber.entities.Ride;
import com.example.Uber.entities.RideRequest;
import com.example.Uber.entities.Rider;
import com.example.Uber.entities.enus.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;



public interface RideService {

    Ride getRideById(Long rideId);


    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest);
}
