package com.example.notification.service;

import com.example.notification.dtos.request.EmailTemplateRequestDTO;
import com.example.notification.entities.EmailTemplate;
import com.example.notification.enums.EmailTemplateType;

public interface EmailTemplateService {
    String saveOrUpdateTemplate(EmailTemplateRequestDTO dto);

    EmailTemplate getTemplate(EmailTemplateType type);
}
