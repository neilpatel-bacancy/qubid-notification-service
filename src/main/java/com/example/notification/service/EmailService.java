package com.example.notification.service;

import com.example.notification.dtos.request.PlayerSoldEmailRequestDTO;
import com.example.notification.dtos.request.TournamentWelcomeEmailRequestDTO;
import com.example.notification.dtos.response.EmailResponseDto;

public interface EmailService {
    EmailResponseDto sendPlayerSoldEmail(PlayerSoldEmailRequestDTO request);
    EmailResponseDto sendTournamentWelcomeEmail(TournamentWelcomeEmailRequestDTO request);
}
