package com.example.authservice.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class HttpConfigurer extends AbstractHttpConfigurer<HttpConfigurer, HttpSecurity> {

    private final JwtUtil jwtUtil;

    @Override
    public void init(HttpSecurity builder) throws Exception{
        builder
                .cors().and().csrf().disable()
                .authorizeRequests((auth)->{
                    auth
                            .antMatchers("/api/v1/register").permitAll()
                            .antMatchers("/login").permitAll()
                            .anyRequest()
                            .authenticated();
                })
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(HttpSecurity builder) throws Exception{
        AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);

        builder
                .addFilter(new JwtAuthenticationFilter(authenticationManager))
                .addFilterBefore(new JwtAuthorizationFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);

    }

    public static HttpConfigurer httpConfigurer(){
        return new HttpConfigurer(new JwtUtil());
    }
}
