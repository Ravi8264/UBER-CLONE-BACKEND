package com.example.Uber.service.impl;

import com.example.Uber.dto.DriverDto;
import com.example.Uber.dto.RiderDto;
import com.example.Uber.entities.Driver;
import com.example.Uber.entities.Rating;
import com.example.Uber.entities.Ride;
import com.example.Uber.entities.Rider;
import com.example.Uber.exception.ResourceNotFoundException;
import com.example.Uber.repository.DriverRepository;
import com.example.Uber.repository.RatingRepository;
import com.example.Uber.repository.RiderRepository;
import com.example.Uber.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServiceImp implements RatingService {

    private final RatingRepository ratingRepository;

    private final DriverRepository driverRepository;

    private final RiderRepository riderRepository;

    private final ModelMapper modelMapper;

    @Override
    public DriverDto rateDriver(Ride ride, Integer rating) {
        Driver driver=ride.getDriver();

        Rating ratingObj=ratingRepository.findByRide(ride).orElseThrow(()->
                new ResourceNotFoundException("Rating is not found for ride with this id "
                        +ride.getId()));

        if(ratingObj.getDriverRating() !=null)
            throw new RuntimeException("Driver has already been rated");

        ratingObj.setDriverRating(rating);

        ratingRepository.save(ratingObj);

        Double newRating=ratingRepository.findByDriver(driver)
                .stream()
                .mapToDouble(Rating::getDriverRating)
                .average().orElse(0.0);

        driver.setRating(newRating);

      Driver saveDriver=  driverRepository.save(driver);
      return  modelMapper.map(saveDriver,DriverDto.class);
    }

    @Override
    public RiderDto rateRider(Ride ride, Integer rating) {

        Rider rider=ride.getRider();

        Rating ratingObj=ratingRepository.findByRide(ride).orElseThrow(()->
                new ResourceNotFoundException("Rating is not found for ride with this id "
                        +ride.getId()));
        if(ratingObj.getRiderRating() !=null)
            throw new RuntimeException("Rider has already been rated");

        ratingObj.setRiderRating(rating);

        ratingRepository.save(ratingObj);

        Double newRating=ratingRepository.findByRider(rider)
                .stream()
                .mapToDouble(Rating::getRiderRating)
                .average().orElse(0.0);

        rider.setRating(newRating);

       Rider saveRider= riderRepository.save(rider);

       return modelMapper.map(saveRider, RiderDto.class);
    }

    @Override
    public void createNewRating(Ride ride) {
        Rating rating=Rating.builder()
                .rider(ride.getRider())
                .driver(ride.getDriver())
                .ride(ride)
                .build();
        ratingRepository.save(rating);
    }
}
