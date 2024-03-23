package com.social.app.entity.message;

import com.social.app.entity.AbstractEntity;
import com.social.app.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class MessageEntity extends AbstractEntity {

    @ManyToOne
    private UserEntity from;

    @ManyToOne
    private UserEntity to;

    @Column(columnDefinition = "text", updatable = false)
    private String content;
}
