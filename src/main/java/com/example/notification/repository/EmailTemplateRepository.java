package com.example.notification.repository;

import com.example.notification.entities.EmailTemplate;
import com.example.notification.enums.EmailTemplateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailTemplateRepository extends JpaRepository<EmailTemplate,Long> {
    Optional<EmailTemplate> findByType(EmailTemplateType type);
}
