package com.example.notification.controller;

import com.example.notification.dtos.request.EmailTemplateRequestDTO;
import com.example.notification.entities.EmailTemplate;
import com.example.notification.enums.EmailTemplateType;
import com.example.notification.response.ApiResponse;
import com.example.notification.service.EmailTemplateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/templates")
@RequiredArgsConstructor
public class EmailTemplateController {

    private final EmailTemplateService templateService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<String>> saveTemplate(@Valid @RequestBody  EmailTemplateRequestDTO dto) {
        return ResponseEntity.ok(ApiResponse.success(templateService.saveOrUpdateTemplate(dto),"Template saved"));
    }

    @GetMapping("/{type}")
    public ResponseEntity<ApiResponse<EmailTemplate>> getTemplate(@PathVariable(required = true) EmailTemplateType type) {
        return ResponseEntity.ok(ApiResponse.success(templateService.getTemplate(type),"template fetched successfully"));
    }
}