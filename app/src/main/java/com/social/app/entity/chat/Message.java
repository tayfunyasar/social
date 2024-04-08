package com.social.app.entity.chat;

import com.social.app.entity.AbstractEntity;
import com.social.app.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
public class Message extends AbstractEntity {

    @ManyToOne
    private User fromUser;

    @ManyToOne
    private User toUser;

    @Column(columnDefinition = "text", updatable = false)
    private String content;

    private LocalDateTime lastSeenDate;
}
