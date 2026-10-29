package com.springboot.config.security;

import com.springboot.service.Impl.UserDetailsServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Log4j2
public class CustomAccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {

    private  final Logger LOGGER= LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        LOGGER.info("redirect if [handle] is blocked");
        response.sendRedirect("/sign-api/exception");
    }
}
