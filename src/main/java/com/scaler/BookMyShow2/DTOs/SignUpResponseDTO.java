package com.scaler.BookMyShow2.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDTO {
    private long userId;
    private String message;
    private ResponseStatus status;
}
