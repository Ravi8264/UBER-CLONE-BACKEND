package com.example.Uber.repository;

import com.example.Uber.entities.Driver;
import com.example.Uber.entities.Rating;
import com.example.Uber.entities.Ride;
import com.example.Uber.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating,Long> {
    List<Rating> findByRider(Rider rider);
    List<Rating> findByDriver(Driver driver);

    Optional<Rating> findByRide(Ride ride);
}