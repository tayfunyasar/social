package com.social.app.entity;

import com.social.app.entity.user.UserActivityDate;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "users")
public class User extends AbstractEntity {

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

    @OneToOne
    private UserActivityDate activityDate;

    public String getProfilePicture() {
        
    }
}

