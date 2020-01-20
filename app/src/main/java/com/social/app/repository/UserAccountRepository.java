package com.social.app.repository;

import com.social.app.entity.UserAccountEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserAccountRepository extends ReactiveCrudRepository<UserAccountEntity, String> {

}
