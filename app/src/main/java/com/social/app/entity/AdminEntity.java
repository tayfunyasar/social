package com.social.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class AdminEntity extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
