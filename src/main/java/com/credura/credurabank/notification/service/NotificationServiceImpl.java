package com.credura.credurabank.notification.service;

import com.credura.credurabank.auth_users.entity.User;
import com.credura.credurabank.enums.NotificationType;
import com.credura.credurabank.notification.dtos.NotificationDTO;
import com.credura.credurabank.notification.entity.Notification;
import com.credura.credurabank.notification.repo.NotificationRepo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepo notificationRepo;
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Override
    public void sendEmail(NotificationDTO notificationDTO, User user) {

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(
                    mimeMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name()
            );
            helper.setTo(notificationDTO.getRecipient());
            helper.setSubject(notificationDTO.getSubject());

            if (notificationDTO.getTemplateName() != null) {
                // Use template if provided
                Context context = new Context();
                context.setVariables(notificationDTO.getTemplateVariables());
                String htmlContent = templateEngine.process(notificationDTO.getTemplateName(), context);
                helper.setText(htmlContent, true);
            }
            else {
                // if no template sent, text body will be used directly
                helper.setText(notificationDTO.getBody(), true);
            }
            mailSender.send(mimeMessage);

            // save to our database table
            Notification notificationToSave = Notification.builder()
                    .recipient(notificationDTO.getRecipient())
                    .subject(notificationDTO.getSubject())
                    .body(notificationDTO.getBody())
                    .type(NotificationType.EMAIL)
                    .user(user)
                    .build();

            notificationRepo.save(notificationToSave);

        }
        catch (MessagingException e) {
            log.error(e.getMessage());
        }
    }
}
