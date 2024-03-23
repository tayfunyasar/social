package com.social.app.entity.user;

import com.social.app.entity.AbstractEntity;
import com.social.app.entity.UserEntity;
import com.social.app.enums.UserActionTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class UserActionEntity extends AbstractEntity {

    @ManyToOne
    private UserEntity from;

    @ManyToOne
    private UserEntity to;

    private UserActionTypeEnum type;
}
