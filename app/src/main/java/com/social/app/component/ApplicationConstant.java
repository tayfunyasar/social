package com.social.app.component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
public class ApplicationConstant {

    @Value("${app.passwordEncoderStrength:2}")
    private int passwordEncoderStrength;
}
