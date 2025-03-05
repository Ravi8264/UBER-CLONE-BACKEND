package com.example.Uber.stratergies.Imp;
import com.example.Uber.entities.RideRequest;
import com.example.Uber.service.DistanceService;
import com.example.Uber.stratergies.RideFareCalculatationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor

public class RiderFairDefaultFareConfigrationStatergy implements RideFareCalculatationStrategy {
    private  final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {

        double distance=distanceService.calculateDistance(rideRequest.getPickupLocation(),
                rideRequest.getDropOffLocation());

        System.out.println(distance);

        return distance*RIDE_FAIR_MULTIPLIER;

    }
}
