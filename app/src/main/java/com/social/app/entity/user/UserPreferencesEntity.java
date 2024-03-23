package com.social.app.entity.user;

import com.social.app.entity.AbstractEntity;
import com.social.app.entity.UserEntity;
import com.social.app.enums.GenderEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.util.Set;
import lombok.Data;

@Data
@Entity
public class UserPreferencesEntity extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private int minAge;
    private int maxAge;
    private Set<GenderEnum> genders;
    private double lat;
    private double lng;
}
