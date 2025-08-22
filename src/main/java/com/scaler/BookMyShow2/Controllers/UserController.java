package com.scaler.BookMyShow2.Controllers;

import com.scaler.BookMyShow2.DTOs.*;
import com.scaler.BookMyShow2.Models.User;
import com.scaler.BookMyShow2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

//    @Autowired
//    public UserController(UserService userService){
//        this.userService = userService;
//    }

    public SignUpResponseDTO signUp(SignUpRequestDTO requestDTO){
        SignUpResponseDTO responseDTO = new SignUpResponseDTO();
        try{

            // Basic input validations
            User user = userService.signUp(requestDTO.getName(), requestDTO.getEmail(), requestDTO.getPassword());

            responseDTO.setMessage("User signed up successfully");
            responseDTO.setUserId(user.getId());
            responseDTO.setStatus(ResponseStatus.SUCCESS);
        }catch(Exception e){
            System.out.println("User sign failed with error - " + e.getMessage());
            responseDTO.setStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("User sign up failed");
        }
        return  responseDTO;
    }

    public LoginResponseDTO login(LoginRequestDTO requestDTO){
        LoginResponseDTO responseDTO = new LoginResponseDTO();
        try{
            userService.login(requestDTO.getEmail(), requestDTO.getPassword());
            responseDTO.setMessage("User login successfull");
            responseDTO.setStatus(ResponseStatus.SUCCESS);
        }catch(Exception e){
            System.out.println("User login failed with error - " + e.getMessage());
            responseDTO.setStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("User sign up failed");
        }
        return responseDTO;
    }
}
