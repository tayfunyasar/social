package com.social.app.entity.message;

import com.social.app.entity.AbstractEntity;
import com.social.app.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Message extends AbstractEntity {

    @ManyToOne
    private User from;

    @ManyToOne
    private User to;

    @Column(columnDefinition = "text", updatable = false)
    private String content;
}
