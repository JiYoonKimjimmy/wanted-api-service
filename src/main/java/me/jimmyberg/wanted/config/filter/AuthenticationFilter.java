package me.jimmyberg.wanted.config.filter;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class AuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*
         * TODO 해당 Filter 에서 API 인증 처리
         * username & password 인증 or JWT 인증
         */
        chain.doFilter(request, response);
    }

}
