package com.social.app.entity.user;

import com.social.app.entity.AbstractEntity;
import com.social.app.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class UserActivityDate extends AbstractEntity {

    @OneToOne
    private User user;

    private LocalDateTime loginDate;
    private LocalDateTime notificationDate;
    private LocalDateTime notificationSeenDate;
    private LocalDateTime messageDate;
    private LocalDateTime messageSeenDate;
}
