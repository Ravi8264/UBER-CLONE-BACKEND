package com.example.Uber.service;

import com.example.Uber.dto.DriverDto;
import com.example.Uber.dto.SignupDto;
import com.example.Uber.dto.UserDto;

public interface AuthService {

    String []login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId,String vehicleId);

    String refreshToken(String refreshToken);

//    UserDto getAllDetails(int driverId);
}
