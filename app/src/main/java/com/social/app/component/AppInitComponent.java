package com.social.app.component;

import com.social.app.controller.GuestController;
import com.social.app.entity.User;
import com.social.app.repository.UserRepository;
import com.social.app.request.UserLoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AppInitComponent {

    private final GuestController guestController;
    private final UserRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {

        if (userRepository.findFirstByPhone("1").isEmpty()) {

            guestController.register(UserLoginRequest.builder().phone("1").password("1").build());

            User byPhone = userRepository.findFirstByPhone("1").orElseThrow();
            byPhone.setBiography("2");
            userRepository.save(byPhone);
        }
    }

}
