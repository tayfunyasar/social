package com.social.app.config;

import com.social.app.enums.RoleEnum;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(requests ->
                requests
                    .requestMatchers("/api/admin/**").hasRole(RoleEnum.ADMIN.name())
                    .requestMatchers("/app/admin/**").hasRole(RoleEnum.ADMIN.name())
                    .requestMatchers("/app/**").hasAnyRole(RoleEnum.MEMBER.name(), RoleEnum.ADMIN.name())
                    .anyRequest().permitAll()
            )
            .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
            .logout(logout -> logout.permitAll())
            .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .formLogin(httpSecurityFormLoginConfigurer -> {
                httpSecurityFormLoginConfigurer.permitAll();
                httpSecurityFormLoginConfigurer.loginPage("/login-form");
            })
            .headers(httpSecurityHeadersConfigurer -> {
                httpSecurityHeadersConfigurer.frameOptions(frameOptionsCustomizer -> {
                    //  frameOptionsCustomizer.sameOrigin();
                });
            })
            .userDetailsService(userDetailsService)
        ;

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer ignoringCustomizer() {
        return web -> web.ignoring().requestMatchers("/resources/**", "/static/**");
    }

    @Bean
    public WebSecurityCustomizer debugSecurity() {
        return web -> web.debug(true);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
