package com.social.app.entity.user;

import com.social.app.entity.AbstractEntity;
import com.social.app.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
public class UserActivityDateEntity extends AbstractEntity {

    @OneToOne
    private UserEntity user;

    private LocalDateTime birthDate;
    
    private LocalDateTime loginDate;
    private LocalDateTime intentionChangeDate;
    private LocalDateTime notificationDate;
    private LocalDateTime notificationCheckedDate;
    private LocalDateTime messageDate;
    private LocalDateTime messageCheckedDate;
    private LocalDateTime latestDonationDate;
}
