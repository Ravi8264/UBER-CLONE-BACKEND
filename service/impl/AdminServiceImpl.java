package com.example.Uber.service.impl;

import com.example.Uber.dto.DriverDto;
import com.example.Uber.dto.UserDto;
import com.example.Uber.entities.Driver;
import com.example.Uber.entities.User;
import com.example.Uber.entities.enus.DriverStatus;
import com.example.Uber.exception.ResourceNotFoundException;
import com.example.Uber.repository.DriverRepository;
import com.example.Uber.repository.UserRepository;
import com.example.Uber.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private  final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final DriverRepository driverRepository;
    @Override
    public UserDto getAllDetails(Long userId) {
        User user=userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User not found with this id"+userId));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public DriverDto getUpdateStatus(Long userId) {
        User user=userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User not found with this id"+ userId));
        if(user.getDriverStatus().equals(DriverStatus.PENDING)){
            user.setDriverStatus(DriverStatus.CONFIRM);
        }

        return null;
    }
}
