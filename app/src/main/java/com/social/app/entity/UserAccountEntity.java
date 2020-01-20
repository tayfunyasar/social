package com.social.app.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("user_account")
public class UserAccountEntity {

    @Id
    private String id;
    private String name;
}
