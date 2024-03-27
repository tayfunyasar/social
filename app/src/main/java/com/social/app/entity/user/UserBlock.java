package com.social.app.entity.user;

import com.social.app.entity.AbstractEntity;
import com.social.app.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class UserBlock extends AbstractEntity {

    @ManyToOne
    private User from;

    @ManyToOne
    private User to;
}
