package com.springboot.config.security;

import com.springboot.service.Impl.UserDetailsServiceImpl;
import com.springboot.service.UserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import static java.awt.SystemColor.info;


@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private  final Logger LOGGER= LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserDetailsService userDetailsService;


    @Value("${springboot.jwt.secret}")
    private String secretKey="secretKey";
    private final long tokenValidMillisecond=1000L*60*60;

    @PostConstruct
    protected void init() {
        LOGGER.info(" initialize secretkey  in [init] JwtTokenProvider");
        secretKey= Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));
        LOGGER.info("completed initializing secretkey  in [init] JwtTokenProvider");
    }

    public String createToken(String userUid, List<String> roles) {
        LOGGER.info("start to create token in [createToken]");
         Claims claims= Jwts.claims().setSubject(userUid);
         claims.put("roles",roles);
         Date now=new Date();


       String  token=Jwts.builder()
                 .setClaims(claims)
                 .setIssuedAt(now)
                 .setExpiration(new Date(now.getTime() + tokenValidMillisecond))
                 .signWith(SignatureAlgorithm.HS256,secretKey)
                 .compact();


         LOGGER.info("completed [createToken] creation");
         return token;
    }

    public Authentication getAuthentication(String token ) {
        LOGGER.info(" retrieve token authentication information in [getAuthentication]");
       UserDetails userDetails =userDetailsService.loadUserByUsername(this.getUsername(token));
         LOGGER.info("complete Token authentication info retrieval UserDetails userName:{}",
                 userDetails.getUsername());

         return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());


    }

    private String getUsername(String token) {
        LOGGER.info("extract [getUser] Token-based User identification info");
        String info=Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
        LOGGER.info("complete extracting [getUser] Token-based User identification info, info:{}",info);
        return info;
    }


    public String resolveToken(HttpServletRequest request) {
        LOGGER.info("[resolveToken] HTTP 헤더에서 Token 값 추출");
        return request.getHeader("X-AUTH-TOKEN");
    }
    public boolean validateToken(String token) {
        LOGGER.info("[validateToken] 토큰 유효 체크 시작");
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            LOGGER.info("[validateToken] 토큰 유효 체크 완료");
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            LOGGER.info("[validateToken] 토큰 유효 체크 예외 발생");
            return false;
        }
    }

}
