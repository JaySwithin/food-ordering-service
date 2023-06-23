package com.swithin.fooddeliveryservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDTO {
    @Schema(defaultValue="false")
    private boolean success;
    private String message;
}