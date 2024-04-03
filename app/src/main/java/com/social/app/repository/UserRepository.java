package com.social.app.repository;

import com.social.app.entity.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, RevisionRepository<User, Long, Long> {

    Optional<User> findFirstByPhone(String phone);
}
