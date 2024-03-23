package com.social.app.entity;

import com.social.app.entity.user.UserActivityDateEntity;
import com.social.app.entity.user.UserDataEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class UserEntity extends AbstractEntity {

    private String firstName;
    private String lastName;
    private String password;

    private String phone;
    private int countProfileViews;
    private int countProfileSearch;

    private String biography;
    private String languageCode;

    private boolean confirmed = false;
    private boolean disabled = false;

    @OneToMany
    private List<UserDataEntity> profilePicture;

    @OneToOne
    private UserActivityDateEntity activityDate;
}

