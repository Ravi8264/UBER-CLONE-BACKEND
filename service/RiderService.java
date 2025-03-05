package com.example.Uber.service;

import com.example.Uber.dto.DriverDto;
import com.example.Uber.dto.RideDto;
import com.example.Uber.dto.RideRequestDto;
import com.example.Uber.dto.RiderDto;
import com.example.Uber.entities.Rider;
import com.example.Uber.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RiderService {

 RideRequestDto requestRide(RideRequestDto rideRequestDto);

 RideDto cancelRide(Long rideId);

 DriverDto rateDriver(Long rideId, Integer rating);

 RiderDto getMyProfile();

 Page<RideDto> getAllMyRides(PageRequest pageRequest);

 Rider createNewRider(User user);

 Rider getCurrentRider();


}