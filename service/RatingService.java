package com.example.Uber.service;

import com.example.Uber.dto.DriverDto;
import com.example.Uber.dto.RiderDto;
import com.example.Uber.entities.Ride;


public interface RatingService {

    DriverDto rateDriver(Ride ride, Integer rating);

    RiderDto rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);

}
