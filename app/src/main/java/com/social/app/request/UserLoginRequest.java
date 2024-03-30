package com.social.app.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {

    @NotBlank(message = "email not blank")
    @Email(message = "this is not an email")
    private String email;

    @NotBlank(message = "password not blank")
    private String password;
}
