package com.example.notification.dtos.response;

import com.example.notification.enums.EmailStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EmailResponseDto {
    private EmailStatus status;
    private String message;
    private LocalDateTime sentAt;
}