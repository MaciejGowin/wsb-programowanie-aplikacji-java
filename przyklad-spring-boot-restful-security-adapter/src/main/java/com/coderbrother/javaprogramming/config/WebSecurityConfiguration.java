package com.coderbrother.javaprogramming.config;

import com.coderbrother.javaprogramming.security.filter.JwtAuthenticationFilter;
import com.coderbrother.javaprogramming.security.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtService jwtService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.csrf()
                .disable();

        http.addFilterBefore(jwtAuthenticationFilter(), LogoutFilter.class);

        http
                .authorizeRequests()
                    .antMatchers("/**/accountLogin").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .logout()
                .permitAll();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtService);
    }
}
