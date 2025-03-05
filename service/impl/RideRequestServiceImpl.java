package com.example.Uber.service.impl;
import com.example.Uber.advices.ApiError;
import com.example.Uber.advices.ApiResponse;
import com.example.Uber.entities.RideRequest;
import com.example.Uber.repository.RideRequestRepository;
import com.example.Uber.service.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId)
                .orElseThrow(() -> new RuntimeException(
                        new ApiResponse<>(new ApiError(
                                "Ride request not found with this id: "
                                        + rideRequestId,
                                HttpStatus.BAD_REQUEST
                        )).toString()
                ));
    }

    @Override
    public void update(RideRequest rideRequest) {
        rideRequestRepository.findById(rideRequest.getId()).orElseThrow(() ->
                new RuntimeException(
                        new ApiResponse<>(new ApiError(
                                "Ride request not found with this id: "
                                        + rideRequest.getId(),
                                HttpStatus.BAD_REQUEST
                        )).toString()
                )
        );
        rideRequestRepository.save(rideRequest);

    }

}

