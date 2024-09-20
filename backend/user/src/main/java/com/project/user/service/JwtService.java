package com.project.user.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class JwtService {
    private final String secret_key="36F4A8EB4B18CAC332F9DBA5DC1E1775D6EB45BCDD6F9F90B741791B65724758";
    private final long exp_time= TimeUnit.MINUTES.toMillis(30);

    public String generateToken(UserDetails userDetails){
        log.info("gen token username {}",userDetails.getUsername());
        Map<String,Object> claims=new HashMap<>();
        claims.put("iss","SecureAPI");
        claims.put("aud","Authorized Users");
        return Jwts.builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plusMillis(exp_time)))
                .signWith(generatekey())
                .compact();
    }

    private SecretKey generatekey(){
        byte[] decodedKey = Base64.getDecoder().decode(secret_key);
        return Keys.hmacShaKeyFor(decodedKey);
    }

    public boolean validateToken(String token){
        Claims claims=getClaims(token);
        log.info("Claims {} from token {}",claims,token);
        return claims.getExpiration().after(Date.from(Instant.now()));
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(generatekey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUsername(String token){
        Claims claims=getClaims(token);
        return claims.getSubject();
    }

}
