package com.social.app.entity;

import com.social.app.entity.user.UserAction;
import com.social.app.entity.user.UserActivityDate;
import com.social.app.entity.user.UserBlock;
import com.social.app.entity.user.UserData;
import com.social.app.entity.user.UserPreferences;
import com.social.app.enums.GenderEnum;
import com.social.app.enums.MBTIEnum;
import com.social.app.enums.RoleEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Audited
@Getter
@Setter
@Builder
@Entity(name = "users")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends AbstractEntity implements UserDetails {

    @NotAudited
    @OneToMany(mappedBy = "fromUser", cascade = CascadeType.ALL)
    private final Set<UserAction> fromActions = new HashSet<>();

    @NotAudited
    @OneToMany(mappedBy = "toUser", cascade = CascadeType.ALL)
    private final Set<UserAction> toActions = new HashSet<>();

    @NotAudited
    @OneToOne(mappedBy = "user")
    private final UserActivityDate activityDate;

    @NotAudited
    @OneToMany(mappedBy = "fromUser", cascade = CascadeType.ALL)
    private final Set<UserBlock> fromBlocks = new HashSet<>();

    @NotAudited
    @OneToMany(mappedBy = "toUser", cascade = CascadeType.ALL)
    private final Set<UserBlock> toBlocks = new HashSet<>();

    @NotAudited
    @OneToMany(mappedBy = "user")
    private final Set<UserData> datas = new HashSet<>();

    @NotAudited
    @OneToOne(mappedBy = "user")
    private final UserPreferences preferences;

    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private LocalDate birthDate;
    private String biography;
    private String languageCode;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private RoleEnum role = RoleEnum.MEMBER;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @Enumerated(EnumType.STRING)
    private MBTIEnum mbti;

    private int countProfileViews;
    private boolean confirmed = false;
    private boolean enabled = false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of((GrantedAuthority) () -> role.name());
    }

    @Override
    public String getUsername() {
        return this.phone;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}

