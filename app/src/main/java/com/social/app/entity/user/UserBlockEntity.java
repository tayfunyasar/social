package com.social.app.entity.user;

import com.social.app.entity.AbstractEntity;
import com.social.app.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class UserBlockEntity extends AbstractEntity {

    @ManyToOne
    private UserEntity from;

    @ManyToOne
    private UserEntity to;
}
