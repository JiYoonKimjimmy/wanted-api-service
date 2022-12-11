package me.jimmyberg.wanted.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Configuration
public class SecurityConfig implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // TODO API 인증 절차가 필요한 경우, 해당 함수 구현
        System.out.println("authentication.getName() = " + authentication.getName());
        System.out.println("authentication.getCredentials() = " + authentication.getCredentials());
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}
