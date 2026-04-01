package com.example.notification.controller;

import com.example.notification.dtos.request.FranchiseRegisterEmailRequestDTO;
import com.example.notification.dtos.request.PlayerSoldEmailRequestDTO;
import com.example.notification.dtos.request.TournamentWelcomeEmailRequestDTO;
import com.example.notification.dtos.response.EmailResponseDto;
import com.example.notification.response.ApiResponse;
import com.example.notification.service.impl.EmailServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailServiceImpl emailService;

    @PostMapping("/player-sold")
    public ResponseEntity<ApiResponse<EmailResponseDto>> sendPlayerSoldEmail(
            @RequestBody @Valid PlayerSoldEmailRequestDTO request) {
        EmailResponseDto emailResponseDto = emailService.sendPlayerSoldEmail(request);
        return ResponseEntity.ok(ApiResponse.success(emailResponseDto,"player sold mail sent"));
    }

    @PostMapping("/tournament-welcome")
    public ResponseEntity<ApiResponse<EmailResponseDto>> sendTournamentWelcomeEmail(
            @RequestBody @Valid TournamentWelcomeEmailRequestDTO request) {
        EmailResponseDto emailResponseDto = emailService.sendTournamentWelcomeEmail(request);
        return ResponseEntity.ok(ApiResponse.success(emailResponseDto,"welcome mail sent"));
    }

    @PostMapping("/franchise-register")
    public ResponseEntity<ApiResponse<EmailResponseDto>> sendFranchiseRegisterEmail(
            @RequestBody @Valid FranchiseRegisterEmailRequestDTO request) {
        EmailResponseDto emailResponseDto = emailService.sendFranchiseRegisterEmail(request);
        return ResponseEntity.ok(ApiResponse.success(emailResponseDto, "Franchise mail sent"));
    }

}
