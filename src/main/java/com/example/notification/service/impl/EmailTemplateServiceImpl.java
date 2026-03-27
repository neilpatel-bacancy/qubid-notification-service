package com.example.notification.service.impl;

import com.example.notification.dtos.request.EmailTemplateRequestDTO;
import com.example.notification.entities.EmailTemplate;
import com.example.notification.enums.EmailTemplateType;
import com.example.notification.repository.EmailTemplateRepository;
import com.example.notification.service.EmailTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailTemplateServiceImpl implements EmailTemplateService {

    private final EmailTemplateRepository repository;

    @Override
    public String saveOrUpdateTemplate(EmailTemplateRequestDTO dto) {

        EmailTemplate template = repository
                .findByType(dto.getType())
                .orElse(
                        EmailTemplate.builder()
                                .type(dto.getType())
                                .build()
                );

        template.setSubject(dto.getSubject());
        template.setBody(dto.getBody());

        repository.save(template);

        return "Template saved successfully";
    }

    @Override
    public EmailTemplate getTemplate(EmailTemplateType type) {
        return repository.findByType(type)
                .orElseThrow(() -> new RuntimeException("Template not found"));
    }
}