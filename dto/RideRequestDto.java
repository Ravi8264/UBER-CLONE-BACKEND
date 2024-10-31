package com.example.Uber.dto;

import com.example.Uber.entities.enus.PaymentMethod;
import com.example.Uber.entities.enus.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {

    private Long id;

    private PointDto pickupLocation;

    private PointDto dropOffLocation;

    private PaymentMethod paymentMethod;

    private LocalDateTime requestedTime;

    private RiderDto rider;

    private Double fare;

    private RideRequestStatus rideRequestStatus;
}
