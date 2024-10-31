package com.example.Uber.controllers;

import com.example.Uber.advices.ApiResponse;
import com.example.Uber.dto.*;
import com.example.Uber.entities.User;
import com.example.Uber.repository.UserRepository;
import com.example.Uber.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<UserDto>> signup(@RequestBody SignupDto signupDto) {
        UserDto userDto = authService.signup(signupDto);
        ApiResponse<UserDto> apiResponse =
                new ApiResponse<>(true, "User registered successfully", userDto);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/onBoardNewDriver/{userId}")
    public ResponseEntity<DriverDto> onboardNewDriver(@PathVariable Long userId,
                                                      @RequestBody OnboardDriverDto onboardDriverDto){
        return new ResponseEntity<>(authService.
                onboardNewDriver(userId,onboardDriverDto.getVehicleId()),HttpStatus.CREATED);
    }

    @PostMapping("/login")

    ResponseEntity<ApiResponse<LoginResponseDto>> login(@RequestBody LoginRequestDto loginRequestDto,
                                                        HttpServletRequest httpServletRequest,
                                                        HttpServletResponse httpServletResponse){
        String tokens[]=authService.login(loginRequestDto.getEmail(),
                loginRequestDto.getPassword());

        LoginResponseDto loginResponseDto = new LoginResponseDto(tokens[0]);

        ApiResponse<LoginResponseDto> loginResponseDtoApiResponse=
                new ApiResponse<>(true,"Login successfully",loginResponseDto);

        Cookie cookie=new Cookie("tokens",tokens[1]);

        cookie.setHttpOnly(true);

        httpServletResponse.addCookie(cookie);

        return ResponseEntity.ok(loginResponseDtoApiResponse);
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponseDto> refresh(HttpServletRequest request) {
        String refreshToken = Arrays.stream(request.getCookies()).
                filter(cookie -> "refreshToken".equals(cookie.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElseThrow(() -> new AuthenticationServiceException("Refresh token not found inside the Cookies"));

        String accessToken = authService.refreshToken(refreshToken);

        return ResponseEntity.ok(new LoginResponseDto(accessToken));
    }



    @GetMapping("user")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
