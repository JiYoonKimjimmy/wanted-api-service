package me.jimmyberg.wanted.config;

import me.jimmyberg.wanted.config.filter.AuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // CORS 설정
                .cors().and()
                // form login 비활성화
                .httpBasic().disable()
                // CSRF 보안 비활성화
                .csrf().disable()
                // session 생성 없이 인증 처리
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 인증 처리 Filter 등록
                .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        // TODO CORS 설정
        CorsConfiguration configuration = new CorsConfiguration();
        // 허용 origin 설정
        configuration.setAllowedOrigins(List.of("*"));
        // 허용 method 설정
        configuration.setAllowedMethods(List.of("GET", "POST"));
        // 허용 header 설정
        configuration.setAllowedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}
