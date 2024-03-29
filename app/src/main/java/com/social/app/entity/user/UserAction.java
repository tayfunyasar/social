package com.social.app.entity.user;

import com.social.app.entity.AbstractEntity;
import com.social.app.entity.User;
import com.social.app.enums.UserActionTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class UserAction extends AbstractEntity {

    @ManyToOne
    private User from;

    @ManyToOne
    private User to;

    @Enumerated(EnumType.STRING)
    private UserActionTypeEnum type;
}
