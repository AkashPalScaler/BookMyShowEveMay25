package com.scaler.BookMyShow2.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {
    private String message;
    private ResponseStatus status;
}
