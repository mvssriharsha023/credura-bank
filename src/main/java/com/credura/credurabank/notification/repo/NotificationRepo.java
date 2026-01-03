package com.credura.credurabank.notification.repo;

import com.credura.credurabank.notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification, Long> {

}
