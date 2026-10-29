package com.springboot.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.dto.EntryPointErrorResponse;
import com.springboot.service.Impl.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {
    private  final Logger LOGGER= LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException, ServletException {
         ObjectMapper objectMapper=new ObjectMapper();
        LOGGER.info("since [commence] authentication failed then response.sendError occurs");

        EntryPointErrorResponse entryPointErrorResponse=new EntryPointErrorResponse();
        entryPointErrorResponse.setMsg("failed to authenticate");

        response.setStatus(401);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(objectMapper.writeValueAsString(entryPointErrorResponse));

    }
}
