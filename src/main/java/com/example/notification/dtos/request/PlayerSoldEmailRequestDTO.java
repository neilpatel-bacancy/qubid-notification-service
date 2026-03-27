package com.example.notification.dtos.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerSoldEmailRequestDTO {
    @NotBlank(message = "Player email is required")
    @Email(message = "Invalid email format")
    private String playerEmail;

    @NotBlank(message = "Player name is required")
    private String playerName;

    @NotBlank(message = "Franchise name is required")
    private String franchiseName;

    @NotNull(message = "Sold price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Sold price must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Invalid price format")
    private BigDecimal soldPrice;

    @NotBlank(message = "Tournament name is required")
    private String tournamentName;
}
