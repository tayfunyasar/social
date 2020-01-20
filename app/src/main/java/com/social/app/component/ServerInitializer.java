package com.social.app.component;

import com.social.app.AppApplication;
import com.social.app.entity.UserAccountEntity;
import com.social.app.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class ServerInitializer {

    private static final Logger logger = LoggerFactory.getLogger(AppApplication.class);

    private final UserAccountRepository userRepository;

    private final FlywayMigrationInitializer flywayMigrationInitializer;

    @PostConstruct
    public void init() {

        logger.debug("starting");
        Flux<UserAccountEntity> all = userRepository.findAll();
        logger.debug("fetching");
        all.doOnNext(userEntity -> {
            logger.debug("user {}", userEntity);
        }).subscribe();
    }
}
