package com.credura.credurabank.notification.service;

import com.credura.credurabank.auth_users.entity.User;
import com.credura.credurabank.notification.dtos.NotificationDTO;

public interface NotificationService {

    void sendEmail(NotificationDTO notificationDTO, User user);
}
