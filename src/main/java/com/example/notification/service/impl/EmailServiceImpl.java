package com.example.notification.service.impl;

import com.example.notification.dtos.request.PlayerSoldEmailRequestDTO;
import com.example.notification.dtos.request.TournamentWelcomeEmailRequestDTO;
import com.example.notification.dtos.response.EmailResponseDto;
import com.example.notification.entities.EmailTemplate;
import com.example.notification.enums.EmailStatus;
import com.example.notification.enums.EmailTemplateType;
import com.example.notification.repository.EmailTemplateRepository;
import com.example.notification.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final EmailTemplateRepository templateRepository;
    private final SpringTemplateEngine templateEngine;

    @Override
    public EmailResponseDto sendPlayerSoldEmail(PlayerSoldEmailRequestDTO request) {

        EmailTemplate template = templateRepository
                .findByType(EmailTemplateType.PLAYER_SOLD)
                .orElseThrow(() -> new RuntimeException("Template not found"));

        Context context = new Context();
        context.setVariable("playerName", request.getPlayerName());
        context.setVariable("franchiseName", request.getFranchiseName());
        context.setVariable("soldPrice", request.getSoldPrice());
        context.setVariable("tournamentName", request.getTournamentName());

        String html = templateEngine.process(template.getBody(), context);

        sendHtmlMail(request.getPlayerEmail(), template.getSubject(), html);

        return EmailResponseDto.builder()
                .status(EmailStatus.SENT)
                .message("Player sold email sent successfully")
                .sentAt(LocalDateTime.now())
                .build();

    }

    @Override
    public EmailResponseDto sendTournamentWelcomeEmail(TournamentWelcomeEmailRequestDTO request) {

        EmailTemplate template = templateRepository
                .findByType(EmailTemplateType.TOURNAMENT_WELCOME)
                .orElseThrow(() -> new RuntimeException("Template not found"));

        Context context = new Context();
        context.setVariable("playerName", request.getPlayerName());
        context.setVariable("tournamentName", request.getTournamentName());
        context.setVariable("location", request.getLocation());
        context.setVariable("startDate", request.getStartDate());

        String html = templateEngine.process(template.getBody(), context);

        sendHtmlMail(request.getPlayerEmail(), template.getSubject(), html);
        return EmailResponseDto.builder()
                .status(EmailStatus.SENT)
                .message("Player welcome email sent successfully")
                .sentAt(LocalDateTime.now())
                .build();
    }

    private void sendHtmlMail(String to, String subject, String html) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(html, true);

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Email sending failed", e);
        }
    }

}