package com.example.notification.dtos.request;

import com.example.notification.enums.EmailTemplateType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailTemplateRequestDTO {

    @NotNull(message = "Email template type is required")
    private EmailTemplateType type;

    @NotBlank(message = "Subject is required")
    @Size(max = 255, message = "Subject must be less than 255 characters")
    private String subject;

    @NotBlank(message = "Email body is required")
    @Size(max = 5000, message = "Body must be less than 5000 characters")
    private String body;
}
