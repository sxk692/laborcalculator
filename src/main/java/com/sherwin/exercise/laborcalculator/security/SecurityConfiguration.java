package com.sherwin.exercise.laborcalculator.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
//public class SecurityConfiguration extends WebSecurityConfiguration {
//
//    // Created this bean to ignore authenitication for h2-console as it has its own already
//    // https://stackoverflow.com/questions/43794721/spring-boot-h2-console-throws-403-with-spring-security-1-5-2
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer(){
//        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
//    }

//}
