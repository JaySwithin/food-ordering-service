package com.swithin.fooddeliveryservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDTO {
    private boolean success;
    private String message;
}