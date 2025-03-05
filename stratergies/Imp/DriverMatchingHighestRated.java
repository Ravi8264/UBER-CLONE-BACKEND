package com.example.Uber.stratergies.Imp;
import com.example.Uber.entities.Driver;
import com.example.Uber.entities.RideRequest;
import com.example.Uber.repository.DriverRepository;
import com.example.Uber.stratergies.DriverMatchingStrategies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingHighestRated implements DriverMatchingStrategies {

   private  final DriverRepository driverRepository;
    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findMatchingTenNearestDriver(rideRequest.getPickupLocation());
    }
}
