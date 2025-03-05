package com.example.Uber.service;

import com.example.Uber.dto.DriverDto;
import com.example.Uber.dto.UserDto;

public interface AdminService {
    UserDto getAllDetails(Long userId);

    DriverDto getUpdateStatus(Long userId);
}
