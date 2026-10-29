package com.springboot.config.security;

import com.springboot.service.Impl.UserDetailsServiceImpl;
import com.springboot.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private  final Logger LOGGER= LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String token=jwtTokenProvider.resolveToken(request);
        LOGGER.info("completed token extraction [doFilterInternal]. token:{}",token);

        LOGGER.info("start checking token validation");

        if(token !=null && jwtTokenProvider.validateToken(token)) {
            Authentication authentication =jwtTokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            LOGGER.info("completed [doFilterInternal] checking token validation");
        }

        filterChain.doFilter(request,response);

    }
}
