package com.social.app.entity;

import com.social.app.entity.user.UserAction;
import com.social.app.entity.user.UserActivityDate;
import com.social.app.entity.user.UserBlock;
import com.social.app.entity.user.UserData;
import com.social.app.entity.user.UserPreferences;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity(name = "users")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends AbstractEntity {

    @OneToMany(mappedBy = "from", cascade = CascadeType.ALL)
    private final Set<UserAction> fromActions = new HashSet<>();

    @OneToMany(mappedBy = "to", cascade = CascadeType.ALL)
    private final Set<UserAction> toActions = new HashSet<>();

    @OneToOne
    private final UserActivityDate activityDate;

    @OneToMany(mappedBy = "from", cascade = CascadeType.ALL)
    private final Set<UserBlock> fromBlocks = new HashSet<>();

    @OneToMany(mappedBy = "to", cascade = CascadeType.ALL)
    private final Set<UserBlock> toBlocks = new HashSet<>();

    @OneToMany
    private final Set<UserData> datas = new HashSet<>();

    @OneToOne
    private final UserPreferences preferences;

    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private int countProfileViews;
    private String biography;
    private String languageCode;
    private boolean confirmed = false;
    private boolean disabled = false;
}

