package com.social.app.entity.user;

import com.social.app.entity.AbstractEntity;
import com.social.app.entity.User;
import com.social.app.enums.UserDataTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class UserData extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(columnDefinition = "text")
    private String data;

    @Enumerated(EnumType.STRING)
    private UserDataTypeEnum type;
}
