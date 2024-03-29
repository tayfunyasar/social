package com.social.app.entity.user;

import com.social.app.entity.AbstractEntity;
import com.social.app.entity.User;
import com.social.app.enums.GenderEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import java.util.Set;
import lombok.Data;

@Data
@Entity
public class UserPreferences extends AbstractEntity {

    @OneToOne
    private User user;

    private int minAge;
    private int maxAge;

    @Enumerated(EnumType.STRING)
    private Set<GenderEnum> genders;
    
    private double lat;
    private double lng;
    private int distance;
}
