package com.example.Uber.controllers;

import com.example.Uber.dto.DriverDto;
import com.example.Uber.dto.UserDto;
import com.example.Uber.entities.User;
import com.example.Uber.repository.UserRepository;
import com.example.Uber.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private  final UserRepository userRepository;
    private final AdminService adminService;

    @GetMapping("/user/{userId}")
    public UserDto getDetails(@PathVariable Long userId) {

        UserDto userDto=adminService.getAllDetails(userId);

        return  userDto;

    }

    @PutMapping("/user/{userId}")
//    @PreAuthorize("hasRole('ADMIN')")
    public  DriverDto getUpdateStatus(@PathVariable Long userId){
        DriverDto driverDto=adminService.getUpdateStatus(userId);
        return driverDto;
    }

    @GetMapping("user")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
