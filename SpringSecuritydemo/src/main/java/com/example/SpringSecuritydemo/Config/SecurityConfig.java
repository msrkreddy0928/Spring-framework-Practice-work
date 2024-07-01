package com.example.SpringSecuritydemo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.beans.Encoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    // @Bean
    // public UserDetailsService userDeatilsService(){
    // UserDetails userDetails = User.builder()
    //        .username("shiva")
    //        .password("$2a$10$DxMGw2TIKvT67MAQ55hRAus74iuXsZnU2tf0rKEGsKCzBEqa/peU2")
    //        .build();
    // UserDetails userDetails1= User.builder()
    //     .username("revi")
    //     .password("$2a$10$2sz9Eent7Xj/APqRgQb6eeWv0nhDru1Fkga79h3HEnHnIzUd6DWlu")
    // .build();
    // return new InMemoryUserDetailsManager(userDetails,userDetails1);


//}
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests((auth)-> {
            auth.requestMatchers("/public")
                    .permitAll()
                    .anyRequest()
                    .authenticated();

        })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());


        return httpSecurity.build();
    }


}
