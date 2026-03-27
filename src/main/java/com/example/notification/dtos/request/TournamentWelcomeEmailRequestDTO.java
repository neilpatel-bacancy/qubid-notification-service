package com.example.notification.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TournamentWelcomeEmailRequestDTO {

    @NotBlank(message = "Player email is required")
    @Email(message = "Invalid email format")
    private String playerEmail;

    @NotBlank(message = "Player name is required")
    private String playerName;

    @NotBlank(message = "Tournament name is required")
    private String tournamentName;

    @NotNull(message = "Start date is required")
    @Future(message = "Start date must be in the future")
    private LocalDate startDate;

    @NotBlank(message = "Location is required")
    private String location;
}